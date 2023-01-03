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
    public List<Product> receiveProducts(InputData inputData) {
        List<Product> products = new ArrayList<>();
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        for (Integer key : idToQuantity.keySet()) {
            products.add(productDao.readProductById(key));
        }
        return products;
    }

    @Override
    public List<ProductCalculationData> determineProductCalculationData(InputData inputData) {
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        List<Product> products = receiveProducts(inputData);
        List<ProductCalculationData> productsCalculationData = new ArrayList<>();
        for (Product product : products) {
            ProductCalculationData productCalculationData = new ProductCalculationData();
            productCalculationData.setProduct(product);
            productCalculationData.setQuantity(idToQuantity.get(product.getId()));
            productCalculationData.setCost(productCalculatorImpl.calculateCost(product.getPrise(), idToQuantity.get(product.getId())));
            if (product.isOnSale() && idToQuantity.get(product.getId()) > QUANTITY_FOR_GETTING_DISCOUNT) {
                productCalculationData.setDiscountAmount(productCalculatorImpl.calculateDiscountAmount(productCalculationData.getCost(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
            } else if (inputData.getCardNumber() != 0) {
                DiscountCard discountCard = receiveDiscountCard(inputData.getCardNumber());
                productCalculationData.setDiscountAmount(productCalculatorImpl.calculateDiscountAmount(productCalculationData.getCost(), discountCard.getDiscountPercent()));
            }
            productsCalculationData.add(productCalculationData);
        }
        return productsCalculationData;
    }

    public DiscountCard receiveDiscountCard(int cardNumber) {
        return discountCardDao.readDiscountCardByNumber(cardNumber);
    }

}
