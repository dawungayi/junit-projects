package com.desmondawung;

public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        // if (b == 0) return 0;    // uncomment to make sure test fails if exception is not thrown
        return (double)(a/b);
    }

    // TDD - first stub a method - return 0
    public double computeCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
