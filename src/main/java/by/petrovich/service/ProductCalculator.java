package by.petrovich.service;

public interface ProductCalculator {
    double calculateCost(double prise, int quantity);

    double calculateDiscountAmount(double prise, double discountPercent);

}
