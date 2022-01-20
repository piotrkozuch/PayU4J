package com.github.piotrkozuch.payu4j.type;

public class CurrencyCode extends PayU4JType<String> {

    private CurrencyCode(String value) {
        super(value);
    }

    public static CurrencyCode from(String value) {
        return new CurrencyCode(value);
    }
}
