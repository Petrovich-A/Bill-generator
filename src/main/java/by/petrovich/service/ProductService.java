package by.petrovich.service;

import by.petrovich.model.InputData;
import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;

import java.util.List;

public interface ProductService {
    List<Product> receiveProducts(InputData inputData);

    List<ProductCalculationData> determineProductCalculationData(InputData inputData);

}
