package com.github.piotrkozuch.payu4j.exception;

public class PayU4JException extends RuntimeException {

    public PayU4JException(Exception e) {
        super(e);
    }

    public PayU4JException(String msg) {
        super(msg);
    }
}
