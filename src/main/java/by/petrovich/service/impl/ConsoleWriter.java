package by.petrovich.service.impl;

import by.petrovich.model.Bill;
import by.petrovich.service.FilePusher;

public class ConsoleWriter implements FilePusher {
    /**
     * @param bill
     */
    @Override
    public void writeFile(Bill bill) {
        System.out.print(bill.getHeaderLine());
        System.out.print(bill.getDelimiterLine());
        bill.getProductsRows().forEach(System.out::print);
        System.out.print(bill.getDelimiterLine());
        System.out.print(bill.getTotalSumLine());
    }
}
