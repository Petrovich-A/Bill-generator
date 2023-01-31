package by.petrovich.service.impl;

import by.petrovich.model.Bill;
import by.petrovich.model.BillFormationData;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.BillCalculator;
import by.petrovich.util.BillFormatter;

import java.util.List;

// Why is it different from other services that use ...Impl approach? 
public class BillService {

    private final BillCalculator billCalculator = new BillCalculatorImpl();

    private final BillFormatter billFormatter = new BillFormatter();

    public Bill receiveBill(List<ProductCalculationData> productsCalculationData) {
        // Looks over-engineered to me
        // Could be just the new instance and setting properties
        // In my opinion builder better suits for more complex cases
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
