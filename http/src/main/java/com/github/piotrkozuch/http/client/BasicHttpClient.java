package com.github.piotrkozuch.http.client;

import com.github.piotkozuch.log.Logger;
import com.github.piotkozuch.log.LoggerFactory;
import com.github.piotrkozuch.http.exception.HttpClientException;
import com.github.piotrkozuch.http.headers.HttpHeader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.piotrkozuch.validation.Validation.required;
import static java.util.function.Predicate.not;

public class BasicHttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(BasicHttpClient.class);

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);

    protected final HttpClient httpClient;

    public BasicHttpClient(HttpClient httpClient) {
        this.httpClient = required("httpClient", httpClient);
    }

    protected HttpResponse<String> doPOST(URL url) {
        return doPOST(url, "");
    }

    protected HttpResponse<String> doPOST(URL url, String body, HttpHeader... headers) {
        try {
            final var request = httpPOSTRequest(required("uri", url), required("body", body), headers);

            return send(request);
        } catch (Exception e) {
            throw new HttpClientException(e);
        }
    }

    private HttpResponse<String> send(HttpRequest request) throws IOException, InterruptedException {
        final var response = httpClient.send(request, BodyHandlers.ofString());
        logResponse(response);
        return response;
    }

    private HttpRequest httpPOSTRequest(URL url, String body, HttpHeader... headers) throws URISyntaxException {
        logRequest("POST", url, body, headers);

        final var requestBuilder = HttpRequest.newBuilder()
            .uri(url.toURI())
            .timeout(DEFAULT_TIMEOUT)
            .POST(HttpRequest.BodyPublishers.ofString(body));

        Stream.of(headers)
            .peek(httpHeader -> LOG.debug("{} {}", httpHeader.key, httpHeader.value))
            .forEach(httpHeader -> requestBuilder.header(httpHeader.key, httpHeader.value));

        return requestBuilder.build();
    }

    private void logRequest(String method, URL url, String body, HttpHeader[] headers) {
        LOG.info("*** [HTTP REQUEST] ***");
        LOG.info("OUT: {} {}", method, url);

        Stream.of(headers)
            .forEach(header -> LOG.debug("HTTP HEADER: {}:{}", header.key, header.value));

        logBody(body);

        LOG.info("*** [END HTTP REQUEST] ***");
    }

    private void logResponse(HttpResponse<String> response) {
        LOG.info("*** [HTTP RESPONSE] ***");
        LOG.info("IN: {}", response.uri());

        response.headers().map().entrySet()
                .stream().forEach(e -> LOG.info("HTTP HEADER: {}:{}", e.getKey(), e.getValue().stream()
                .collect(Collectors.joining(","))));
        logBody(response.body());

        LOG.info("*** [END HTTP RESPONSE] ***");
    }

    private void logBody(String body) {
        Optional.ofNullable(body)
            .filter(not(String::isBlank))
            .ifPresent(b -> LOG.debug("--- BODY ---\n{}\n--- BODY ---", b));
    }
}
