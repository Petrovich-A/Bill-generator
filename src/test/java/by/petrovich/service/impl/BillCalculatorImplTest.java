package by.petrovich.service.impl;

import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.BillCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BillCalculatorImplTest {
    private final ProductCalculationData productCalculationData1 = new ProductCalculationData(new Product(1.15), 5.75, 0.58);
    private final ProductCalculationData productCalculationData2 = new ProductCalculationData(new Product(2.63), 7.89, 0.79);
    private final List<ProductCalculationData> productsCalculationData = new ArrayList<>();
    private final BillCalculator billCalculator = new BillCalculatorImpl();

    @Test
    void calculateTotalCost() {
        productsCalculationData.add(productCalculationData1);
        productsCalculationData.add(productCalculationData2);
        double expected = 13.64;
        double actual = billCalculator.calculateTotalCost(productsCalculationData);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void calculateTotalDiscount() {
        productsCalculationData.add(productCalculationData1);
        productsCalculationData.add(productCalculationData2);
        double expected = 1.37;
        double actual = billCalculator.calculateTotalDiscount(productsCalculationData);
        Assertions.assertEquals(expected, actual);
    }
}