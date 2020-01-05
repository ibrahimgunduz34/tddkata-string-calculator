package stringcalculator.extractor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelimiterExtractorTest {
    private DelimiterExtractor extractor;

    @Before
    public void setup() {
        extractor = new DelimiterExtractor();
    }

    @Test
    public void extract_custom_delimiter() {
        String given = "//;\n5;2\n3;2";
        assertEquals(";", extractor.extract(given));
    }

    @Test
    public void extrat_default_delimiter() {
        String given = "5,2\n3,2";
        assertEquals(",", extractor.extract(given));
    }
}