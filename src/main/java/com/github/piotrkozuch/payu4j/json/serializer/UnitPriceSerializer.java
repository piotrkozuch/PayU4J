package com.github.piotrkozuch.payu4j.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.piotrkozuch.payu4j.type.UnitPrice;

import java.io.IOException;

public class UnitPriceSerializer extends StdSerializer<UnitPrice> {

    public UnitPriceSerializer() {
        this(null);
    }

    public UnitPriceSerializer(Class<UnitPrice> t) {
        super(t);
    }

    @Override
    public void serialize(UnitPrice unitPrice,
                          JsonGenerator generator,
                          SerializerProvider provider) throws IOException {

        generator.writeString(unitPrice.value.toString());

    }
}
