package com.github.piotrkozuch.payu4j.type;

public class ExtOrderId extends PayU4JType<String> {

    private ExtOrderId(String value) {
        super(value);
    }

    public static ExtOrderId from(String value) {
        return new ExtOrderId(value);
    }
}
