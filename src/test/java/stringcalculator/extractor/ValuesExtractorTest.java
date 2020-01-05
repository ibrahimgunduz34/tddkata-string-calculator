package stringcalculator.extractor;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ValuesExtractorTest {
    private ValuesExtractor extractor;

    @Before
    public void setup() {
        extractor = new ValuesExtractor();
    }

    @Test
    public void extract_values_with_default_delimiter_from_simple_content() {
        assertEquals(Arrays.asList("5", "4", "3", "2", "1"), extractor.extract("5,4,3,2,1"));
    }

    @Test
    public void extract_values_with_default_delimiter_from_multiline_content() {
        assertEquals(Arrays.asList("5", "4", "3", "2", "1"), extractor.extract("5,4,3\n2,1"));
    }

    @Test
    public void extract_values_with_custom_delimiter_from_simple_content() {
        assertEquals(Arrays.asList("5", "4", "3", "2", "1"), extractor.extract("5;4;3;2;1", ";"));
    }

    @Test
    public void extract_values_with_custom_delimiter_from_multiline_content() {
        assertEquals(Arrays.asList("5", "4", "3", "2", "1"), extractor.extract("5;4;3\n2;1", ";"));
    }
}