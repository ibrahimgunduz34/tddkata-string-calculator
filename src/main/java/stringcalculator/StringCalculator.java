package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;
import stringcalculator.extractor.ContentExtractor;
import stringcalculator.extractor.DelimiterExtractor;
import stringcalculator.extractor.ValuesExtractor;

import javax.management.ValueExp;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private DelimiterExtractor delimiterExtractor;
    private ContentExtractor contentExtractor;
    private ValuesExtractor valuesExtractor;

    public StringCalculator() {
        delimiterExtractor = new DelimiterExtractor();
        contentExtractor = new ContentExtractor();
        valuesExtractor = new ValuesExtractor();
    }

    public Integer add(String input) {
        String cleanedInput = input.trim();

        if (cleanedInput.isEmpty()) {
            return 0;
        }

        String delimiter = delimiterExtractor.extract(cleanedInput);
        String content = contentExtractor.extract(cleanedInput);
        List<String> values = valuesExtractor.extract(content, delimiter);

        return calculateTotal(values);
    }

    private Integer calculateTotal(List<String> values) {
        Integer total = 0;
        int i = 0;
        Integer value;
        List<String> errors = new ArrayList<>();
        while (i < values.size()) {
            value = convertToInt(values.get(i++));
            if (value < 0) {
                errors.add(value.toString());
                continue;
            }
            total += value;
        }

        if (!errors.isEmpty()) {
            String negativeValues = String.join(",", values);
            throw new IllegalArgumentException("Negative values not allowed - " + negativeValues);
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
