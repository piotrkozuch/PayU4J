package com.github.piotrkozuch.payu4j.type;

public class Email extends PayU4JType<String> {

    private Email(String value) {
        super(value);
    }

    public static Email from(String value) {
        return new Email(value);
    }
}
