package by.petrovich.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Bill implements Serializable {
    private List<ProductCalculationData> productCalculationData;
    private double totalDiscount;
    private double totalPrise;

    private Bill() {
    }

    public List<ProductCalculationData> getProductCalculationData() {
        return productCalculationData;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPrise() {
        return totalPrise;
    }

    public static Builder newBuilder() {
        return new Bill().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.totalDiscount, totalDiscount) == 0 && Double.compare(bill.totalPrise, totalPrise) == 0 && Objects.equals(productCalculationData, bill.productCalculationData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCalculationData, totalDiscount, totalPrise);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bill{");
        sb.append("productCalculationData=").append(productCalculationData);
        sb.append(", totalDiscount=").append(totalDiscount);
        sb.append(", totalPrise=").append(totalPrise);
        sb.append('}');
        return sb.toString();
    }

    /**
     * {@code Bill} builder static inner class.
     */
    public class Builder {

        private Builder() {
        }

        public Builder withProductCalculationData(List<ProductCalculationData> productCalculationData) {
            Bill.this.productCalculationData = productCalculationData;
            return this;
        }

        public Builder withTotalDiscount(double totalDiscount) {
            Bill.this.totalDiscount = totalDiscount;
            return this;
        }

        public Builder withTotalPrise(double totalPrise) {
            Bill.this.totalPrise = totalPrise;
            return this;
        }

        public Bill build() {
            Bill bill = new Bill();
            bill.productCalculationData = Bill.this.productCalculationData;
            bill.totalDiscount = Bill.this.totalDiscount;
            bill.totalPrise = Bill.this.totalPrise;
            return bill;
        }
    }
}