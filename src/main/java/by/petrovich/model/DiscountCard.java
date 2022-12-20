package by.petrovich.model;

import java.util.Objects;

public class DiscountCard {
    private int id;
    private int discountPercent;

    public DiscountCard(int id, int discountPercent) {
        this.id = id;
        this.discountPercent = discountPercent;
    }

    public DiscountCard() {

    }

    public int getId() {
        return id;
    }

    public DiscountCard setId(int id) {
        this.id = id;
        return this;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public DiscountCard setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && discountPercent == that.discountPercent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discountPercent);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DiscountCard{");
        sb.append("id=").append(id);
        sb.append(", discountPercent=").append(discountPercent);
        sb.append('}');
        return sb.toString();
    }
}
