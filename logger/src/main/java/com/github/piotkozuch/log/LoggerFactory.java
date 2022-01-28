package com.github.piotkozuch.log;

public final class LoggerFactory {

    private LoggerFactory() {

    }

    public static Logger getLogger(Class<?> clazz) {
        return new ConsoleLogger(clazz, true);
    }
}
