package by.petrovich.util;

import by.petrovich.model.*;
import by.petrovich.service.BillCalculator;
import by.petrovich.service.impl.BillCalculatorImpl;

import java.util.ArrayList;
import java.util.List;

public class BillFormatter {
    public static String STORE_NAME = "'Seven Heaven'";
    public static String STORE_ADDRESS = "Address: 7th Heaven, 77";
    public static String QUANTITY_COLUMN = "QTY";
    public static String DESCRIPTION_COLUMN = "DESCRIPTION";
    public static String PRICE_COLUMN = "PRICE";
    public static String TOTAL_COLUMN = "TOTAL";
    public static String TOTAL_COST = "TOTAL COST:";
    public static String TOTAL_DISCOUNT = "DISCOUNT:";
    public static String END_LINE_SIGHT = "\n";
    public static String DASH_SIGHT = "-";
    public static String DELIMITER_LINE = "-----------------------------------------------------------------------------";
    public static BillCalculator billCalculator = new BillCalculatorImpl();

    public BillFormationData billFormationDataGenerate(List<ProductCalculationData> productsCalculationData) {
        BillFormationData billFormationData = new BillFormationData();
        billFormationData.setHeader(headerFormation());
        billFormationData.setDelimiterLine(delimiterFormation());
        billFormationData.setProductRows(productRowsFormation(productsCalculationData));
        billFormationData.setTotalFooter(totalFooterFormation(productsCalculationData));
        return billFormationData;
    }

    private String headerFormation() {
        return String.format("%10s %s %5s %s %3s %20s %10s %10s %s",
                STORE_NAME, END_LINE_SIGHT, STORE_ADDRESS, END_LINE_SIGHT, QUANTITY_COLUMN, DESCRIPTION_COLUMN, PRICE_COLUMN, TOTAL_COLUMN, END_LINE_SIGHT);
    }

    private String delimiterFormation() {
        return String.format("%s %s",
                DELIMITER_LINE, END_LINE_SIGHT);
    }

    private List<String> productRowsFormation(List<ProductCalculationData> productsCalculationData) {
        List<String> productRows = new ArrayList<>();
        for (ProductCalculationData productCalculationData : productsCalculationData) {
            productRows.add(productRowFormation(productCalculationData));
            if (productCalculationData.getDiscountAmount() != 0) {
                productRows.add(discountRowFormation(productCalculationData));
            }
        }
        return productRows;
    }

    private String totalFooterFormation(List<ProductCalculationData> productsCalculationData) {
        String footer = null;
        double totalCost = billCalculator.calculateTotalCost(productsCalculationData);
        double totalDiscountAmount = billCalculator.calculateTotalDiscount(productsCalculationData);
        for (ProductCalculationData productCalculationData : productsCalculationData) {
            footer = totalCostFormation(totalCost);
            if (productCalculationData.getDiscountAmount() != 0) {
                footer += totalDiscountFormation(totalDiscountAmount);
            }
        }
        return footer;
    }

    private String totalCostFormation(double totalCost) {
        return String.format("%3s %35.2f %s ",
                TOTAL_COST, totalCost, END_LINE_SIGHT);
    }

    private String totalDiscountFormation(double totalDiscount) {
        return String.format("%3s %35.2f %s",
                TOTAL_DISCOUNT, totalDiscount, END_LINE_SIGHT);
    }

    private String discountRowFormation(ProductCalculationData productCalculationData) {
        return String.format("%40s %.2f %s",
                DASH_SIGHT, productCalculationData.getDiscountAmount(), END_LINE_SIGHT);
    }

    private String productRowFormation(ProductCalculationData productCalculationData) {
        return String.format("%3d %20s %10.2f %10.2f %s",
                productCalculationData.getQuantity(),
                productCalculationData.getProduct().getName(),
                productCalculationData.getProduct().getPrise(),
                productCalculationData.getCost(),
                END_LINE_SIGHT);
    }
}
