package com.ds;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInt(){
        System.out.println("This needs to run before all");
    }

    @AfterAll
    static void afterAllInt(){
        System.out.println("This needs to run after all");
    }

    @BeforeEach
    void init() {
        System.out.println("Starting method...");
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning up...");
    }

    @Test
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);

    }

    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }


}
