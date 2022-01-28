package com.github.piotkozuch.log;

import java.time.LocalDateTime;

import static com.github.piotkozuch.log.LoggingLevel.DEBUG;
import static com.github.piotkozuch.log.LoggingLevel.ERROR;
import static com.github.piotkozuch.log.LoggingLevel.INFO;
import static com.github.piotkozuch.log.LoggingLevel.WARN;
import static com.github.piotrkozuch.validation.Validation.required;
import static java.lang.String.format;

public class ConsoleLogger implements Logger {

    private final String fullClassName;
    private final boolean debug;

    public ConsoleLogger(Class<?> clazz, boolean debug) {
        this.fullClassName = required("clazz", clazz).getCanonicalName();
        this.debug = debug;
    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    @Override
    public void info(String message, Object... params) {
        log(INFO, message, params);
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebug()) {
            log(DEBUG, message, params);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        log(WARN, message, params);
    }

    @Override
    public void error(String message, Object... params) {
        log(ERROR, message, params);
    }

    private void log(LoggingLevel level, String message, Object... params) {
        final var formattedMessage = format(message.replace("{}", "%s"), params);
        System.out.printf("%s [%s] [%s] - %s%n", level, LocalDateTime.now(), fullClassName, formattedMessage);
    }
}
