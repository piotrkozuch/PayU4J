package com.github.piotrkozuch.payu4j.type;

public class Language extends PayU4JType<String> {

    private Language(String value) {
        super(value);
    }

    public static Language from(String value) {
        return new Language(value);
    }
}
