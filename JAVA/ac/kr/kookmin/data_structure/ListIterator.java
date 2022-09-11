package ac.kr.kookmin.data_structure;

public interface ListIterator<E> {
    public boolean hasNext();
    public E next();
    public boolean hasPrevious();
    public E previous();
}
