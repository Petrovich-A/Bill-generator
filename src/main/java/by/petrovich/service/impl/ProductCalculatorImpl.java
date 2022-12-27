package by.petrovich.service.impl;

import by.petrovich.service.ProductCalculator;

public class ProductCalculatorImpl implements ProductCalculator {
    @Override
    public double calculateCost(double prise, int quantity) {
        return prise * quantity;
    }

    @Override
    public double calculateDiscountAmount(double prise, double discountPercent) {
        return prise * discountPercent / 100;
    }

    @Override
    public double calculateCostWithDiscount(double prise, int quantity, double discountPercent) {
        return calculateDiscountAmount(calculateCost(prise, quantity), discountPercent);
    }

}
