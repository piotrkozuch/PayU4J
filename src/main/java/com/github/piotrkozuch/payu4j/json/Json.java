package com.github.piotrkozuch.payu4j.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.piotrkozuch.payu4j.exception.PayU4JException;
import com.github.piotrkozuch.payu4j.json.serializer.UnitPriceSerializer;
import com.github.piotrkozuch.payu4j.type.UnitPrice;

public class Json {

    private static final ObjectMapper OBJECT_MAPPER = initObjectMapper();

    public static String toJson(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new PayU4JException(e);
        }
    }

    private static ObjectMapper initObjectMapper() {
        final var objectMapper = new ObjectMapper();

        final var module = new SimpleModule();
        module.addSerializer(UnitPrice.class, new UnitPriceSerializer());

        objectMapper.registerModule(module);
        return objectMapper;
    }
}
