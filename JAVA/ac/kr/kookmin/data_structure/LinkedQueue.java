package ac.kr.kookmin.data_structure;

public class LinkedQueue<E> implements Queue<E> {
    Link<E> head, tail;
    int size;

    public LinkedQueue() {
        head = tail = new Link<>(null, null);
        size = 0;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    @Override
    public void enQueue(E item) {
        Link<E> n = new Link<>(item, null);
        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public E deQueue() {
        E ret = head.next.item;
        head.next = head.next.next;
        size--;
        return ret;
    }

    @Override
    public E frontValue() {
        return head.next.item;
    }

    @Override
    public E rearValue() {
        return tail.item;
    }

    @Override
    public String toString() {
        Link<E> curr = head;
        String ret = "";
        for(int i = 0; i < size; i++) {
            ret += curr.next.item + ", ";
            curr = curr.next;
        }
        return ret;
    }

}
