package by.petrovich.model;

import java.util.Objects;

public class ProductCalculationData {
    private Product product;
    private int productQuntity;
    private double totalPrise;
    private double discountAmount;

    public ProductCalculationData(Product product, int productQuntity, double totalPrise, double discountAmount) {
        this.product = product;
        this.productQuntity = productQuntity;
        this.totalPrise = totalPrise;
        this.discountAmount = discountAmount;
    }

    public Product getProduct() {
        return product;
    }

    public ProductCalculationData setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getProductQuntity() {
        return productQuntity;
    }

    public ProductCalculationData setProductQuntity(int productQuntity) {
        this.productQuntity = productQuntity;
        return this;
    }

    public double getTotalPrise() {
        return totalPrise;
    }

    public ProductCalculationData setTotalPrise(double totalPrise) {
        this.totalPrise = totalPrise;
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
        return productQuntity == that.productQuntity && Double.compare(that.totalPrise, totalPrise) == 0 && Double.compare(that.discountAmount, discountAmount) == 0 && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, productQuntity, totalPrise, discountAmount);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductCalculationData{");
        sb.append("product=").append(product);
        sb.append(", productQuntity=").append(productQuntity);
        sb.append(", totalPrise=").append(totalPrise);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append('}');
        return sb.toString();
    }
}
