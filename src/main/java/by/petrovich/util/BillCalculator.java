package by.petrovich.util;

import by.petrovich.model.Product;

import java.util.List;

public interface BillCalculator {
    double calculatePrise(double prise, int quantity);

    double calculatePriseWithDiscount(double prise, double discountPercent);

    double calculateDiscountAmount(double prise, double discountPercent);

    double calculatePrisesSum(List<Product> products);

    double calculateDiscountSum(List<Product> products, double discountPercent);

    double calculatePrisesSumWithDiscount(List<Product> products, double discountPercent);
}
