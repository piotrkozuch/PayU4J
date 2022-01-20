package com.github.piotrkozuch.payu4j.type;

public class Name extends PayU4JType<String> {

    private Name(String value) {
        super(value);
    }

    public static Name from(String value) {
        return new Name(value);
    }
}
