package by.petrovich.dao;

import by.petrovich.model.Product;

public interface ProductDao {
    Product readProductById(int id);
}
