package by.petrovich.util;

import by.petrovich.model.Product;

import java.util.List;

public class BillCalculator {
    public double calculatePrise(double prise, int quantity) {
        return prise * quantity;
    }
    public double calculatePriseWithDiscount(double prise, double discountPercent) {
        return prise - prise * discountPercent / 100;
    }

    public double calculateDiscountAmount(double prise, double discountPercent){
        return prise * discountPercent / 100;
    }

    public double calculatePrisesSum(List<Product> products) {
        double prisesSum = 0.0;
        for (Product product : products) {
            prisesSum += product.getTotalPrise();
        }
        return prisesSum;
    }

    public double calculateDiscountSum(List<Product> products, double discountPercent) {
        double discountSum = 0.0;
        for (Product product : products) {
            discountSum += calculateDiscountAmount(product.getTotalPrise(), discountPercent);
        }
        return discountSum;
    }

    public double calculatePrisesSumWithDiscount(List<Product> products, double discountPercent) {
        return calculatePrisesSum(products) - calculateDiscountSum(products, discountPercent);
    }
}
