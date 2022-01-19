package com.github.piotrkozuch.payu4j.client.dto;

import com.github.piotrkozuch.payu4j.type.Email;
import com.github.piotrkozuch.payu4j.type.FirstName;
import com.github.piotrkozuch.payu4j.type.Language;
import com.github.piotrkozuch.payu4j.type.LastName;
import com.github.piotrkozuch.payu4j.type.Phone;

public class Buyer {

    public final Email email;
    public final Phone phone;
    public final FirstName firstName;
    public final LastName lastName;
    public final Language language;

    private Buyer(Builder builder) {
        this.email = builder.email;
        this.phone = builder.phone;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.language = builder.language;
    }

    public static class Builder {

        private Email email;
        private Phone phone;
        private FirstName firstName;
        private LastName lastName;
        private Language language;

        private Builder() {

        }

        public static Builder buyer() {
            return new Builder();
        }

        public Buyer build() {
            return new Buyer(this);
        }

        public Builder email(Email email) {
            this.email = email;
            return this;
        }

        public Builder phone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public Builder firstName(FirstName firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(LastName lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }
    }
}
