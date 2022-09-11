package ac.kr.kookmin.data_structure;

public class DList<E> implements List<E> {

    DLink<E> head, tail;
    int size;

    public DList() {
        head = new DLink<E>(null, null, tail);
        tail = new DLink<E>(null, head, null);
        size = 0;
    }

    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void insert(int pos, E item) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        curr.next = new DLink<E>(item, curr, curr.next);
        curr.next.next.prev = curr.next;
        size++;
    }

    public void append(E item) {
        DLink<E> n = new DLink<E>(item, tail.prev, tail);
        tail.prev = n;
        n.prev.next = n;
        size++;
    }

    public void update(int pos, E item) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        curr.next.item = item;
    }

    public E getValue(int pos) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        return curr.next.item;
    }

    public E remove(int pos){
        DLink <E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        E ret = curr.next.item;
        curr.next = curr.next.next;
        curr.next.prev = curr;
        size--;
        return ret;
    }

    public int length() {
        return size;
    }

    public String toString() {
        DLink<E> curr = head;
        String a = "";
        for(int i = 0; i < size; i++) {
            a += curr.next.item + ", ";
            curr = curr.next;
        }
        return a;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != tail.prev;
            }

            @Override
            public E next() {
                curr = curr.next;
                return curr.item;
            }

            @Override
            public boolean hasPrevious() {
                return curr != head.next;
            }

            @Override
            public E previous() {
                curr = curr.prev;
                return curr.item;
            }
        };
    }
    
}
