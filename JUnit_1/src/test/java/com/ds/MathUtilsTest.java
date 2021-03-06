package com.ds;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInt() {
        System.out.println("This needs to run before all");
    }

    @AfterAll
    static void afterAllInt() {
        System.out.println("This needs to run after all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Starting method...");
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Math")
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);

    }

    @Nested
    @Tag("Math")
    class NestedAddTest {
        @Test
        @DisplayName("When adding positive numbers")
        void testAddPositives() {
            assertEquals(2, mathUtils.add(1, 1), "Should return right sum");
        }

        @Test
        @DisplayName("When adding negative numbers")
        void testAddNegatives() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, ()->"Should return sum " + expected + " but return " + actual);// not this string concat is lazy,
        }
    }

    @Test
    @Tag("Math")
    void testDivide() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

//    @RepeatedTest(5)
//    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
//        System.out.println("current repetition = "+repetitionInfo.getCurrentRepetition());
//        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
//    }

    @Test
    @Tag("Circle")
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    @Test
    @Disabled
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    @DisplayName("multiply methods")
    @Tag("Math")
    void testMultiply() {
//        System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        // assertEquals(4,mathUtils.multiply(2,2));
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-1, mathUtils.multiply(1, -1))
        );
    }


}
