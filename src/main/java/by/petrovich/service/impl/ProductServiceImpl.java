package by.petrovich.service.impl;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.ProductDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.dao.impl.ProductDaoImpl;
import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;
import by.petrovich.service.BillGenerator;
import by.petrovich.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();
    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();
    private final BillGenerator billGenerator = new BillGeneratorImpl();

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
        List<Product> productsWithTotalPrises = billGenerator.determineTotalPrises(products);
        return billGenerator.billCreator(productsWithTotalPrises, discountCard);
    }
}
