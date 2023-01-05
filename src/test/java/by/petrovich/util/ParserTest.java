package by.petrovich.util;

import by.petrovich.model.InputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void parseLines() {
        List<String> lines = new ArrayList<>();
        lines.add("1-12");
        lines.add("2-3");
        lines.add("5-4");
        lines.add("Card-1234");
        InputData actual = parser.parseLines(lines);
        Map<Integer, Integer> idToQuantity = new HashMap<>();
        idToQuantity.put(1, 12);
        idToQuantity.put(2, 3);
        idToQuantity.put(5, 4);
        int cardNumber = 1234;
        InputData expected = new InputData(idToQuantity, cardNumber);
        Assertions.assertEquals(actual, expected);
    }
}