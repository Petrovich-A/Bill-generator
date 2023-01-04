package by.petrovich.service;

import by.petrovich.model.InputData;
import by.petrovich.model.ProductCalculationData;

import java.util.List;

public interface ProductService {

    List<ProductCalculationData> determineProductCalculationData(InputData inputData);

}
