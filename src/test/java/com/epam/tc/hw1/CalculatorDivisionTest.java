package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class CalculatorDivisionTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForDivisionPositive")
    public void divisionPositiveTest(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertThat(result).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForDivisionByZero")
    public void divisionByZeroLongTest(long a, long b) {
        Throwable throwable = catchThrowable(() -> calculator.div(a, b));
        assertThat(throwable).isInstanceOf(NumberFormatException.class);
    }

    @Test(dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "getTestDataForDivisionByZero")
    public void divisionByZeroDoubleTest(double a, double b) {
        double result = calculator.div(a, b);
        assertThat(result).isEqualTo(Double.POSITIVE_INFINITY);
    }
}
