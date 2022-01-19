package com.github.piotrkozuch.payu4j.test;

import com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest;

import static com.github.piotrkozuch.payu4j.test.TestUtils.loadResource;

public interface TestExamples {

    String ORDER_CREATE_REQUEST = "/example/request/OrderCreateRequest.json";

    static String orderCreateRequestBody() {
        return loadResource(ORDER_CREATE_REQUEST);
    }
}
