package by.petrovich.util;

import by.petrovich.model.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String REG_EX_DIGIT_DASH_DIGIT = "^\\d+-\\d+$";
    private static final String REG_EX_NON_DIGIT = "[^\\d.]";

    private static final String REG_EX_ALPHABETIC_DASH_DIGIT = "^\\D+-\\d+$";
    private final String DASH_SIGN = "-";

    public InputData parseLines(List<String> lines) {
        InputData inputData = new InputData();
        Map<Integer, Integer> idToQuantity = new HashMap<>();
        String[] arrayLines;
        for (String line : lines) {
            Matcher matcherForCard = determineMatcher(REG_EX_ALPHABETIC_DASH_DIGIT, line);
            Matcher matcherForIdToQuantity = determineMatcher(REG_EX_DIGIT_DASH_DIGIT, line);
            if (matcherForCard.find()) {
                inputData.setCardNumber(replaceNonDigitalSymbols(line));
            } else if (matcherForIdToQuantity.find()) {
                arrayLines = line.split(DASH_SIGN);
                idToQuantity.put(Integer.parseInt(arrayLines[0]), Integer.parseInt(arrayLines[1]));
                inputData.setIdToQuantity(idToQuantity);
            }
        }
        return inputData;
    }

    private Matcher determineMatcher(String regEx, String line) {
        Pattern patternForCard = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        return patternForCard.matcher(line);
    }

    private Integer replaceNonDigitalSymbols(String line) {
        return Integer.valueOf(line.replaceAll(REG_EX_NON_DIGIT, ""));
    }

}
