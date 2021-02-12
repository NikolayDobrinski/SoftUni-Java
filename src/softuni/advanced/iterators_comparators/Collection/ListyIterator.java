package softuni.advanced.iterators_comparators.Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;
    private int index = 0;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
    }

    public boolean move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        validatePrint();
        System.out.println(this.elements.get(this.index));
    }

    public void printAll() {
        validatePrint();
        this.elements.forEach(e -> System.out.print(e + " "));
    }

    private void validatePrint() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < elements.size() - 1;
            }

            @Override
            public Object next() {
                String element = elements.get(index);
                index++;
                return element;
            }
        };
    }
}
