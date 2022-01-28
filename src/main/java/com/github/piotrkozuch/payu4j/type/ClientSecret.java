package com.github.piotrkozuch.payu4j.type;

public class ClientSecret extends PayU4JType<String> {

    private ClientSecret(String value) {
        super(value);
    }

    public static ClientSecret from(String value) {
        return new ClientSecret(value);
    }
}
