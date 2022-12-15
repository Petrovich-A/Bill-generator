package by.petrovich.model;

import java.util.Objects;

public class DiscountCard {
    int id;
    int percentOfDiscount;

    public DiscountCard(int id, int percentOfDiscount) {
        this.id = id;
        this.percentOfDiscount = percentOfDiscount;
    }

    public int getId() {
        return id;
    }

    public DiscountCard setId(int id) {
        this.id = id;
        return this;
    }

    public int getPercentOfDiscount() {
        return percentOfDiscount;
    }

    public DiscountCard setPercentOfDiscount(int percentOfDiscount) {
        this.percentOfDiscount = percentOfDiscount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && percentOfDiscount == that.percentOfDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, percentOfDiscount);
    }

    @Override
    public String toString() {
        return String.format("DiscountCard [                 id=%d            ,                 percentOfDiscount=%d    ]", id, percentOfDiscount);
    }
}
