package stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void add_empty_string_returns_zero() {
        assertEquals(Integer.valueOf(0), calculator.add(""));
    }

    @Test
    public void add_single_value_returns_itself() {
        assertEquals(Integer.valueOf(52), calculator.add("52"));
    }

    @Test
    public void add_multiple_numbers() {
        assertEquals(Integer.valueOf(160), calculator.add("52,24,36,48"));
    }
}