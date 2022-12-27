package by.petrovich.service.impl;

import by.petrovich.service.ProductCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductCalculatorImplTest {
    private final ProductCalculator productCalculator = new ProductCalculatorImpl();

    @Test
    void calculateCost() {
        double prise = 0.63;
        int quantity = 7;
        double expected = 4.41;
        double actual = productCalculator.calculateCost(prise, quantity);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountAmount() {
        double prise = 7.62;
        double discountPercent = 10;
        double expected = 0.762;
        double actual = productCalculator.calculateDiscountAmount(prise, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateCostWithDiscount() {
        double prise = 3.45;
        double discountPercent = 7;
        int quantity = 3;
        double expected = 9.63;
        double actual = productCalculator.calculateCostWithDiscount(prise, quantity, discountPercent);
        Assertions.assertEquals(expected, actual);
    }
}