package ac.kr.kookmin.data_structure;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_SIZE = 10;
    private int maxSize;
    private int top;
    private E[] listArray;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int size) {
        maxSize = size;
        top = -1;
        listArray = (E[]) new Object[maxSize];
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public void push(E item) {
        listArray[++top] = item;
    }

    @Override
    public E pop() {
        return listArray[top--];
    }

    @Override
    public E topValue() {
        return listArray[top];
    }

    @Override
    public int length() {
        return top + 1;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i <= top; i++)
            ret += listArray[i] + ", ";
        return ret;
    }
    
}
