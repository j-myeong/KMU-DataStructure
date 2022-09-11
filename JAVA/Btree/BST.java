package Btree;

public class BST<K extends Comparable<K>, E> implements Dictionary<K, E> {

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

    public BST() {
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
            if (rt.isLeaf()) rt = new INode<>(new Entry(rt.element().key, rt.element().element), null, null);
            rt.setRight(insert_helper(k, e, rt.right()));
        }
        else {
            if (rt.isLeaf()) rt = new INode<>(new Entry(rt.element().key, rt.element().element), null, null);
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
        if (rt.isLeaf()) rt = new LNode<Entry>(new Entry(rt.element().key, rt.element().element));
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
            if (rt.isLeaf()) rt = new LNode<Entry>(new Entry(rt.element().key, rt.element().element));
            return rt;
        }
    }
    
    @Override
    public E removeAny() {
        return remove(root.element().key);
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
    
    public void inorder_helper(BinNode<Entry> rt) {
        if(rt == null) return;
        inorder_helper(rt.left());
        System.out.println("Key: " + rt.element().key + " & Element: " + rt.element().element + " & Type : " + rt.getClass().getName()); // visit
        inorder_helper(rt.right());
    }

    public void inorder() {
        inorder_helper(root);
    }

    public String toString() {
        inorder();
        return "finished";
    }

}
