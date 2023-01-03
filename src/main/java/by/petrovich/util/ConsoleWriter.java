package by.petrovich.util;

import by.petrovich.model.BillFormationData;
import by.petrovich.service.BillPrinter;

public class ConsoleWriter implements BillPrinter {
    /**
     * @param billFormationData
     * @return
     */
    @Override
    public void writeBill(BillFormationData billFormationData) {
        System.out.print(billFormationData.getHeader());
        System.out.print(billFormationData.getDelimiterLine());
        billFormationData.getProductRows().forEach(row -> System.out.print(row));
        System.out.print(billFormationData.getDelimiterLine());
        System.out.println(billFormationData.getTotalFooter());
    }

}
