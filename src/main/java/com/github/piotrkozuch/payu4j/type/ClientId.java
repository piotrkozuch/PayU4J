package com.github.piotrkozuch.payu4j.type;

public class ClientId extends PayU4JType<String> {

    private ClientId(String value) {
        super(value);
    }

    public static ClientId from(String value) {
        return new ClientId(value);
    }
}
