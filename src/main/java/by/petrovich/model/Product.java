package by.petrovich.model;

import java.util.Objects;
public class Product {
    int id;
    String name;
    int quantity;
    double prise;
    double totalPrise;

    public Product(int id, String name, int quantity, double prise, double totalPrise) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.prise = prise;
        this.totalPrise = totalPrise;
    }

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public double getTotalPrise() {
        return totalPrise;
    }

    public void setTotalPrise(double totalPrise) {
        this.totalPrise = totalPrise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Double.compare(product.prise, prise) == 0 && Double.compare(product.totalPrise, totalPrise) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, prise, totalPrise);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", prise=").append(prise);
        sb.append(", totalPrise=").append(totalPrise);
        sb.append('}');
        return sb.toString();
    }
}
