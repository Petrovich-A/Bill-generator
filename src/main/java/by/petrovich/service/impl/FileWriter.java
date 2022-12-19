package by.petrovich.service.impl;

import by.petrovich.model.Bill;
import by.petrovich.service.FilePusher;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter implements FilePusher {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String PATH_TO_FILE = "src/main/resources/outPut.txt";

    /**
     * @param bill
     */
    @Override
    public void writeFile(Bill bill) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_FILE);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(bill.toString());
            objectOutputStream.flush();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "File writing failed.", e);
            throw new RuntimeException(e);
        }
    }
}
