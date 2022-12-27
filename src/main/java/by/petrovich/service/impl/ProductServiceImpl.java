package by.petrovich.service.impl;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.ProductDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.dao.impl.ProductDaoImpl;
import by.petrovich.model.*;
import by.petrovich.service.DiscountCardService;
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
    private final DiscountCardService discountCardService = new DiscountCardServiceImpl();

    public List<Product> receiveProducts(InputData inputData) {
        List<Product> products = new ArrayList<>();
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        for (Integer key : idToQuantity.keySet()) {
            products.add(productDao.readProductById(key));
        }
        return products;
    }

    public List<ProductCalculationData> determineProductCalculationData(InputData inputData) {
        Map<Integer, Integer> idToQuantity = inputData.getIdToQuantity();
        List<Product> products = receiveProducts(inputData);
        List<ProductCalculationData> productsCalculationData = new ArrayList<>();
        ProductCalculationData productCalculationData = new ProductCalculationData();
        for (Product product : products) {
            productCalculationData.setProduct(product);
            productCalculationData.setQuantity(inputData.getIdToQuantity().get(product.getId()));
            if (product.isOnSale() && inputData.getIdToQuantity().get(product.getId()) > QUANTITY_FOR_GETTING_DISCOUNT) {
                productCalculationData.setCost(productCalculatorImpl.calculateCostWithDiscount(product.getPrise(), idToQuantity.get(product.getId()),
                        DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
                productCalculationData.setDiscountAmount(productCalculatorImpl.calculateDiscountAmount(product.getPrise(), DISCOUNT_PERCENT_FOR_PRODUCTS_ON_SALE));
            } else if (inputData.getCardNumber() != 0) {
                DiscountCard discountCard = receiveDiscountCard(inputData.getCardNumber());
                productCalculationData.setCost(productCalculatorImpl.calculateCostWithDiscount(product.getPrise(), idToQuantity.get(product.getId()),
                        discountCard.getDiscountPercent()));
                productCalculationData.setDiscountAmount(productCalculatorImpl.calculateDiscountAmount(product.getPrise(), discountCard.getDiscountPercent()));
            }else {
                productCalculationData.setCost(productCalculatorImpl.calculateCost(product.getPrise(), idToQuantity.get(product.getId())));
            }
            productsCalculationData.add(productCalculationData);
        }
        return productsCalculationData;
    }

    /**
     * @param idProduct
     * @param quantity
     * @return
     */
    @Override
    public Bill receiveBill(int idProduct, int quantity, int discountCardNumber) {
        DiscountCard discountCard = discountCardDao.readDiscountCardByNumber(discountCardNumber);
        List<Product> products = new ArrayList<>();
        products.add(productDao.readProductById(idProduct));
//        List<Product> productsWithTotalPrises = billGenerator.determineTotalPrises(products);
//        return billGenerator.billCreator(productsWithTotalPrises, discountCard);
        Bill bill = Bill.newBuilder().build();
        return bill;
    }

    public DiscountCard receiveDiscountCard(int cardNumber) {
        return discountCardDao.readDiscountCardByNumber(cardNumber);
    }

}
