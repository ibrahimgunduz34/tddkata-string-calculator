package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;
import stringcalculator.extractor.ContentExtractor;
import stringcalculator.extractor.DelimiterExtractor;

public class StringCalculator {
    private DelimiterExtractor delimiterExtractor;
    private ContentExtractor contentExtractor;

    public StringCalculator() {
        delimiterExtractor = new DelimiterExtractor();
        contentExtractor = new ContentExtractor();
    }

    public Integer add(String input) {
        String cleanedInput = input.trim();

        if (cleanedInput.isEmpty()) {
            return 0;
        }

        String delimiter = delimiterExtractor.extract(cleanedInput);
        String content = contentExtractor.extract(cleanedInput);

        String[] arrInput = content.split("\n");
        Integer total = 0;
        int i = 0;
        while (i < arrInput.length) {
            total += calculateTotal(arrInput[i++], delimiter);
        }
        return total;
    }

    private Integer calculateTotal(String cleanedInput, String delimiter) {
        String[] arrInput = cleanedInput.split(delimiter, -1);
        Integer total = 0;
        int i = 0;
        while (i < arrInput.length) {
            total += convertToInt(arrInput[i++]);
        }

        return total;
    }

    private Integer convertToInt(String value) {
        if (!NumberUtils.isCreatable(value)) {
            throw new IllegalArgumentException("Bad input value: " + value);
        }
        return Integer.valueOf(value);
    }
}
