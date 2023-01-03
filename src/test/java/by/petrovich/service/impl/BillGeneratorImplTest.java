//package by.petrovich.service.impl;
//
//import by.petrovich.model.DiscountCard;
//import by.petrovich.model.Product;
//import by.petrovich.service.BillGenerator;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//class BillGeneratorImplTest {
//    BillGenerator billGenerator = new BillGeneratorImpl();
//
//    @Test
//    void billCreator() {
//        List<Product> expected = generateProducts();
//        DiscountCard discountCard = new DiscountCard(1234, 10);
//        //// TODO: 19 дек. 2022 г.
//    }
//
//    @Test
//    void putTotalPrises() {
//        List<Product> expected = generateProducts();
//        List<Product> actual = billGenerator.determineTotalPrises(expected);
//        Assertions.assertEquals(expected, actual);
//    }
//
//    private List<Product> generateProducts() {
//        Product product1 = new Product(1, "name1", 3, 5.8, 17.4, true, 0.87);
//        Product product2 = new Product(2, "name2", 2, 1.4, 2.8, false, 0.14);
//        List<Product> expected = Arrays.asList(product1, product2);
//        return expected;
//    }
//}