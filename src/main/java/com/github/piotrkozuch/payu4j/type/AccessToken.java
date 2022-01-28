package com.github.piotrkozuch.payu4j.type;

public class AccessToken extends PayU4JType<String> {

    private AccessToken(String value) {
        super(value);
    }

    public static AccessToken from(String value) {
        return new AccessToken(value);
    }
}
