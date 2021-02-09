package softuni.advanced.generics.CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T value) {
        this.data.add(value);
    }

    public void swap(int index1, int index2) {
        T temporary = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, temporary);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public T getMax() {
        T maxT1 = this.data.get(0);
        for (T datum : data) {
            if (datum.compareTo(maxT1) > 0) {
                maxT1 = datum;
            }
        }
        return maxT1;
    }

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public T getMin() {
        T minT1 = this.data.get(0);
        for (T datum : data) {
            if (datum.compareTo(minT1) < 0) {
                minT1 = datum;
            }
        }
        return minT1;
    }

    public long countGreaterThan(T elementToCompare) {
        return this.data.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.data) {
            sb
                    .append(String.format("%s", value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
