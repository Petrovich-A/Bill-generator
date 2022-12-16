package by.petrovich.util;

import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BillGenerator {
    private final int QUANTITY_FOR_GETTING_DISCOUNT = 5;
    private final double DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE = 10;
    private final String QUANTITY = "QTY";
    private final String DESCRIPTION = "DESCRIPTION";
    private final String PRICE = "PRICE";
    private final String TOTAL = "TOTAL";
    private final String TOTAL_SUM = "TOTAL SUM:";
    private final String TOTAL_DISCOUNT = "DISCOUNT:";
    private final String END_LINE_SIGHT = "\n";
    private final String DASH_SIGHT = "-";
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

    public List<Product> putTotalPrises(List<Product> products) {
        for (Product product : products) {
            if (product.getQuantity() > QUANTITY_FOR_GETTING_DISCOUNT && product.isOnSale()) {
                product.setTotalPrise(billCalculator.calculatePriseWithDiscount(product.getPrise(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
                product.setDiscountAmount(billCalculator.calculateDiscountAmount(product.getPrise(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
            } else {
                product.setTotalPrise(billCalculator.calculatePrise(product.getPrise(), product.getQuantity()));
            }
        }
        return products;
    }

    private void printRow(List<Product> products) {
        for (Product product : products) {
            System.out.format("%3s %20s %10f %10f %s",
                    product.getQuantity(), product.getName(), product.getPrise(), product.getTotalPrise(), END_LINE_SIGHT);
            if (product.getDiscountAmount() != 0) {
                System.out.format("%38s %f %s",
                        DASH_SIGHT, product.getDiscountAmount(), END_LINE_SIGHT);
            }
        }
    }

    private void printHeader() {
        System.out.format("%3s %20s %10s %10s %s",
                QUANTITY, DESCRIPTION, PRICE, TOTAL, END_LINE_SIGHT);
    }

    private void printTotalPricesSum(double totalPrise) {
        System.out.format("%3s %35f %s",
                TOTAL_SUM, totalPrise, END_LINE_SIGHT);
    }

    private void printDiscountSum(double discountAmount) {
        System.out.format("%3s %35f %s",
                TOTAL_DISCOUNT, discountAmount, END_LINE_SIGHT);
    }

    private void printDelimiterLine() {
        System.out.println("-----------------------------------------------------------------------------");
    }
}
