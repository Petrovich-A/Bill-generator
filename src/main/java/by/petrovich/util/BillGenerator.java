package by.petrovich.util;

import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;

import java.util.List;

public interface BillGenerator {
    void printBillAsTable(Bill bill, List<Product> products);

    List<Product> generateListProducts(Product product);

    List<Product> putTotalPrises(List<Product> products);

}
