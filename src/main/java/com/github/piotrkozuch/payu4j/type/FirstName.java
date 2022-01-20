package com.github.piotrkozuch.payu4j.type;

public class FirstName extends PayU4JType<String> {

    private FirstName(String value) {
        super(value);
    }

    public static FirstName from(String value) {
        return new FirstName(value);
    }
}
