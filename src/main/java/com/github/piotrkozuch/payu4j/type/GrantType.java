package com.github.piotrkozuch.payu4j.type;

public class GrantType extends PayU4JType<String> {

    private GrantType(String value) {
        super(value);
    }

    public static GrantType from(String value) {
        return new GrantType(value);
    }
}
