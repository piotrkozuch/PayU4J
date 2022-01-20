package com.github.piotrkozuch.payu4j.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.piotrkozuch.payu4j.client.dto.Buyer;
import com.github.piotrkozuch.payu4j.client.dto.Products;
import com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest;
import com.github.piotrkozuch.payu4j.json.Json;

import static com.github.piotrkozuch.payu4j.client.dto.Buyer.Builder.buyer;
import static com.github.piotrkozuch.payu4j.client.dto.Product.Builder.product;
import static com.github.piotrkozuch.payu4j.client.dto.Products.Builder.products;
import static com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest.Builder.orderCreateRequest;
import static com.github.piotrkozuch.payu4j.test.TestUtils.loadResource;

public interface OrderTestData {

    String ORDER_CREATE_REQUEST = "/example/request/OrderCreateRequest.json";

    static JsonNode orderCreateRequestJson() {
        return Json.parse(loadResource(ORDER_CREATE_REQUEST));
    }

    static Buyer.Builder aBuyer() {
        return buyer()
            .email("john.doe@example.com")
            .phone("654111654")
            .firstName("John")
            .lastName("Doe")
            .language("pl");
    }

    static Products.Builder productsBuilder() {
        final var mouse = product()
            .name("Wireless Mouse for Laptop")
            .quantity(1)
            .unitPrice(15000L)
            .build();

        final var hdmiCable = product()
            .name("HDMI cable")
            .quantity(1)
            .unitPrice(6000L)
            .build();

        return products()
            .put(mouse)
            .put(hdmiCable);
    }

    static OrderCreateRequest.Builder newOrderRequest() {
        return orderCreateRequest()
            .notifyUrl("https://your.eshop.com/notify")
            .customerIp("127.0.0.1")
            .merchantPosId("145227")
            .description("RTV market")
            .currencyCode("PLN")
            .totalAmount(21000L)
            .extOrderId("gkwmvn7f0kpbx5g884ny32")
            .products(productsBuilder().build())
            .buyer(aBuyer().build());
    }
}
