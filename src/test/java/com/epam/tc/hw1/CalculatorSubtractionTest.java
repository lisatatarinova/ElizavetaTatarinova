package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorSubtractionTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForSubtractionPositive")
    public void subtractionPositiveTest(long a, long b, long expected) {
        double result = calculator.sub(a, b);
        assertThat(result).isEqualTo(expected);
    }

}
