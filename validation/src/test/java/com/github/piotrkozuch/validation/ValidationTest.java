package com.github.piotrkozuch.validation;

import org.junit.jupiter.api.Test;

import static com.github.piotrkozuch.validation.Validation.required;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {

    @Test
    void should_throw_exception_if_null() {
        assertThrows(IllegalArgumentException.class, () -> required("name", null));
    }

    @Test
    void should_return_object_if_not_null() {
        // given
        var object = "Text";

        // when
        var result = required("name", object);

        // then
        assertEquals(object, result);
    }
}