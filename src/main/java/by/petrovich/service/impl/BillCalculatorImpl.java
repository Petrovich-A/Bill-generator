package by.petrovich.service.impl;

import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.BillCalculator;
import by.petrovich.util.DoubleRounder;

import java.util.List;

public class BillCalculatorImpl implements BillCalculator {
    @Override
    public double calculateTotalCost(List<ProductCalculationData> productsCalculationData) {
        double totalCost = 0;
        for (ProductCalculationData productCalculationData : productsCalculationData) {
            totalCost += productCalculationData.getCost();
        }
        return DoubleRounder.doubleRound(totalCost);
    }

    @Override
    public double calculateTotalDiscount(List<ProductCalculationData> productsCalculationData) {
        double totalDiscount = 0;
        for (ProductCalculationData productCalculationData : productsCalculationData) {
            totalDiscount += productCalculationData.getDiscountAmount();
        }
        return DoubleRounder.doubleRound(totalDiscount);
    }

}
