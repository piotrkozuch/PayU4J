package com.github.piotrkozuch.payu4j.client.http;

import com.github.piotrkozuch.http.client.BasicHttpClient;
import com.github.piotrkozuch.http.exception.HttpClientException;
import com.github.piotrkozuch.payu4j.client.PayU4JApi;
import com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest;
import com.github.piotrkozuch.payu4j.client.response.AuthorizationResponse;
import com.github.piotrkozuch.payu4j.client.response.OrderCreateResponse;
import com.github.piotrkozuch.payu4j.type.ClientId;
import com.github.piotrkozuch.payu4j.type.ClientSecret;
import com.github.piotrkozuch.payu4j.type.GrantType;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.time.Duration;

import static com.github.piotrkozuch.http.UrlBuilder.urlBuilder;
import static com.github.piotrkozuch.payu4j.json.Json.parse;
import static com.github.piotrkozuch.validation.Validation.required;

public class PayU4JHttpClient extends BasicHttpClient implements PayU4JApi {

    private static final String AUTHORIZATION_PATH = "/pl/standard/user/oauth/authorize";

    private final URI basUri;

    public PayU4JHttpClient(HttpClient httpClient, URI basUri) {
        super(httpClient);
        this.basUri = required("baseUri", basUri);
    }

    @Override
    public AuthorizationResponse authorize(GrantType grantType, ClientId clientId, ClientSecret clientSecret) {
        final var authUri = urlBuilder(basUri)
            .path(AUTHORIZATION_PATH)
            .parameter("grant_type", grantType.value)
            .parameter("client_id", clientId.value)
            .parameter("client_secret", clientSecret.value)
            .build();

        final var httpResponse = doPOST(authUri);

        if (httpResponse.statusCode() != 200) {
            throw new HttpClientException(httpResponse.statusCode(), httpResponse.body());
        }

        return parse(httpResponse.body(), AuthorizationResponse.class);
    }

    @Override
    public OrderCreateResponse create(OrderCreateRequest request) {
        return null;
    }

    public static void main(String[] args) {

        try {
            var cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);

            var client = new PayU4JHttpClient(HttpClient
                .newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(5))
                .cookieHandler(cookieManager)
                .build(), URI.create("https://secure.snd.payu.com"));

            var auth = client.authorize(
                GrantType.from("client_credentials"),
                ClientId.from("426893"),
                ClientSecret.from("5a58e094de8f48e2358f775e0aa43ad0"));
            System.out.println(auth.tokenType);
            System.out.println(auth.grantType);
            System.out.println(auth.accessToken);
            System.out.println(auth.expiresIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
