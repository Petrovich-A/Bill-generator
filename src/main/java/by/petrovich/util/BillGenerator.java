package by.petrovich.util;

import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;

import java.util.List;

public interface BillGenerator {
    void printBillAsTable(List<Product> products, DiscountCard discountCard);

    List<Product> generateListProducts(Product product);

    List<Product> putTotalPrises(List<Product> products);

}
