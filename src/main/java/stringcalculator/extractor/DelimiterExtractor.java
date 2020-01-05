package stringcalculator.extractor;

public class DelimiterExtractor implements Extractor<String, String> {
    public String extract(String value) {
        String delimiter = ",";
        if (value.startsWith("//")) {
            delimiter = value.substring(2, value.indexOf("\n"));
        }
        return delimiter;
    }
}