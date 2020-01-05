package stringcalculator.extractor;

public class ContentExtractor implements Extractor<String, String> {
    public String extract(String value) {
        return value.startsWith("//") ?
                value.substring(value.indexOf("\n")+1) :
                value;
    }
}
