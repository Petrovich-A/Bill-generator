package by.petrovich.service.impl;

import by.petrovich.service.ProductCalculator;

public class ProductCalculatorImpl implements ProductCalculator {
    @Override
    public double calculateCost(double prise, int quantity) {
        return prise * quantity;
    }

    @Override
    public double calculateDiscountAmount(double cost, double discountPercent) {
        return cost * discountPercent / 100;
    }

}
