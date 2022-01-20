package com.github.piotrkozuch.payu4j.type;

public class UnitPrice extends PayU4JType<Long> {

    private UnitPrice(Long value) {
        super(value);
    }

    public static UnitPrice from(Long value) {
        return new UnitPrice(value);
    }
}
