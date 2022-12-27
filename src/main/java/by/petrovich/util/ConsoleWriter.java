package by.petrovich.util;

import by.petrovich.model.BillFormationData;
import by.petrovich.service.BillPrinter;

public class ConsoleWriter implements BillPrinter {
    /**
     * @param billFormationData
     */
    @Override
    public void writeBill(BillFormationData billFormationData) {
        System.out.print(billFormationData.getHeader());
        System.out.print(billFormationData.getDelimiterLine());
        billFormationData.getProductRows().forEach(System.out::print);
        System.out.print(billFormationData.getDelimiterLine());
        System.out.print(billFormationData.getTotalFooter());
    }
}
