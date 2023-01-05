package by.petrovich.service.impl;

import by.petrovich.service.ProductCalculator;
import by.petrovich.util.DoubleRounder;

public class ProductCalculatorImpl implements ProductCalculator {
    @Override
    public double calculateCost(double prise, int quantity) {
        return DoubleRounder.doubleRound(prise * quantity);
    }

    @Override
    public double calculateDiscountAmount(double cost, double discountPercent) {
        return DoubleRounder.doubleRound(cost * discountPercent / 100);
    }

}
