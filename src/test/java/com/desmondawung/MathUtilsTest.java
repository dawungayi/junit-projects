package com.desmondawung;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class MathUtilsTest {

    private MathUtils mathUtils;    // member variable

    @BeforeEach     // runs before every test method is run
    void init() {
        mathUtils = new MathUtils();    // fresh instance every
    }


    // @BeforeAll and @AfterAll need to be static so they do not depend on creating a class instance for them to be run.
    // remember that @BeforeAll is run before the class itself is init
    @BeforeAll
    static void beforeAllInit() {
        System.out.println("Runs before class is init");
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up after each method");
    }

    @Nested
    @DisplayName("Testing add methods")  // gives a clear indicator of what the test method is doing
    class AddTest {

        @Test
        @DisplayName("Testing add method: +")  // gives a clear indicator of what the test method is doing
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "The add method should sum up two +ve numbers.");
        }

        @Test
        @DisplayName("Testing add method: -")  // gives a clear indicator of what the test method is doing
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "The add method should sum up two -ve numbers.");
        }
    }

    @Test
    @DisplayName("multiply method")
    void testMultiply() {
        // assertEquals(6, mathUtils.multiply(2, 3), "should return the right product");
        // runs thru all of these asserts and fails if any one of them fails
        assertAll(
                () -> assertEquals(6, mathUtils.multiply(2, 3)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @DisplayName("Testing the divide method.")
    void testDivide() {
        // this test will fail for 2 reasons:
        // 1. exception was not thrown at all   2. the wrong exception was thrown
        // (expected type, executable (lambda))
        boolean isServerUp = false;
        // this test does not run if the "isServerUp" is not true. For example if a test needs a server up and running to work,
        // assume the server is up before proceeding. if not up, don't run this test (and eventually break it)
        // this helps us distinguish between tests failing cuz of my logic and tests failing cuz of external factors
        assumeTrue(isServerUp);  // very different from assertion
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw.");
        // assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0),
                // "Divide by zero should throw.");

    }


    // Test-driven methodology with JUnit
    @Test
    @DisplayName("Testing the method that computes the area of the circle.")
    void testComputeCircleRadius() {
        double r = 10;
        double expected = 314.1592653589793;    // hard-copied from what it should be
        // double expected = Math.PI * r * r;
        double actual = mathUtils.computeCircleArea(r);
        assertEquals(expected, actual, "Should compute the correct area of a circle given its radius.");
    }

    @Test
    @DisplayName("TDD method. Disable for now")
    @Disabled
    void disabledTest() {
        fail("This test should be disabled.");
    }


}