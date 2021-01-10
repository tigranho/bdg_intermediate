package com.bdg.homework.designPatterns.builderDesign;

public class BuilderLunchOrder {


    static class Builder {
        private String bread;
        private String condiments;
        private String meat;
        private String cola;

        public Builder() {
        }

        public BuilderLunchOrder build() {
            return new BuilderLunchOrder(this);

        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }

        public Builder cola(String cola) {
            this.cola = cola;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "bread='" + bread + '\'' +
                    ", condiments='" + condiments + '\'' +
                    ", meat='" + meat + '\'' +
                    ", cola='" + cola + '\'' +
                    '}';
        }
    }


    private String bread;
    private String condiments;
    private String meat;
    private String cola;

    public BuilderLunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.meat = builder.meat;
        this.cola = builder.cola;


    }


    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getMeat() {
        return meat;
    }

    public String getCola() {
        return cola;
    }

    @Override
    public String toString() {
        return "BuilderLunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", meat='" + meat + '\'' +
                ", cola='" + cola + '\'' +
                '}';
    }
}


