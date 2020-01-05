package stringcalculator.extractor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContentExtractorTest {
    private ContentExtractor extractor;

    @Before
    public void setup() {
        extractor = new ContentExtractor();
    }

    @Test
    public void extract_with_custom_delimiter() {
        String given = "//;\n5;2\n3;2";
        assertEquals("5;2\n3;2", extractor.extract(given));
    }

    @Test
    public void extract_simple_content() {
        String given = "5,2\n3,2";
        assertEquals("5,2\n3,2", extractor.extract(given));
    }
}