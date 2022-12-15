package by.petrovich.util;

import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BillGenerator {
    private final String QUANTITY = "QTY";
    private final String DESCRIPTION = "DESCRIPTION";
    private final String PRICE = "PRICE";
    private final String TOTAL = "TOTAL";
    private final String TOTAL_SUM = "TOTAL SUM:";
    private final String DISCOUNT = "DISCOUNT:";
    private final String END_LINE_SIGHT = "\n";
    private final BillCalculator billCalculator = new BillCalculator();

    public void printBillAsTable(List<Product> products, DiscountCard discountCard) {
        printHeader();
        printDelimiterLine();
        printRow(products);
        printDelimiterLine();
        if (discountCard != null) {
            printDiscountSum(billCalculator.calculateDiscountSum(products, discountCard.getPercentOfDiscount()));
            printTotalPricesSum(billCalculator.calculatePrisesSumWithDiscount(products, discountCard.getPercentOfDiscount()));
        } else {
            printTotalPricesSum(billCalculator.calculatePrisesSum(products));
        }
    }

    public List<Product> generateListProducts(Product product) {
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    public List<Product> putTotalPrise(List<Product> products) {
        for (Product product : products) {
            product.setTotalPrise(billCalculator.calculateProductPrise(product.getPrise(), product.getQuantity()));
        }
        return products;
    }

    private void printRow(List<Product> products) {
        for (Product product : products) {
            System.out.format("%3s %20s %10f %10f %s",
                    product.getQuantity(), product.getName(), product.getPrise(), product.getTotalPrise(), END_LINE_SIGHT);
        }
    }

    private void printHeader() {
        System.out.format("%3s %20s %10s %10s %s", QUANTITY, DESCRIPTION, PRICE, TOTAL, END_LINE_SIGHT);
    }

    private void printTotalPricesSum(double totalPrise) {
        System.out.format("%3s %35f %s", TOTAL_SUM, totalPrise, END_LINE_SIGHT);
    }

    private void printDiscountSum(double discountAmount) {
        System.out.format("%3s %35f %s", DISCOUNT, discountAmount, END_LINE_SIGHT);
    }

    private void printDelimiterLine() {
        System.out.println("-----------------------------------------------------------------------------");
    }
}
