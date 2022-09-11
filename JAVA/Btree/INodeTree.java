package Btree;

public class INodeTree {
    public static void main(String[] args) {
        BinNode<String> 교 = new INode<>("H", null, null); // LNode
        BinNode<String> 수 = new INode<>("E", 교, null);
        BinNode<String> 님 = new INode<>("L", null, null); // LNode
        BinNode<String> 사 = new INode<>("L", 수, 님);
        BinNode<String> 랑 = new INode<>("L", null, null); // LNode
        BinNode<String> 합 = new INode<>("D", 랑, null);
        BinNode<String> 니 = new INode<>("R", null, 합);
        BinNode<String> 다 = new INode<>("W", null, null); // LNode
        BinNode<String> 하 = new INode<>("O", 다, 니);
        BinNode<String> 트 = new INode<>("O", 사, 하);
        System.out.print("Preorder: ");
        preorder(트);
        System.out.println();
        System.out.print("Inorder: ");
        inorder(트);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(트);
        System.out.println();
    }
    
    public static <E> void preorder(BinNode<E> rt) {
        if(rt == null) return;
        System.out.print(rt.element()); // visit
        preorder(rt.left());
        preorder(rt.right());
    }

    public static <E> void inorder(BinNode<E> rt) {
        if(rt == null) return;
        inorder(rt.left());
        System.out.print(rt.element()); // visit
        inorder(rt.right());
    }

    public static <E> void postorder(BinNode<E> rt) {
        if(rt == null) return;
        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element()); // visit
    }
}
