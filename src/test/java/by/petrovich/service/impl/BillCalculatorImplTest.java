package by.petrovich.service.impl;

import by.petrovich.model.Product;
import by.petrovich.service.BillCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BillCalculatorImplTest {
    private final BillCalculator billCalculator = new BillCalculatorImpl();

    @Test
    void calculatePrise() {
        double prise = 12.5;
        int quantity = 4;
        double expected = 50;
        double actual = billCalculator.calculatePrise(prise, quantity);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculatePriseWithDiscount() {
        double prise = 8.2;
        double discountPercent = 10;
        double expected = 7.38;
        double actual = billCalculator.calculatePriseWithDiscount(prise, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountValue() {
        double prise = 5.7;
        double discountPercent = 3;
        double expected = 0.171;
        double actual = billCalculator.calculateDiscountValue(prise, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateTotalSum() {
        List<Product> products = generateProducts();
        double expected = 6.7;
        double actual = billCalculator.calculateTotalSum(products);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateTotalSumWithDiscount() {
        List<Product> products = generateProducts();
        double discountPercent = 10;
        double expected = 6.03;
        double actual = billCalculator.calculateTotalSumWithDiscount(products, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateTotalDiscountSum() {
        List<Product> products = generateProducts();
        double discountPercent = 10;
        double expected = 0.67;
        double actual = billCalculator.calculateTotalDiscountSum(products, discountPercent);
        Assertions.assertEquals(expected, actual);
    }

    private List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product( 4.5);
        Product product2 = new Product( 2.2);
        products.add(product1);
        products.add(product2);
        return products;
    }
}