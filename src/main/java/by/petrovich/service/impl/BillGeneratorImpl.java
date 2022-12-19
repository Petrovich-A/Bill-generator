package by.petrovich.service.impl;

import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;
import by.petrovich.service.BillCalculator;
import by.petrovich.service.BillGenerator;

import java.util.ArrayList;
import java.util.List;

public class BillGeneratorImpl implements BillGenerator {
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
    private final String DELIMITER_LINE = "-----------------------------------------------------------------------------";
    private final BillCalculator billCalculator = new BillCalculatorImpl();

    @Override
    public Bill billCreator(List<Product> products, DiscountCard discountCard) {
        return Bill.newBuilder()
                .withHeader(headerFormation())
                .withDelimiterLine(delimiterFormation())
                .withProductRows(productRowsFormation(products))
                .withTotalSum(totalSumFormation(products, discountCard.getDiscountPercent()))
                .build();
    }

    @Override
    public List<Product> determineTotalPrises(List<Product> products) {
        for (Product product : products) {
            if (product.getQuantity() > QUANTITY_FOR_GETTING_DISCOUNT && product.isOnSale()) {
                product.setTotalPrise(billCalculator.calculatePriseWithDiscount(product.getPrise(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
                product.setDiscountAmount(billCalculator.calculateDiscountValue(product.getPrise(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
            } else {
                product.setTotalPrise(billCalculator.calculatePrise(product.getPrise(), product.getQuantity()));
            }
        }
        return products;
    }

    private List<String> productRowsFormation(List<Product> products) {
        List<String> productRows = new ArrayList<>();
        for (Product product : products) {
            addProductRow(productRows, product);
            if (product.getDiscountAmount() != 0) {
                productRows.add((String.format("%38s %f %s",
                        DASH_SIGHT, product.getDiscountAmount(), END_LINE_SIGHT)));
            }
        }
        return productRows;
    }

    private void addProductRow(List<String> productRows, Product product) {
        productRows.add(String.format("%3s %20s %10f %10f %s",
                product.getQuantity(), product.getName(), product.getPrise(), product.getTotalPrise(), END_LINE_SIGHT));
    }

    private String headerFormation() {
        return String.format("%s %3s %20s %10s %10s %s",
                END_LINE_SIGHT, QUANTITY, DESCRIPTION, PRICE, TOTAL, END_LINE_SIGHT);
    }

    private String totalSumFormation(List<Product> products, double discountPercent) {
        String totalSumFormation;
        double totalSum = billCalculator.calculateTotalSum(products);
        double totalSumWithDiscount = billCalculator.calculateTotalSumWithDiscount(products, discountPercent);
        double totalDiscountSum = billCalculator.calculateTotalDiscountSum(products, discountPercent);
        if (discountPercent != 0) {
            totalSumFormation = String.format("%3s %35f %s %3s %35f %s",
                    TOTAL_DISCOUNT, totalDiscountSum, END_LINE_SIGHT, TOTAL_SUM, totalSumWithDiscount, END_LINE_SIGHT);
        } else {
            totalSumFormation = String.format("%3s %35f %s ",
                    TOTAL_SUM, totalSum, END_LINE_SIGHT);
        }
        return totalSumFormation;
    }

    private String delimiterFormation() {
        return String.format("%s %s",
                DELIMITER_LINE, END_LINE_SIGHT);
    }

}
