package by.petrovich.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    int id;
    String name;
    int quantity;
    double prise;
    double totalPrise;
    boolean isOnSale;
    double discountAmount;

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Product(double totalPrise) {
        this.totalPrise = totalPrise;
    }

    public Product(int id, String name, int quantity, double prise, double totalPrise, boolean isOnSale, double discountAmount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.prise = prise;
        this.totalPrise = totalPrise;
        this.isOnSale = isOnSale;
        this.discountAmount = discountAmount;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPrise() {
        return prise;
    }

    public Product setPrise(double prise) {
        this.prise = prise;
        return this;
    }

    public double getTotalPrise() {
        return totalPrise;
    }

    public Product setTotalPrise(double totalPrise) {
        this.totalPrise = totalPrise;
        return this;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public Product setOnSale(boolean onSale) {
        isOnSale = onSale;
        return this;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public Product setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Double.compare(product.prise, prise) == 0 && Double.compare(product.totalPrise, totalPrise) == 0 && isOnSale == product.isOnSale && Double.compare(product.discountAmount, discountAmount) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, prise, totalPrise, isOnSale, discountAmount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("quantity=" + quantity)
                .add("prise=" + prise)
                .add("totalPrise=" + totalPrise)
                .add("isOnSale=" + isOnSale)
                .add("discountAmount=" + discountAmount)
                .toString();
    }
}
