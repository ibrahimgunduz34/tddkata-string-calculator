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

        String[] arrInput = cleanedInput.split("\n");
        Integer total = 0;
        int i = 0;
        while (i < arrInput.length) {
            total += calculateTotal(arrInput[i++]);
        }
        return total;
    }

    private Integer calculateTotal(String cleanedInput) {
        String[] arrInput = cleanedInput.split(",", -1);
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
