package com.github.piotkozuch.log;

public interface Logger {

    boolean isDebug();

    void info(String message, Object... params);

    void debug(String message, Object... params);

    void warn(String message, Object... params);

    void error(String message, Object... params);
}
