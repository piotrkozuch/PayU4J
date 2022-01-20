package com.github.piotrkozuch.payu4j.type;

public class LastName extends PayU4JType<String> {

    private LastName(String value) {
        super(value);
    }

    public static LastName from(String value) {
        return new LastName(value);
    }
}
