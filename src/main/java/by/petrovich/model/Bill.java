package by.petrovich.model;

import java.util.List;

public class Bill {
    private String header;
    private String delimiterLine;
    private List<String> productsRows;
    private String discountSum;
    private String prisesSumWithDiscount;
    private String discountAmount;
    private String prisesSum;
    private String totalPricesSum;

    private Bill() {
    }

    public String getHeader() {
        return header;
    }

    public String getDelimiterLine() {
        return delimiterLine;
    }

    public List<String> getProductsRows() {
        return productsRows;
    }

    public String getDiscountSum() {
        return discountSum;
    }

    public String getPrisesSumWithDiscount() {
        return prisesSumWithDiscount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public String getPrisesSum() {
        return prisesSum;
    }

    public String getTotalPricesSum() {
        return totalPricesSum;
    }

    public static Builder newBuilder() {
        return new Bill().new Builder();
    }

    /**
     * {@code Bill} builder static inner class.
     */
    public class Builder {

        private Builder() {
        }

        /**
         * Sets the {@code header} and returns a reference to this Builder enabling method chaining.
         *
         * @param header the {@code header} to set
         * @return a reference to this Builder
         */
        public Builder withHeader(String header) {
            Bill.this.header = header;
            return this;
        }

        /**
         * Sets the {@code delimiterLine} and returns a reference to this Builder enabling method chaining.
         *
         * @param delimiterLine the {@code delimiterLine} to set
         * @return a reference to this Builder
         */
        public Builder withDelimiterLine(String delimiterLine) {
            Bill.this.delimiterLine = delimiterLine;
            return this;
        }

        /**
         * Sets the {@code productRows} and returns a reference to this Builder enabling method chaining.
         *
         * @param productRows the {@code productRows} to set
         * @return a reference to this Builder
         */
        public Builder withProductRows(List<String> productRows) {
            Bill.this.productsRows = productRows;
            return this;
        }

        /**
         * Sets the {@code discountSum} and returns a reference to this Builder enabling method chaining.
         *
         * @param discountSum the {@code discountSum} to set
         * @return a reference to this Builder
         */
        public Builder withDiscountSum(String discountSum) {
            Bill.this.discountSum = discountSum;
            return this;
        }

        /**
         * Sets the {@code prisesSumWithDiscount} and returns a reference to this Builder enabling method chaining.
         *
         * @param prisesSumWithDiscount the {@code prisesSumWithDiscount} to set
         * @return a reference to this Builder
         */
        public Builder withPrisesSumWithDiscount(String prisesSumWithDiscount) {
            Bill.this.prisesSumWithDiscount = prisesSumWithDiscount;
            return this;
        }

        /**
         * Sets the {@code discountAmount} and returns a reference to this Builder enabling method chaining.
         *
         * @param discountAmount the {@code discountAmount} to set
         * @return a reference to this Builder
         */
        public Builder withDiscountAmount(String discountAmount) {
            Bill.this.discountAmount = discountAmount;
            return this;
        }

        /**
         * Sets the {@code prisesSum} and returns a reference to this Builder enabling method chaining.
         *
         * @param prisesSum the {@code prisesSum} to set
         * @return a reference to this Builder
         */
        public Builder withPrisesSum(String prisesSum) {
            Bill.this.prisesSum = prisesSum;
            return this;
        }

        /**
         * Sets the {@code totalPricesSum} and returns a reference to this Builder enabling method chaining.
         *
         * @param totalPricesSum the {@code totalPricesSum} to set
         * @return a reference to this Builder
         */
        public Builder withTotalPricesSum(String totalPricesSum) {
            Bill.this.totalPricesSum = totalPricesSum;
            return this;
        }

        /**
         * Returns a {@code Bill} built from the parameters previously set.
         *
         * @return a {@code Bill} built with parameters of this {@code Bill.Builder}
         */
        public Bill build() {
            Bill bill = new Bill();
            bill.header = Bill.this.header;
            bill.delimiterLine = Bill.this.delimiterLine;
            bill.productsRows = Bill.this.productsRows;
            bill.discountSum = Bill.this.discountSum;
            bill.prisesSumWithDiscount = Bill.this.prisesSumWithDiscount;
            bill.discountAmount = Bill.this.discountAmount;
            bill.prisesSum = Bill.this.prisesSum;
            bill.totalPricesSum = Bill.this.totalPricesSum;
            return bill;
        }
    }
}