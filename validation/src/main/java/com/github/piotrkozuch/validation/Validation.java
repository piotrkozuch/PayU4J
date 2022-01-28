package com.github.piotrkozuch.validation;

import static java.lang.String.format;

public final class Validation {

    private Validation() {

    }

    public static <T> T required(String name, T object) {
        if (object == null) {
            throw new IllegalArgumentException(format("Param '%s' is required", name));
        }
        return object;
    }
}
