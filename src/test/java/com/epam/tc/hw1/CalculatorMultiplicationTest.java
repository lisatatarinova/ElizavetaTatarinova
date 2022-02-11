package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorMultiplicationTest {
    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForMultiplicationPositive")

    public void multiplicationPositiveTest(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        assertThat(result).isEqualTo(expected);
    }

}
