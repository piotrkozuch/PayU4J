package com.github.piotrkozuch.payu4j.type;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class PayU4JType<T> {

    public final T value;

    public PayU4JType(T value) {
        this.value = requireNonNull(value);
    }

    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayU4JType<?> that = (PayU4JType<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
