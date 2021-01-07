package com.bdg.design_pattern.immutable_builder;
/**
 * @author Artur
 * Builder and Immutable Pattern example
 */

public final class Card {
    private final String issuerBank;
    private final String bred;
    private final long number;
    private final long holder;

    public Card(CardBuilder cardBuilder) {
        this.issuerBank = cardBuilder.issuerBank;
        this.bred = cardBuilder.bred;
        this.number = cardBuilder.number;
        this.holder = cardBuilder.holder;
    }

    public String getIssuerBank() {
        return issuerBank;
    }

    public String getBred() {
        return bred;
    }

    public long getHolder() {
        return holder;
    }

    public long getNumber() {
        return number;
    }

    public static class CardBuilder {
        private String issuerBank;
        private String bred;
        private long number;
        private long holder;

        public CardBuilder issuerBank(String issuerBank) {
            this.issuerBank = issuerBank;
            return this;
        }

        public CardBuilder bred(String bred) {
            this.bred = bred;
            return this;
        }

        public CardBuilder number(long number) {
            this.number = number;
            return this;
        }

        public CardBuilder holder(long holder) {
            this.holder = holder;
            return this;
        }

        public Card cardBuild() {
            return new Card(this);
        }

    }
}
