package com.github.piotrkozuch.payu4j.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.piotrkozuch.payu4j.exception.PayU4JException;
import com.github.piotrkozuch.payu4j.json.serializer.PayU4JTypeSerializer;
import com.github.piotrkozuch.payu4j.type.CurrencyCode;
import com.github.piotrkozuch.payu4j.type.CustomerIp;
import com.github.piotrkozuch.payu4j.type.Description;
import com.github.piotrkozuch.payu4j.type.Email;
import com.github.piotrkozuch.payu4j.type.ExtOrderId;
import com.github.piotrkozuch.payu4j.type.FirstName;
import com.github.piotrkozuch.payu4j.type.Language;
import com.github.piotrkozuch.payu4j.type.LastName;
import com.github.piotrkozuch.payu4j.type.MerchantPosId;
import com.github.piotrkozuch.payu4j.type.Name;
import com.github.piotrkozuch.payu4j.type.NotifyUrl;
import com.github.piotrkozuch.payu4j.type.Phone;
import com.github.piotrkozuch.payu4j.type.Quantity;
import com.github.piotrkozuch.payu4j.type.TotalAmount;
import com.github.piotrkozuch.payu4j.type.UnitPrice;

import java.util.List;

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
        List.of(UnitPrice.class,
                CurrencyCode.class,
                CustomerIp.class,
                Email.class,
                Description.class,
                FirstName.class,
                LastName.class,
                Language.class,
                MerchantPosId.class,
                Name.class,
                NotifyUrl.class,
                Phone.class,
                Quantity.class,
                TotalAmount.class,
                ExtOrderId.class)
            .forEach(clazz -> module.addSerializer(clazz, new PayU4JTypeSerializer<>()));

        objectMapper.registerModule(module);
        return objectMapper;
    }

    public static JsonNode parse(String body) {
        try {
            return OBJECT_MAPPER.readTree(body);
        } catch (JsonProcessingException e) {
            throw new PayU4JException(e);
        }
    }
}
