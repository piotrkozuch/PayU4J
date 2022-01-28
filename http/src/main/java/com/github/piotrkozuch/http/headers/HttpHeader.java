package com.github.piotrkozuch.http.headers;

import static com.github.piotrkozuch.validation.Validation.required;

public class HttpHeader {

    public final String key;
    public final String value;

    public HttpHeader(String key, String value) {
        this.key = required("key", key);
        this.value = required("value", value);
    }
}
