package com.github.piotrkozuch.payu4j.client.request;

import com.github.piotrkozuch.payu4j.type.Name;
import com.github.piotrkozuch.payu4j.type.Quantity;
import com.github.piotrkozuch.payu4j.type.UnitPrice;
import org.junit.jupiter.api.Test;

import static com.github.piotrkozuch.payu4j.client.dto.Products.Builder.products;
import static com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest.Builder.orderCreateRequest;
import static com.github.piotrkozuch.payu4j.test.TestExamples.orderCreateRequestBody;
import static com.github.piotrkozuch.payu4j.type.Product.Builder.product;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderCreateRequestTest {

    @Test
    public void should_serialize_to_json() {
        // given
        var expectedBody = orderCreateRequestBody();

        var products = products()
            .put(product()
                .name(new Name("Wireless Mouse for Laptop"))
                .quantity(new Quantity(1))
                .unitPrice(new UnitPrice(15000L))
                .build())
            .build();

        var orderRequest = orderCreateRequest()
            .products(products)
            .build();

        // when
        var requestBody = orderRequest.toJson();

        // then
        assertEquals(expectedBody, requestBody);
    }
}