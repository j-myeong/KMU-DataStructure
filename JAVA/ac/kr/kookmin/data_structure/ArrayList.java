package ac.kr.kookmin.data_structure;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 10;
    private int listSize;
    private int size;
    private E[] data;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size) {
        listSize = 0;
        this.size = size;
        data = (E[]) new Object[size];
    }

    @Override
    public void clear() {
        listSize = 0;
    }

    @Override
    public void insert(int pos, E item) {
        if (listSize >= size) {
            E[] tmp = (E[]) new Object[size * 2];
            size *= 2;
            for(int i = 0; i < listSize; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
        for (int i = listSize; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = item;
        listSize++;
    }

    @Override
    public void append(E item) {
        if (listSize >= size) {
            E[] tmp = (E[]) new Object[size * 2];
            size *= 2;
            for(int i = 0; i < listSize; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
        data[listSize++] = item;
    }

    @Override
    public void update(int pos, E item) {
        data[pos] = item;
    }

    @Override
    public E getValue(int pos) {
        return data[pos];
    }

    @Override
    public E remove(int pos) {
        E ret = data[pos];
        listSize--;
        for (int i = pos; i < listSize; i++) {
            data[i] = data[i + 1];
        }
        return ret;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < size; i++)
            ret += (data[i] + ", ");
        return ret;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>(){
            int pos = 0;

            public boolean hasNext(){
                return pos < listSize;
            }
            public E next(){
                return data[pos++];
            }
            public boolean hasPrevious(){
                return pos > 0;

            }
            public E previous(){

                return data[--pos];
            }

        };
    }
    
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.append(3);
        System.out.println(myList);
        myList.append(4);
        System.out.println(myList);
        myList.insert(0, 2);
        System.out.println(myList);
        myList.append(5);
        System.out.println(myList);
        myList.update(3, 9);
        System.out.println(myList);
        System.out.println("Before Remove : " + myList.length());
        myList.remove(3);
        System.out.println("After Remove : " + myList.length());
        myList.clear();
        System.out.println("After Clear : " + myList.length());
        myList.append(1);
        System.out.println(myList);
        myList.append(3);
        System.out.println(myList);
        myList.insert(1, 2);
        for (int i = 4; i <= 11; i++) {
            myList.append(i);
        }
        System.out.println(myList);
    }
}