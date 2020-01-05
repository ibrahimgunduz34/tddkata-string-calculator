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

    @Test(expected = IllegalArgumentException.class)
    public void add_handle_error_single_bad_input() {
        calculator.add("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_handle_error_invalid_value_in_multi_line_input() {
        calculator.add("1,a\n24,48");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_handle_error_invalid_value_in_multiple_lines_with_empty_string() {
        calculator.add("1,\n5,6");
    }

    @Test
    public void add_multiple_numbers() {
        assertEquals(Integer.valueOf(160), calculator.add("52,24,36,48"));
    }

    @Test
    public void add_values_in_multiple_lines() {
        assertEquals(Integer.valueOf(160), calculator.add("52,24\n36,48"));
    }

    @Test
    public void add_values_with_custom_delimiter() {
        assertEquals(Integer.valueOf(160), calculator.add("//;\n52;24\n36;48"));
    }
}