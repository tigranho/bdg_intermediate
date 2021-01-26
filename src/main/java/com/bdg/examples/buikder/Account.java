package com.bdg.examples.buikder;

public class Account {
    private String name;
    private String token;


    private Account() {

    }

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public class Builder {
        private Builder() {

        }

        public Builder setName(String name) {
            Account.this.name = name;
            return this;
        }

        public Builder setToken(String token) {
            Account.this.token = token;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }


}
