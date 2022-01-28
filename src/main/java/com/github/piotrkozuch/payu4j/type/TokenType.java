package com.github.piotrkozuch.payu4j.type;

public class TokenType extends PayU4JType<String> {

    private TokenType(String value) {
        super(value);
    }

    public static TokenType from(String value) {
        return new TokenType(value);
    }
}
