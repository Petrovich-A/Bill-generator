package by.petrovich.util.impl;

import by.petrovich.model.Product;
import by.petrovich.util.BillCalculator;

import java.util.List;

public class BillCalculatorImpl implements BillCalculator {
    @Override
    public double calculatePrise(double prise, int quantity) {
        return prise * quantity;
    }

    public double calculatePriseWithDiscount(double prise, double discountPercent) {
        return prise - prise * discountPercent / 100;
    }

    @Override
    public double calculateDiscountValue(double prise, double discountPercent) {
        return prise * discountPercent / 100;
    }

    @Override
    public double calculateTotalSum(List<Product> products) {
        double prisesSum = 0.0;
        for (Product product : products) {
            prisesSum += product.getTotalPrise();
        }
        return prisesSum;
    }

    @Override
    public double calculateTotalSumWithDiscount(List<Product> products, double discountPercent) {
        return calculateTotalSum(products) - calculateTotalDiscountSum(products, discountPercent);
    }

    @Override
    public double calculateTotalDiscountSum(List<Product> products, double discountPercent) {
        double discountSum = 0.0;
        for (Product product : products) {
            discountSum += calculateDiscountValue(product.getTotalPrise(), discountPercent);
        }
        return discountSum;
    }
}
