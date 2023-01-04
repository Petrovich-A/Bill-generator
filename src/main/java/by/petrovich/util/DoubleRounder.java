package by.petrovich.util;

import java.text.DecimalFormat;

public class DoubleRounder {
    private static final String ROUND_PATTERN = "0.00";

    public static Double doubleRound(double value) {
        DecimalFormat decimalFormat = new DecimalFormat(ROUND_PATTERN);
        String format = decimalFormat.format(value);
        return Double.parseDouble(format.replace(",", "."));
    }

}
