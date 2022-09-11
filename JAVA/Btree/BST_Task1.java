package Btree;

public class BST_Task1<K extends Comparable<K>, E> implements Dictionary<K, E> {

    class Entry {
        public K key;
        public E element;
        public Entry(K key, E element) {
            this.key = key;
            this.element = element;
        }
    }

    private BinNode<Entry> root;
    private int size = 0;

    public BST_Task1() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(K k, E e) {
        root = insert_helper(k, e, root);
        size++;
    }

    public BinNode<Entry> insert_helper(K k, E e, BinNode<Entry> rt) {
        if (rt == null) {
            return new LNode<>(new Entry(k, e));
        }
        else if (rt.element().key.compareTo(k) == 0) rt.element().element = e;
        else if (rt.element().key.compareTo(k) < 0) {
            rt.setRight(insert_helper(k, e, rt.right()));
        }
        else {
            rt.setLeft(insert_helper(k, e, rt.left()));
        }

        return rt;
    }

    @Override
    public E remove(K k) {
        E ret = find_helper(k, root);
        if (ret != null) {
            root = remove_helper(k, root);
            size--;
        }
        return ret;
    }

    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt) {
        if (rt.element().key.compareTo(k) > 0) rt.setLeft(remove_helper(k, rt.left()));
        else if (rt.element().key.compareTo(k) < 0) rt.setRight(remove_helper(k, rt.right()));
        else {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else {
                Entry leftMost = getLeftMost(rt.right());
                rt.setElement(leftMost);
                rt.setRight(removeLeftMost(rt.right()));
            }
        }
        return rt;
    }

    private Entry getLeftMost(BinNode<Entry> rt) {
        BinNode<Entry> cur = rt;
        while (cur.left() != null) cur = cur.left();
        return cur.element();
    }


    private BinNode<Entry> removeLeftMost(BinNode<Entry> rt) {
        if (rt.left() == null) return rt.right();
        else {
            rt.setLeft(removeLeftMost(rt.left()));
            return rt;
        }
    }
    
    @Override
    public E removeAny() {
        return null;
    }

    @Override
    public E find(K k) {
        return find_helper(k, root); 
    }

    public E find_helper(K k, BinNode<Entry> rt) {
        if (rt == null) return null;
        else if (rt.element().key.compareTo(k) == 0) {
            return rt.element().element;
        }
        else if (rt.element().key.compareTo(k) < 0) return find_helper(k, rt.right());
        else return find_helper(k, rt.left());
    }

    @Override
    public int size() {
        return size;
    }
    
}
