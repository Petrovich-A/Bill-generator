package by.petrovich.util;

import by.petrovich.model.Product;

import java.util.List;

public class BillCalculator {
    public double findTotalProductsPrise(double prise, int quantity) {
        return prise * quantity;
    }

    public double findTotalBillPrise(List<Product> products) {
        double totalPrise = 0.0;
        for (Product product : products) {
            totalPrise += totalPrise + product.getPrise();
        }
        return totalPrise;
    }

    public double countPriseWithCardDiscount(double prise, double discount) {
        double priseWithDiscount = 0.0;
        return priseWithDiscount = prise * discount / 100;
    }
}
