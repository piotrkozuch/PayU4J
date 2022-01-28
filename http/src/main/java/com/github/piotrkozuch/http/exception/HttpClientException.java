package com.github.piotrkozuch.http.exception;

import static java.lang.String.format;

public class HttpClientException extends RuntimeException {

    public HttpClientException(Exception e) {
        super(e);
    }

    public HttpClientException(int statusCode, String body) {
        super(format("Status code %d. %s", statusCode, body));
    }
}
