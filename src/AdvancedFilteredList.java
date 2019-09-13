import java.util.Collection;
import java.util.LinkedList;


public class AdvancedFilteredList<E> extends LinkedList<E> {

    private final AdvancedListFilter<E> filteredList;

    public AdvancedFilteredList(final AdvancedListFilter<E> filteredList) {
        this.filteredList = filteredList;
    }

    @Override
    public boolean add(final E elem) {

        return super.add(filteredList.filter(this, elem));
    }

    @Override
    public void add(final int index, final E elem) {
        super.add(index, filteredList.filter(this, elem));
    }

    @Override
    public void addFirst(final E elem) {
        super.addFirst(filteredList.filter(this, elem));
    }

    @Override
    public void addLast(final E elem) {
        super.addLast(filteredList.filter(this, elem));
    }

    @Override
    public void push(final E elem) {
        addFirst(filteredList.filter(this, elem));
    }

    @Override
    public boolean offerFirst(final E elem) {
        addFirst(filteredList.filter(this, elem));
        return true;
    }

    @Override
    public boolean offer(final E elem) {
        addLast(filteredList.filter(this, elem));
        return true;
    }

    @Override
    public boolean offerLast(final E elem) {
        addLast(filteredList.filter(this, elem));
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends E> col) {
        for (E elem : col) {
            try {
                add(elem);
            } catch (IllegalArgumentException e) {
            }
        }
        return true;
    }

    @Override
    public boolean addAll(final int value, final Collection<? extends E> col) {
        for (E elem : col) {
            try {
                add(elem);
            } catch (IllegalArgumentException e) {
            }
        }
        return true;
    }


}
