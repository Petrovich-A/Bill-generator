package by.petrovich.service;

import by.petrovich.model.ProductCalculationData;

import java.util.List;

public interface BillCalculator {
    double calculateTotalCost(List<ProductCalculationData> productsCalculationData);
    double calculateTotalDiscount(List<ProductCalculationData> productsCalculationData);
}
