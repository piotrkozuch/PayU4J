package com.github.piotrkozuch.payu4j.type;

public class CustomerIp extends PayU4JType<String> {

    private CustomerIp(String value) {
        super(value);
    }

    public static CustomerIp from(String value) {
        return new CustomerIp(value);
    }
}
