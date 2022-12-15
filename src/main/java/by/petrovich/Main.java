package by.petrovich;

import by.petrovich.model.Product;
import by.petrovich.util.BillCalculator;
import by.petrovich.util.BillGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> initialData = new HashMap<>();
        initialData.put(1, 5);
        initialData.put(2, 4);

        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Integer> value : initialData.entrySet()) {
            products.add(new Product(value.getKey(), value.getValue()));
        }
        Product product1 = products.get(0);
        Product product2 = products.get(1);
        product1.setName("name1");
        product1.setPrise(14.7);
        product2.setName("name2");
        product2.setPrise(4.9);

        BillCalculator billCalculator = new BillCalculator();
        for (Product product : products) {
            product.setTotalPrise(billCalculator.findTotalPrise(product.getPrise(),product.getQuantity()));
        }
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateListProducts(product1);
        billGenerator.generateListProducts(product2);
        System.out.println("products: " + products);
        billGenerator.printAsTable(products);


    }
}