package by.petrovich.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FileReaderTest {
    private final String PATH_TO_INPUT_DATA_TEST_FILE = "src/test/resources/properties/inputDataTest.txt";
    private final FileReader fileReader = new FileReader();

    @Test
    void fileReader() {
        List<String> expected = new ArrayList<>();
        expected.add("1-3");
        expected.add("Card-1234");
        expected.add("5-12");
        List<String> actual = fileReader.fileReader(PATH_TO_INPUT_DATA_TEST_FILE);
        Assertions.assertEquals(actual, expected);
    }
}