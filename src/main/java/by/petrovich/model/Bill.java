package by.petrovich.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Bill implements Serializable {
    private String headerLine;
    private String delimiterLine;
    private List<String> productsRows;
    private String totalSumLine;

    private Bill() {
    }

    public String getHeaderLine() {
        return headerLine;
    }

    public String getDelimiterLine() {
        return delimiterLine;
    }

    public List<String> getProductsRows() {
        return productsRows;
    }

    public String getTotalSumLine() {
        return totalSumLine;
    }

    public static Builder newBuilder() {
        return new Bill().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(headerLine, bill.headerLine) && Objects.equals(delimiterLine, bill.delimiterLine) && Objects.equals(productsRows, bill.productsRows) && Objects.equals(totalSumLine, bill.totalSumLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headerLine, delimiterLine, productsRows, totalSumLine);
    }

    @Override
    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(headerLine).append(delimiterLine);
        for (String row : productsRows) {
            stringBuffer.append(row);
        }
        stringBuffer.append(totalSumLine);
        return stringBuffer.toString();
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
            Bill.this.headerLine = header;
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
         * Sets the {@code totalPricesSum} and returns a reference to this Builder enabling method chaining.
         *
         * @param totalSum the {@code totalPricesSum} to set
         * @return a reference to this Builder
         */
        public Builder withTotalSum(String totalSum) {
            Bill.this.totalSumLine = totalSum;
            return this;
        }

        /**
         * Returns a {@code Bill} built from the parameters previously set.
         *
         * @return a {@code Bill} built with parameters of this {@code Bill.Builder}
         */
        public Bill build() {
            Bill bill = new Bill();
            bill.headerLine = Bill.this.headerLine;
            bill.delimiterLine = Bill.this.delimiterLine;
            bill.productsRows = Bill.this.productsRows;
            bill.totalSumLine = Bill.this.totalSumLine;
            return bill;
        }
    }
}