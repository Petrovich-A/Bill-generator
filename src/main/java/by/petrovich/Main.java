package by.petrovich;

import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;
import by.petrovich.util.BillGenerator;
import by.petrovich.util.impl.BillGeneratorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> initialData = new HashMap<>();
        initialData.put(1, 2);
        initialData.put(2, 3);
        initialData.put(3, 6);
        DiscountCard discountCard = new DiscountCard(1234, 10);

        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Integer> value : initialData.entrySet()) {
            products.add(new Product(value.getKey(), value.getValue()));
        }
        Product product1 = products.get(0);
        Product product2 = products.get(1);
        Product product3 = products.get(2);
        product1.setName("name1");
        product1.setOnSale(true);
        product1.setPrise(10);
        product2.setName("name2");
        product2.setOnSale(false);
        product2.setPrise(5);
        product3.setName("name3");
        product3.setOnSale(true);
        product3.setPrise(12.7);

        BillGeneratorImpl billGenerator = new BillGeneratorImpl();
        billGenerator.generateListProducts(product1);
        billGenerator.generateListProducts(product2);
        billGenerator.generateListProducts(product3);
        List<Product> productsFull = billGenerator.putTotalPrises(products);
        System.out.println(productsFull);
        billGenerator.printBillAsTable(productsFull, discountCard);

    }
}