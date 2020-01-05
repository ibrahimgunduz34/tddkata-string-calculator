package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;

public class StringCalculator {
    public Integer add(String input) {
        String cleanedInput = input.trim();

        if (cleanedInput.isEmpty()) {
            return 0;
        }

        if (!cleanedInput.contains(",")) {
            return convertToInt(cleanedInput);
        }

        String v1 = cleanedInput.substring(0, cleanedInput.indexOf(","));
        String v2 = cleanedInput.substring(cleanedInput.indexOf(",")+1);
        return convertToInt(v1) + convertToInt(v2);
    }

    private Integer convertToInt(String value) {
        if (!NumberUtils.isCreatable(value)) {
            throw new IllegalArgumentException("Bad input value: " + value);
        }
        return Integer.valueOf(value);
    }
}
