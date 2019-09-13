import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;


public class FilteredList<E> extends LinkedList<E> {

    private final Predicate<E> filteredList;

    public FilteredList(final Predicate<E> filteredList) {
        this.filteredList = filteredList;
    }

    private void testElement(final E elem) {
        if (!filteredList.test(elem)) {
            throw new IllegalArgumentException(String.format("Element %s does not pass the test!", elem));
        }

    }

    @Override
    public boolean add(final E elem) {
        testElement(elem);
        return super.add(elem);
    }

    @Override
    public void add(final int value, final E elem) {
        testElement(elem);
        super.add(value, elem);
    }

    @Override
    public void addFirst(final E elem) {
        testElement(elem);
        super.addFirst(elem);
    }

    @Override
    public void addLast(final E elem) {
        testElement(elem);
        super.addLast(elem);
    }

    @Override
    public void push(final E elem) {
        addFirst(elem);
    }

    @Override
    public boolean offerFirst(final E elem) {
        addFirst(elem);
        return true;
    }

    @Override
    public boolean offer(final E elem) {
        addLast(elem);
        return true;
    }

    @Override
    public boolean offerLast(final E elem) {
        addLast(elem);
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends E> col) {
        col.forEach(this::testElement);
        return super.addAll(col);
    }

    @Override
    public boolean addAll(final int value, final Collection<?extends E> col){
        col.forEach(this::testElement);
        return super.addAll(value, col);
    }

}

