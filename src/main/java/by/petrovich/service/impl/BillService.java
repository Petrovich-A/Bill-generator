package by.petrovich.service.impl;

import by.petrovich.model.Bill;
import by.petrovich.model.BillFormationData;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.BillCalculator;
import by.petrovich.service.ProductService;
import by.petrovich.util.BillFormatter;

import java.util.List;

public class BillService {

    private final BillCalculator billCalculator = new BillCalculatorImpl();

    private final ProductService productService = new ProductServiceImpl();
    private final BillFormatter billFormatter = new BillFormatter();

    public Bill receiveBill(List<ProductCalculationData> productsCalculationData) {
        return Bill.newBuilder()
                .withProductCalculationData(productsCalculationData)
                .withTotalPrise(billCalculator.calculateTotalCost(productsCalculationData))
                .withTotalDiscount(billCalculator.calculateTotalDiscount(productsCalculationData))
                .build();
    }

    public BillFormationData receiveBillFormationData(List<ProductCalculationData> productsCalculationData) {
        return billFormatter.billFormationDataGenerate(productsCalculationData);
    }

}
