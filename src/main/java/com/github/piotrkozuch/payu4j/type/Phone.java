package com.github.piotrkozuch.payu4j.type;

public class Phone extends PayU4JType<String> {

    private Phone(String value) {
        super(value);
    }

    public static Phone from(String value) {
        return new Phone(value);
    }
}
