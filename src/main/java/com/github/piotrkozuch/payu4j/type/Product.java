package com.github.piotrkozuch.payu4j.type;

public class Product {

    public final Name name;
    public final UnitPrice unitPrice;
    public final Quantity quantity;

    private Product(Builder builder) {
        this.name = builder.name;
        this.unitPrice = builder.unitPrice;
        this.quantity = builder.quantity;
    }

    public static class Builder {

        private Name name;
        private UnitPrice unitPrice;
        private Quantity quantity;

        private Builder() {

        }

        public static Builder product() {
            return new Builder();
        }

        public Product build() {
            return new Product(this);
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder unitPrice(UnitPrice unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder quantity(Quantity quantity) {
            this.quantity = quantity;
            return this;
        }
    }
}
