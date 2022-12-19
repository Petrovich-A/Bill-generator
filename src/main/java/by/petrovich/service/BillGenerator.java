package by.petrovich.service;

import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;

import java.util.List;

public interface BillGenerator {
    Bill billCreator(List<Product> products, DiscountCard discountCard);

    List<Product> determineTotalPrises(List<Product> products);

}
