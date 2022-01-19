package com.github.piotrkozuch.payu4j.client.dto;

import com.github.piotrkozuch.payu4j.type.Product;

import java.util.ArrayList;
import java.util.Collection;

public class Products extends ArrayList<Product> {

    private Products(Builder builder) {
        addAll(builder.products);
    }

    public static class Builder {

        private final Collection<Product> products;

        private Builder() {
            products = new ArrayList<>();
        }

        public static Builder products() {
            return new Builder();
        }

        public Builder put(Product product) {
            products.add(product);
            return this;
        }

        public Products build() {
            return new Products(this);
        }
    }
}
