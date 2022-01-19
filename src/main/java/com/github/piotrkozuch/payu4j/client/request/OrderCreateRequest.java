package com.github.piotrkozuch.payu4j.client.request;

import com.github.piotrkozuch.payu4j.client.dto.Buyer;
import com.github.piotrkozuch.payu4j.client.dto.Products;
import com.github.piotrkozuch.payu4j.json.Json;
import com.github.piotrkozuch.payu4j.type.CurrencyCode;
import com.github.piotrkozuch.payu4j.type.CustomerIp;
import com.github.piotrkozuch.payu4j.type.Description;
import com.github.piotrkozuch.payu4j.type.MerchantPosId;
import com.github.piotrkozuch.payu4j.type.NotifyUrl;
import com.github.piotrkozuch.payu4j.type.TotalAmount;

public final class OrderCreateRequest implements PayU4JRequest {

    public final NotifyUrl notifyUrl;
    public final CustomerIp customerIp;
    public final MerchantPosId merchantPosId;
    public final Description description;
    public final CurrencyCode currencyCode;
    public final TotalAmount totalAmount;
    public final Buyer buyer;
    public final Products products;

    private OrderCreateRequest(Builder builder) {
        this.notifyUrl = builder.notifyUrl;
        this.customerIp = builder.customerIp;
        this.merchantPosId = builder.merchantPosId;
        this.description = builder.description;
        this.currencyCode = builder.currencyCode;
        this.totalAmount = builder.totalAmount;
        this.buyer = builder.buyer;
        this.products = builder.products;
    }

    @Override
    public String toJson() {
        return Json.toJson(this);
    }

    public static class Builder {

        private NotifyUrl notifyUrl;
        private CustomerIp customerIp;
        private MerchantPosId merchantPosId;
        private Description description;
        private CurrencyCode currencyCode;
        private TotalAmount totalAmount;
        private Buyer buyer;
        private Products products;

        private Builder() {

        }

        public static Builder orderCreateRequest() {
            return new Builder();
        }

        public OrderCreateRequest build() {
            return new OrderCreateRequest(this);
        }

        public Builder notifyUrl(NotifyUrl notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public Builder customerIp(CustomerIp customerIp) {
            this.customerIp = customerIp;
            return this;
        }

        public Builder merchantPosId(MerchantPosId merchantPosId) {
            this.merchantPosId = merchantPosId;
            return this;
        }

        public Builder description(Description description) {
            this.description = description;
            return this;
        }

        public Builder currencyCode(CurrencyCode currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder totalAmount(TotalAmount totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder buyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder products(Products products) {
            this.products = products;
            return this;
        }
    }
}
