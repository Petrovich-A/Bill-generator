package by.petrovich.model;

import java.util.Objects;

public class Product {
   private int id;
   private String name;
   private double prise;
   private boolean isOnSale;

    public Product(int id, String name, double prise, boolean isOnSale) {
        this.id = id;
        this.name = name;
        this.prise = prise;
        this.isOnSale = isOnSale;
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

    public double getPrise() {
        return prise;
    }

    public Product setPrise(double prise) {
        this.prise = prise;
        return this;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public Product setOnSale(boolean onSale) {
        isOnSale = onSale;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.prise, prise) == 0 && isOnSale == product.isOnSale && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prise, isOnSale);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", prise=").append(prise);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append('}');
        return sb.toString();
    }
}
