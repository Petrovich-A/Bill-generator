package by.petrovich;

import by.petrovich.model.*;
import by.petrovich.service.DiscountCardService;
import by.petrovich.service.impl.BillService;
import by.petrovich.service.impl.DiscountCardServiceImpl;
import by.petrovich.service.impl.ProductServiceImpl;
import by.petrovich.util.ConsoleWriter;
import by.petrovich.util.FileReader;
import by.petrovich.util.FileWriter;
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

        DiscountCardService discountCardService = new DiscountCardServiceImpl();
        DiscountCard discountCard = discountCardService.readDiscountCardByNumber(inputData.getCardNumber());
        System.out.println("discountCard: " + discountCard);

        ProductServiceImpl productService = new ProductServiceImpl();
        // if you use one-liners above then keep your style 
        List<ProductCalculationData> productsCalculationData = productService.determineProductCalculationData(inputData);
        System.out.println("productsCalculationData: " + productsCalculationData);

        BillService billService = new BillService();
        Bill bill = billService.receiveBill(productsCalculationData);
        System.out.println("bill: " + bill);

        BillFormationData billFormationData = billService.receiveBillFormationData(productsCalculationData);
        // Empty println looks a bit lost. 
        // Better to print at least something like "Receiving bill completed" 
        System.out.println();

        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeBill(billFormationData);

        System.out.println();

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeBill(billFormationData);
    }
}