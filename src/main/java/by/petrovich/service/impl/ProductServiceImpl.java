package by.petrovich.service.impl;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.ProductDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.dao.impl.ProductDaoImpl;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.InputData;
import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.ProductCalculator;
import by.petrovich.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final int QUANTITY_FOR_GETTING_DISCOUNT = 5;
    private final double DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE = 10;
    private final ProductDao productDao = new ProductDaoImpl();
    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();
    private final ProductCalculator productCalculatorImpl = new ProductCalculatorImpl();

    @Override
    public List<ProductCalculationData> determineProductCalculationData(InputData inputData) {
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        List<ProductCalculationData> productsCalculationData = new ArrayList<>();
        idToQuantity.forEach((k, v) -> {
            Product product = productDao.readProductById(k);
            if (product != null) {
                productsCalculationData.add(constructProductCalculationData(inputData, v, product));
            }
        });
        return productsCalculationData;
    }

    private ProductCalculationData constructProductCalculationData(InputData inputData, Integer quantity, Product product) {
        ProductCalculationData productCalculationData = new ProductCalculationData();
        productCalculationData.setProduct(product);
        productCalculationData.setQuantity(quantity);
        productCalculationData.setCost(productCalculatorImpl.calculateCost(product.getPrise(), quantity));
        productCalculationData.setDiscountAmount(receiveDiscount(inputData, quantity, product, productCalculationData.getCost()));
        return productCalculationData;
    }

    private double receiveDiscount(InputData inputData, Integer quantity, Product product, double cost) {
        double discountAmount = 0.0;
        if (product.isOnSale() && quantity > QUANTITY_FOR_GETTING_DISCOUNT) {
            discountAmount = productCalculatorImpl.calculateDiscountAmount(cost, DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE);
        } else if (inputData.getCardNumber() != 0) {
            DiscountCard discountCard = discountCardDao.readDiscountCardByNumber(inputData.getCardNumber());
            discountAmount = productCalculatorImpl.calculateDiscountAmount(cost, discountCard.getDiscountPercent());
        }
        return discountAmount;
    }

}
