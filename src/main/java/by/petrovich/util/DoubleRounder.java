package by.petrovich.util;

import java.text.DecimalFormat;

public class DoubleRounder {
    private final String DECIMAL_ROUND = "0.00";

    public static Double doubleRound(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(value);
        return Double.parseDouble(format.replace(",", "."));
    }

}
