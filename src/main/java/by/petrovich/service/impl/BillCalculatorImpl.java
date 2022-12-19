package by.petrovich.service.impl;

import by.petrovich.model.Product;
import by.petrovich.service.BillCalculator;

import java.text.DecimalFormat;
import java.util.List;

public class BillCalculatorImpl implements BillCalculator {
    @Override
    public double calculatePrise(double prise, int quantity) {
        return prise * quantity;
    }

    public double calculatePriseWithDiscount(double prise, double discountPercent) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double priseWithDiscount = prise - calculateDiscountValue(prise, discountPercent);
        String format =  decimalFormat.format(priseWithDiscount);
        return Double.parseDouble(format.replace(",", "."));
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
