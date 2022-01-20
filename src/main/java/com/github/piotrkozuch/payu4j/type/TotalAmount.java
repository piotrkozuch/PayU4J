package com.github.piotrkozuch.payu4j.type;

public class TotalAmount extends PayU4JType<Long> {

    private TotalAmount(Long value) {
        super(value);
    }

    public static TotalAmount from(Long value) {
        return new TotalAmount(value);
    }
}
