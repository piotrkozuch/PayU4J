package com.github.piotrkozuch.payu4j.type;

public class Description extends PayU4JType<String> {

    private Description(String value) {
        super(value);
    }

    public static Description from(String value) {
        return new Description(value);
    }
}
