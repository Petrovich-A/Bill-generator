package by.petrovich.util;

import by.petrovich.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BillGenerator {
    private final String QUANTITY = "QTY";
    private final String DESCRIPTION = "DESCRIPTION";
    private final String PRICE = "PRICE";
    private final String TOTAL = "TOTAL";
    private final String END_LINE_SIGHT = "\n";

    public void printAsTable(List<Product> products) {
        printHeader();
        printDelimiterLine();
        printRow(products);
        printDelimiterLine();
    }

    private void printRow(List<Product> products) {
        for (Product product : products) {
            System.out.format("%3s %20s %10f %10f %s",
                    product.getQuantity(), product.getName(), product.getPrise(), product.getTotalPrise(), END_LINE_SIGHT);
        }
    }

    public List<Product> generateListProducts(Product product) {
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    public Product addTotalPrise(Product product, double prise) {
        product.setTotalPrise(prise);
        return product;
    }

    private void printHeader() {
        System.out.printf("%3s %20s %10s %10s %s", QUANTITY, DESCRIPTION, PRICE, TOTAL, END_LINE_SIGHT);
    }

    private void printDelimiterLine() {
        System.out.println("-----------------------------------------------------------------------------");
    }
}
