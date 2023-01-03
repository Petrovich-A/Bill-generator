package by.petrovich.model;

import java.util.Objects;

public class ProductCalculationData {
    private Product product;
    private int quantity;
    private double cost;
    private double discountAmount;

    public ProductCalculationData(Product product, int quantity, double cost, double discountAmount) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.discountAmount = discountAmount;
    }

    public ProductCalculationData() {

    }

    public ProductCalculationData(Product product, double cost, double discountAmount) {
        this.product = product;
        this.cost = cost;
        this.discountAmount = discountAmount;
    }

    public Product getProduct() {
        return product;
    }

    public ProductCalculationData setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductCalculationData setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public ProductCalculationData setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public ProductCalculationData setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCalculationData that = (ProductCalculationData) o;
        return quantity == that.quantity && Double.compare(that.cost, cost) == 0 && Double.compare(that.discountAmount, discountAmount) == 0 && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, cost, discountAmount);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductCalculationData{");
        sb.append("product=").append(product);
        sb.append(", productQuntity=").append(quantity);
        sb.append(", totalPrise=").append(cost);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append('}');
        return sb.toString();
    }
}
