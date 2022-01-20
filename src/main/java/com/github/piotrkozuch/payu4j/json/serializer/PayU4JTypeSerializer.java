package com.github.piotrkozuch.payu4j.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.piotrkozuch.payu4j.type.PayU4JType;

import java.io.IOException;

public class PayU4JTypeSerializer<T extends PayU4JType<?>> extends StdSerializer<T> {

    public PayU4JTypeSerializer() {
        this(null);
    }

    public PayU4JTypeSerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T payU4JType,
                          JsonGenerator generator,
                          SerializerProvider provider) throws IOException {

        generator.writeString(payU4JType.toString());
    }
}
