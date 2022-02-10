package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorAdditionTest {
    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForAdditionPositive")
    public void additionPositiveTest(double a, double b, double expected) {

        double result = calculator.sum(a, b);
        assertThat(result).as("").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForAdditionNegative")
    public void additionalNegativeTest(double a, double b, double expected) {

        double result = calculator.sum(a, b);
        assertThat(result).isNotEqualTo(expected);
    }
}
