package by.petrovich.service;

import by.petrovich.model.Bill;

public interface ProductService {
    public Bill receiveBill(int idProduct, int quantity, int discountCardNumber);
}
