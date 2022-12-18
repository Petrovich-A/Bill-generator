package by.petrovich.util;

import by.petrovich.model.Product;

import java.util.List;

public interface BillCalculator {
    double calculatePrise(double prise, int quantity);

    double calculatePriseWithDiscount(double prise, double discountPercent);

    double calculateDiscountValue(double prise, double discountPercent);

    double calculateTotalSum(List<Product> products);

    double calculateTotalDiscountSum(List<Product> products, double discountPercent);

    double calculateTotalSumWithDiscount(List<Product> products, double discountPercent);
}
