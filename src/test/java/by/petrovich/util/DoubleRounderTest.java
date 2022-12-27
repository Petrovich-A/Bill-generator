package by.petrovich.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoubleRounderTest {

    @Test
    void doubleRound() {
        double actual1 = DoubleRounder.doubleRound(12.276);
        double actual2 = DoubleRounder.doubleRound(1.9999999);
        double actual3 = DoubleRounder.doubleRound(154.004);
        double actual4 = DoubleRounder.doubleRound(584.005);
        double expected1 = 12.28;
        double expected2 = 2.00;
        double expected3 = 154.0;
        double expected4 = 584.0;
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
    }
}