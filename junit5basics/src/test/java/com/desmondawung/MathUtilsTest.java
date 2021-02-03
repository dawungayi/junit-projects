package com.desmondawung;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAdd() {
        // fail("Not yet implemented");
        // System.out.println("This test ran");
        MathUtils mathUtils = new MathUtils();
        int expected = 5;
        int a = 2, b = 3;
        int actual = mathUtils.add(a,b);
        // always good to put in a message when asserting something - better readability
        assertEquals(expected, actual, "The add method should sum up two numbers.");
    }

    @Test
    void testDivide() {
        MathUtils mathUtils = new MathUtils();
        // this test will fail for 2 reasons:
        // 1. exception was not thrown at all   2. the wrong exception was thrown
        // (expected type, executable (lambda))
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw.");
        // assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0),
                // "Divide by zero should throw.");

    }

    // Test-driven methodology with JUnit
    @Test
    void testComputeCircleRadius() {
        MathUtils mathUtils = new MathUtils();
        double r = 10;
        double expected = 314.1592653589793;    // hard-copied from what it should be
        // double expected = Math.PI * r * r;
        double actual = mathUtils.computeCircleArea(r);
        assertEquals(expected, actual, "Should compute the correct area of a circle given its radius.");
    }


}