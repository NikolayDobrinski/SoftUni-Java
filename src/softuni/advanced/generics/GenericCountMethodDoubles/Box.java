package softuni.advanced.generics.GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue (T value) {
        this.values.add(value);
    }

    public void swap (int index1, int index2) {
        T temporary = this.values.get(index1);
        this.values.set(index1, this.values.get(index2));
        this.values.set(index2, temporary);
    }

    public long countGreaterElements (T elementToCompare) {
        return this.values.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
