package softuni.advanced.iterators_comparators.ListyIterator;

import java.util.List;

public class ListyIterator {

    private List<String> elements;
    private int index = 0;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public void print() {
        validatePrint();
        System.out.println(this.elements.get(this.index));
    }

    private void validatePrint(){
        if(this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }
}
