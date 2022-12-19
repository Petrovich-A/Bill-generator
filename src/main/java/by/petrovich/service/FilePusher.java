package by.petrovich.service;

import by.petrovich.model.Bill;

public interface FilePusher {
    void writeFile (Bill bill);
}
