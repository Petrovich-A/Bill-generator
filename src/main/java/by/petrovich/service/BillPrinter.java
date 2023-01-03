package by.petrovich.service;

import by.petrovich.model.BillFormationData;

public interface BillPrinter {
    void writeBill(BillFormationData billFormationData);
}
