package by.petrovich.model;

import java.util.Objects;

public class DiscountCard {
    private int id;
    private int number;
    private double discountPercent;

    public DiscountCard() {
    }

    public DiscountCard(int id, int number, double discountPercent) {
        this.id = id;
        this.number = number;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && number == that.number && Double.compare(that.discountPercent, discountPercent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, discountPercent);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DiscountCard{");
        sb.append("id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", discountPercent=").append(discountPercent);
        sb.append('}');
        return sb.toString();
    }
}
