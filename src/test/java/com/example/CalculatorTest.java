// src/test/java/com/example/CalculatorTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(4, calculator.add(2, 2));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-2, calculator.add(-1, -1));
    }

    @Test
    public void testSubtract() {
        assertEquals(0, calculator.subtract(2, 2));
        assertEquals(-2, calculator.subtract(-1, 1));
        assertEquals(0, calculator.subtract(-1, -1));
    }

    @Test
    public void testMultiply() {
        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(-2, calculator.multiply(-1, 2));
        assertEquals(1, calculator.multiply(-1, -1));
    }

    @Test
    public void testDivide() {
        assertEquals(1.0, calculator.divide(2, 2));
        assertEquals(-0.5, calculator.divide(-1, 2));
        assertEquals(1.0, calculator.divide(-2, -2));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }
}