package by.petrovich;

import by.petrovich.model.DiscountCard;
import by.petrovich.model.InputData;
import by.petrovich.model.Product;
import by.petrovich.model.ProductCalculationData;
import by.petrovich.service.impl.ProductServiceImpl;
import by.petrovich.util.FileReader;
import by.petrovich.util.Parser;

import java.util.List;

public class Main {

    private static final String PATH_TO_INPUT_DATA_FILE = "src/main/resources/inputData.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> inputLines = fileReader.fileReader(PATH_TO_INPUT_DATA_FILE);
        System.out.println("inputLines: " + inputLines.toString());

        Parser parser = new Parser();
        InputData inputData = parser.parseLines(inputLines);
        System.out.println("inputData: " + inputData.toString());

        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.receiveProducts(inputData);
        System.out.println(products);

        DiscountCard discountCard;
        discountCard = productService.receiveDiscountCard(inputData.getCardNumber());
        System.out.println("discountCard: " + discountCard);

        List<ProductCalculationData> productsCalculationData;
        productsCalculationData = productService.determineProductCalculationData(inputData);
        System.out.println("productsCalculationData: " + productsCalculationData);


    }
}