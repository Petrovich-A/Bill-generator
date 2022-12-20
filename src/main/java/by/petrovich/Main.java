package by.petrovich;

import by.petrovich.model.Bill;
import by.petrovich.model.DiscountCard;
import by.petrovich.model.Product;
import by.petrovich.service.DiscountCardService;
import by.petrovich.service.ProductService;
import by.petrovich.service.impl.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> idToQuantity = new HashMap<>();
        idToQuantity.put(1, 2);
        idToQuantity.put(2, 3);
        idToQuantity.put(3, 6);
        DiscountCard discountCard = new DiscountCard(1234, 10);

        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Integer> value : idToQuantity.entrySet()) {
            products.add(new Product(value.getKey(), value.getValue()));
        }
        Product product1 = products.get(0);
        Product product2 = products.get(1);
        Product product3 = products.get(2);
        product1.setName("name1");
        product1.setOnSale(true);
        product1.setPrise(10);
        product2.setName("name2");
        product2.setOnSale(false);
        product2.setPrise(5);
        product3.setName("name3");
        product3.setOnSale(true);
        product3.setPrise(12.7);

        BillGeneratorImpl billGenerator = new BillGeneratorImpl();
        List<Product> productsFull = billGenerator.determineTotalPrises(products);
        System.out.println(productsFull);
        Bill bill = billGenerator.billCreator(productsFull, discountCard);
        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeFile(bill);

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeFile(bill);

        DiscountCardService discountCardService = new DiscountCardServiceImpl();
        List<DiscountCard> discountCardsFromDB = discountCardService.receiveAllDiscountCards();
        discountCardsFromDB.forEach(discountCardFromDB -> System.out.println(discountCardFromDB.toString()));

        ProductService productService = new ProductServiceImpl();
        Bill bill1 = productService.receiveBill(1, 3, 1234);

        FileWriter fileWriter1 = new FileWriter();
        fileWriter1.writeFile(bill1);


    }
}