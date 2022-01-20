package com.github.piotrkozuch.payu4j.type;

public class Quantity extends PayU4JType<Integer> {

    private Quantity(Integer value) {
        super(value);
    }

    public static Quantity from(Integer value) {
        return new Quantity(value);
    }
}
