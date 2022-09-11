package ac.kr.kookmin.data_structure;

public class TestAll {
    
    public static void main(String[] args) {
        System.out.println("Doubly Linked List ##########");
        List<Integer> myList = new DList<>();
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

        System.out.println("Iterator Test -----");
        ListIterator myIterator = myList.listIterator();
        while(myIterator.hasNext()) {
            System.out.print(myIterator.next() + ", ");
        }
        System.out.println();
        myIterator.next();
        while(myIterator.hasPrevious()) {
            System.out.print(myIterator.previous() + ", ");
        }
        System.out.println();

        System.out.println("\nArray Stack ##########");
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("top value: " + stack.topValue()); 
        System.out.println("length: " + stack.length());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.clear();
        stack.push(7);
        stack.push(8);
        System.out.println(stack);

        System.out.println("\nLinked Queue ##########");
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(6);
        queue.enQueue(7);
        System.out.println(queue);
        System.out.println("frontValue: " + queue.frontValue());
        System.out.println("rearValue: " + queue.rearValue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue);
        queue.clear();
        queue.enQueue(2);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println(queue);
        System.out.println(queue.deQueue());
    }
}
