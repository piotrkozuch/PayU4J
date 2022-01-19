package com.github.piotrkozuch.payu4j.test;

import com.github.piotrkozuch.payu4j.exception.PayU4JException;

import java.io.File;
import java.nio.file.Files;

public interface TestUtils {

    static String loadResource(String name) {
        try {
            final var data = TestUtils.class.getResourceAsStream(name).readAllBytes();
            return new String(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PayU4JException(e);
        }
    }
}
