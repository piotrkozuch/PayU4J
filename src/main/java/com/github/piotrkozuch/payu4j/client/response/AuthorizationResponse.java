package com.github.piotrkozuch.payu4j.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.piotrkozuch.payu4j.type.AccessToken;
import com.github.piotrkozuch.payu4j.type.GrantType;
import com.github.piotrkozuch.payu4j.type.TokenType;

import static com.github.piotrkozuch.validation.Validation.required;

public class AuthorizationResponse {

    public final AccessToken accessToken;
    public final TokenType tokenType;
    public final Integer expiresIn;
    public final GrantType grantType;

    @JsonCreator
    public AuthorizationResponse(@JsonProperty("access_token") String accessToken,
                                 @JsonProperty("token_type") String tokenType,
                                 @JsonProperty("expires_in") Integer expiresIn,
                                 @JsonProperty("grant_type") String grantType) {
        this.accessToken = AccessToken.from(required("access_token", accessToken));
        this.tokenType = TokenType.from(required("token_type", tokenType));
        this.expiresIn = required("expires_in", expiresIn);
        this.grantType = GrantType.from(required("grant_type", grantType));
    }
}
