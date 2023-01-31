package by.petrovich.util;

import by.petrovich.model.BillFormationData;
import by.petrovich.service.BillWriter;

// It's not clear by name what interface it implements
// I would call it ConsoleBillWriter
// And it should be in Impl section. 
public class ConsoleWriter implements BillWriter {
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
