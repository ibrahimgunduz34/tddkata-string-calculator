package stringcalculator.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValuesExtractor implements Extractor<List, String> {
    private final static String DEFAULT_DELIMITER = ",";

    @Override
    public List<String> extract(String value) {
        return extract(value, DEFAULT_DELIMITER);
    }

    public List<String> extract(String value, String delimiter) {
        return Arrays.stream(value.split("\n"))
                .map(row -> Arrays.stream(row.split(delimiter, -1)))
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }
}
