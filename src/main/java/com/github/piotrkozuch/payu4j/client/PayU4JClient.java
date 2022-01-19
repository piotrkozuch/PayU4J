package com.github.piotrkozuch.payu4j.client;

import com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest;
import com.github.piotrkozuch.payu4j.client.response.OrderCreateResponse;

public interface PayU4JClient {
    OrderCreateResponse create(OrderCreateRequest request);
}
