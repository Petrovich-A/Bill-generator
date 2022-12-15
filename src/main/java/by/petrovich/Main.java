package by.petrovich;

import by.petrovich.model.Product;
import by.petrovich.util.BillCalculator;
import by.petrovich.util.BillGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> initialData = new HashMap<>();
        initialData.put(1, 2);
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

        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateListProducts(product1);
        billGenerator.generateListProducts(product2);
        billGenerator.putTotalPrise(products);

        BillCalculator billCalculator = new BillCalculator();
        double totalPrise = billCalculator.findTotalBillPrise(products);

        billGenerator.printAsTable(products, totalPrise);

    }
}