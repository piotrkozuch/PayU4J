package com.github.piotrkozuch.payu4j.type;

import com.github.piotrkozuch.payu4j.exception.PayU4JException;

import java.net.MalformedURLException;
import java.net.URL;

public class NotifyUrl extends PayU4JType<URL> {

    private NotifyUrl(URL value) {
        super(value);
    }

    public static NotifyUrl from(String url) {
        try {
            return from(new URL(url));
        } catch (MalformedURLException e) {
            throw new PayU4JException(e);
        }
    }

    public static NotifyUrl from(URL value) {
        return new NotifyUrl(value);
    }
}
