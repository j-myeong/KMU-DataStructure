package data_structure;

public class LinkedList<E> implements List<E>{

    Link<E> head, tail;
    int size;

    public LinkedList(){
        tail = head = new Link<>(null, null);
        size = 0;
    }

    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    public void insert(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        Link<E> n = Link.get(item, curr.next);
        curr.next = n;

        if (curr == tail) tail = curr.next;

        size++;
    }

    public void append(E item) {
        Link<E> n = Link.get(item, null);
        tail.next = n;
        tail = n;
        size++;
    }

    public void update(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        curr.next.item = item;
    }

    public E getValue(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        return curr.next.item;
    }

    public E remove(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.next;
        
        E ret = curr.next.item;

        if (curr.next == tail)
            tail = curr;
        
        Link<E> tmp = curr.next;
        curr.next = curr.next.next;
        tmp.release();

        size--;

        return ret;
    }

    public int length() {
        return size;
    }

    public String toString() {
        Link<E> curr = head;
        String a = "";
        for(int i = 0; i < size; i++) {
            a += curr.next.item + ", ";
            curr = curr.next;
        }
        return a;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            Link<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public E next() {
                curr = curr.next;
                return curr.item;
            }

            @Override
            public boolean hasPrevious() {
                return curr != head;
            }

            @Override
            public E previous() {
                Link<E> tmp = head;
                while (tmp.next != curr) {
                    tmp = tmp.next;
                }
                curr = tmp;
                return curr.next.item;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> myList = new LinkedList<>();

        myList.append(3);
        System.out.println(myList);
        myList.insert(0, 1);
        System.out.println(myList);
        myList.insert(0, 4);
        System.out.println(myList);
        myList.append(0);
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
        myList.append(123);
        System.out.println(myList);
    }

}
