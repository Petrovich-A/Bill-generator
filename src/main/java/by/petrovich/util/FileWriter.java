package by.petrovich.util;

import by.petrovich.model.BillFormationData;
import by.petrovich.service.BillPrinter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter implements BillPrinter {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String PATH_TO_FILE = "src/main/resources/outputData.txt";

    /**
     * @param billFormationData
     * @return
     */
    @Override
    public void writeBill(BillFormationData billFormationData) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_FILE);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(billFormationData.toString());
            objectOutputStream.flush();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "File writing failed.", e);
            throw new RuntimeException(e);
        }
    }
}
