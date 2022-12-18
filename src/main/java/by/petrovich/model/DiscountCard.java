package by.petrovich.model;

import java.util.Objects;

public class DiscountCard {
    int id;
    int discountPercent;

    public DiscountCard(int id, int discountPercent) {
        this.id = id;
        this.discountPercent = discountPercent;
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
        return String.format("DiscountCard [                 id=%d            ,                 percentOfDiscount=%d    ]", id, discountPercent);
    }
}
