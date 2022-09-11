package ac.kr.kookmin.data_structure;

public interface Queue<E> {
    public void clear();
    public void enQueue(E item);
    public E deQueue();
    public E frontValue();
    public E rearValue();
}
