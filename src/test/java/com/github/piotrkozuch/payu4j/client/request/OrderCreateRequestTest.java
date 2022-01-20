package com.github.piotrkozuch.payu4j.client.request;

import com.github.piotrkozuch.payu4j.json.Json;
import org.junit.jupiter.api.Test;

import static com.github.piotrkozuch.payu4j.test.OrderTestData.newOrderRequest;
import static com.github.piotrkozuch.payu4j.test.OrderTestData.orderCreateRequestJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderCreateRequestTest {

    private final static String BUYER_KEY = "buyer";
    private final static String NOTIFY_URL = "notifyUrl";
    private final static String CUSTOMER_IP = "customerIp";
    private final static String MERCHANT_POS_ID = "merchantPosId";
    private final static String DESCRIPTION = "description";
    private final static String CURRENCY_CODE = "currencyCode";
    private final static String TOTAL_AMOUNT = "totalAmount";
    private final static String EXT_ORDER_ID = "extOrderId";
    private final static String EMAIL = "email";
    private final static String PHONE = "phone";
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String LANGUAGE = "language";

    @Test
    public void should_serialize_to_json() {
        // given
        var expectedJson = orderCreateRequestJson();
        var expectedBuyer = expectedJson.get(BUYER_KEY);

        // when
        var json = Json.parse(newOrderRequest().build().toJson());

        // then
        assertEquals(expectedJson.get(NOTIFY_URL), json.get(NOTIFY_URL));
        assertEquals(expectedJson.get(CUSTOMER_IP), json.get(CUSTOMER_IP));
        assertEquals(expectedJson.get(MERCHANT_POS_ID), json.get(MERCHANT_POS_ID));
        assertEquals(expectedJson.get(DESCRIPTION), json.get(DESCRIPTION));
        assertEquals(expectedJson.get(CURRENCY_CODE), json.get(CURRENCY_CODE));
        assertEquals(expectedJson.get(TOTAL_AMOUNT), json.get(TOTAL_AMOUNT));
        assertEquals(expectedJson.get(EXT_ORDER_ID), json.get(EXT_ORDER_ID));

        var buyer = json.get(BUYER_KEY);
        assertEquals(expectedBuyer.get(EMAIL), buyer.get(EMAIL));
        assertEquals(expectedBuyer.get(PHONE), buyer.get(PHONE));
        assertEquals(expectedBuyer.get(FIRST_NAME), buyer.get(FIRST_NAME));
        assertEquals(expectedBuyer.get(LAST_NAME), buyer.get(LAST_NAME));
        assertEquals(expectedBuyer.get(LANGUAGE), buyer.get(LANGUAGE));
    }
}