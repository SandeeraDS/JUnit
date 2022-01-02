package com.healthycoderapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all unit test.");
    }

    @AfterAll
    static  void afterAll(){
        System.out.println("After all unit test.");
    }

    @Test
    void should_ReturnTrue_When_DietRecommended() {
        //given
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
        //given
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {
        //given
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);

        //then
        assertAll(() -> assertEquals(1.82, coderWorstBMI.getHeight()), () -> assertEquals(98, coderWorstBMI.getWeight()));

    }

    @Test
    void should_ReturnNullWorstBMI_When_CoderListEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);

        //then
        assertNull(coderWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));

        double[] expected = {18.52, 29.59, 19.53};

        //when
        double[] bmiScores = BMICalculator.getBMIScores(coderList);

        //then
        assertArrayEquals(expected,bmiScores);
    }
}
