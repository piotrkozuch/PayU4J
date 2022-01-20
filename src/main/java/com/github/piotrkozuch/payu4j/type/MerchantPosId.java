package com.github.piotrkozuch.payu4j.type;

public class MerchantPosId extends PayU4JType<String> {

    private MerchantPosId(String value) {
        super(value);
    }

    public static MerchantPosId from(String value) {
        return new MerchantPosId(value);
    }
}
