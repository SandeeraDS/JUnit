package com.ds;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    @DisplayName("Testing add method")
    @EnabledOnOs(OS.WINDOWS)
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);

    }

    @Test
    void testDivide() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    @Test
    @Disabled
    void testDisabled(){
        fail("This test should be disabled");
    }


}
