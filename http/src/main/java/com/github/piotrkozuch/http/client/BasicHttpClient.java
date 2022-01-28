package com.github.piotrkozuch.http.client;

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
import java.util.stream.Stream;

import static com.github.piotrkozuch.validation.Validation.required;

public class BasicHttpClient {

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
        return httpClient.send(request, BodyHandlers.ofString());
    }

    private HttpRequest httpPOSTRequest(URL url, String body, HttpHeader... headers) throws URISyntaxException {
        final var requestBuilder = HttpRequest.newBuilder()
            .uri(url.toURI())
            .timeout(DEFAULT_TIMEOUT)
            .POST(HttpRequest.BodyPublishers.ofString(body));

        Stream.of(headers).forEach(httpHeader -> requestBuilder.header(httpHeader.key, httpHeader.value));

        return requestBuilder.build();
    }
}
