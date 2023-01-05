package by.petrovich.util;

import by.petrovich.model.BillFormationData;
import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static by.petrovich.util.BillFormatter.DASH_SIGHT;
import static by.petrovich.util.BillFormatter.DELIMITER_LINE;
import static by.petrovich.util.BillFormatter.DESCRIPTION_COLUMN;
import static by.petrovich.util.BillFormatter.END_LINE_SIGHT;
import static by.petrovich.util.BillFormatter.PRICE_COLUMN;
import static by.petrovich.util.BillFormatter.QUANTITY_COLUMN;
import static by.petrovich.util.BillFormatter.STORE_ADDRESS;
import static by.petrovich.util.BillFormatter.STORE_NAME;
import static by.petrovich.util.BillFormatter.TOTAL_COLUMN;
import static by.petrovich.util.BillFormatter.TOTAL_COST;
import static by.petrovich.util.BillFormatter.TOTAL_DISCOUNT;

class BillFormatterTest {
    private final BillFormatter billFormatter = new BillFormatter();

    @Test
    void billFormationDataGenerate() {
        List<ProductCalculationData> productsCalculationData = new ArrayList<>();
        Product product1 = new Product(1, "name1", 0.55, true);
        Product product2 = new Product(2, "name2", 2.00, false);
        ProductCalculationData productCalculationData1 = new ProductCalculationData(product1, 2, 1.10, 0.11);
        ProductCalculationData productCalculationData2 = new ProductCalculationData(product2, 3, 6.00, 0.60);
        double totalCost = 7.10;
        double totalDiscount = 0.71;
        productsCalculationData.add(productCalculationData1);
        productsCalculationData.add(productCalculationData2);
        String header = String.format("%10s %s %5s %s %3s %20s %10s %10s %s",
                STORE_NAME, END_LINE_SIGHT, STORE_ADDRESS, END_LINE_SIGHT, QUANTITY_COLUMN, DESCRIPTION_COLUMN, PRICE_COLUMN, TOTAL_COLUMN, END_LINE_SIGHT);
        String delimiterLine = String.format("%s %s",
                DELIMITER_LINE, END_LINE_SIGHT);
        String productRow1 = String.format("%3d %20s %10.2f %10.2f %s",
                productCalculationData1.getQuantity(),
                productCalculationData1.getProduct().getName(),
                productCalculationData1.getProduct().getPrise(),
                productCalculationData1.getCost(),
                END_LINE_SIGHT);
        String discountRow1 = String.format("%40s %.2f %s",
                DASH_SIGHT, productCalculationData1.getDiscountAmount(), END_LINE_SIGHT);
        String productRow2 = String.format("%3d %20s %10.2f %10.2f %s",
                productCalculationData2.getQuantity(),
                productCalculationData2.getProduct().getName(),
                productCalculationData2.getProduct().getPrise(),
                productCalculationData2.getCost(),
                END_LINE_SIGHT);
        String discountRow2 = String.format("%40s %.2f %s",
                DASH_SIGHT, productCalculationData2.getDiscountAmount(), END_LINE_SIGHT);
        List<String> productRows = new ArrayList<>();
        productRows.add(productRow1);
        productRows.add(discountRow1);
        productRows.add(productRow2);
        productRows.add(discountRow2);
        String totalCostFormat = String.format("%3s %35.2f %s ",
                TOTAL_COST, totalCost, END_LINE_SIGHT);
        String totalDiscountFormat = String.format("%3s %35.2f %s",
                TOTAL_DISCOUNT, totalDiscount, END_LINE_SIGHT);
        String totalFooter = totalCostFormat + totalDiscountFormat;
        BillFormationData expected = new BillFormationData(header, delimiterLine, productRows, totalFooter);
        BillFormationData actual = billFormatter.billFormationDataGenerate(productsCalculationData);
        Assertions.assertEquals(expected, actual);
    }
}