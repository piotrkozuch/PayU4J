package com.github.piotrkozuch.payu4j.client;

import com.github.piotrkozuch.payu4j.client.request.OrderCreateRequest;
import com.github.piotrkozuch.payu4j.client.response.AuthorizationResponse;
import com.github.piotrkozuch.payu4j.client.response.OrderCreateResponse;
import com.github.piotrkozuch.payu4j.type.ClientId;
import com.github.piotrkozuch.payu4j.type.ClientSecret;
import com.github.piotrkozuch.payu4j.type.GrantType;

public interface PayU4JApi {

    AuthorizationResponse authorize(GrantType grantType, ClientId clientId, ClientSecret clientSecret);

    OrderCreateResponse create(OrderCreateRequest request);
}
