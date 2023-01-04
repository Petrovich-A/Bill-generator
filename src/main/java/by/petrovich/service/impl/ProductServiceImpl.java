package by.petrovich.service.impl;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.ProductDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.dao.impl.ProductDaoImpl;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.InputData;
import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final int QUANTITY_FOR_GETTING_DISCOUNT = 5;
    private final double DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE = 10;
    private final ProductDao productDao = new ProductDaoImpl();
    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();
    private final ProductCalculatorImpl productCalculatorImpl = new ProductCalculatorImpl();

    @Override
    public List<ProductCalculationData> determineProductCalculationData(InputData inputData) {
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        List<ProductCalculationData> productsCalculationData = new ArrayList<>();
        for (Integer key : idToQuantity.keySet()) {
            Product product = productDao.readProductById(key);
            ProductCalculationData productCalculationData = new ProductCalculationData();
            productCalculationData.setProduct(product);
            productCalculationData.setQuantity(idToQuantity.get(product.getId()));
            productCalculationData.setCost(receiveCost(product.getPrise(), idToQuantity.get(product.getId())));
            productCalculationData.setDiscountAmount(receiveDiscount(inputData, idToQuantity, product, productCalculationData));
            productsCalculationData.add(productCalculationData);
        }
        return productsCalculationData;
    }

    private double receiveDiscount(InputData inputData, Map<Integer, Integer> idToQuantity, Product product, ProductCalculationData productCalculationData) {
        double discountAmount = 0.0;
        if (product.isOnSale() && idToQuantity.get(product.getId()) > QUANTITY_FOR_GETTING_DISCOUNT) {
            discountAmount = productCalculatorImpl.calculateDiscountAmount(productCalculationData.getCost(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE);
        } else if (inputData.getCardNumber() != 0) {
            DiscountCard discountCard = receiveDiscountCard(inputData.getCardNumber());
            discountAmount = productCalculatorImpl.calculateDiscountAmount(productCalculationData.getCost(), discountCard.getDiscountPercent());
        }
        return discountAmount;
    }

    private double receiveCost(double quantity, int productId) {
        return productCalculatorImpl.calculateCost(quantity, productId);
    }

    private DiscountCard receiveDiscountCard(int cardNumber) {
        return discountCardDao.readDiscountCardByNumber(cardNumber);
    }

}
