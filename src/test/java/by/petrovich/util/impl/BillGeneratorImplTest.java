package by.petrovich.util.impl;

import by.petrovich.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BillGeneratorImplTest {
    BillGeneratorImpl billGenerator = new BillGeneratorImpl();

    @Test
    void billCreator() {
        // TODO: 19.12.2022
    }

    @Test
    void generateListProducts() {
        Product product = new Product(1, "name1", 3, 5.8, 17.4, true, 0.87);
        List<Product> expected = new ArrayList<>();
        expected.add(product);
        List<Product> actual = billGenerator.generateListProducts(product);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void putTotalPrises() {
        Product product1 = new Product(1, "name1", 3, 5.8, 17.4, true, 0.87);
        Product product2 = new Product(2, "name2", 2, 1.4, 2.8, false, 0.14);
        List<Product> expected = new ArrayList<>();
        expected.add(product1);
        expected.add(product2);
        List<Product> actual = billGenerator.putTotalPrises(expected);
        Assertions.assertEquals(expected, actual);
    }
}