package stringcalculator.extractor;

public interface Extractor<T, V> {
    T extract(V value);
}
