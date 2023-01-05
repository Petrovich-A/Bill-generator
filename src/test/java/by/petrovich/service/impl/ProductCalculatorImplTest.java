package by.petrovich.service.impl;

import by.petrovich.service.ProductCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductCalculatorImplTest {
    private final ProductCalculator productCalculator = new ProductCalculatorImpl();

    @Test
    void calculateCost() {
        double prise = 0.5;
        int quantity = 4;
        double expected = 2.00;
        double actual = productCalculator.calculateCost(prise, quantity);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountAmount() {
        double cost = 7.68;
        double discountPercent = 10;
        double expected = 0.77;
        double actual = productCalculator.calculateDiscountAmount(cost, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

}