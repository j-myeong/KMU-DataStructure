package Btree;

public class BSTTest {
    public static void main(String[] args) {
        System.out.println("Task 3 -------------------- ");
        Dictionary<Integer, String> task3 = new BST<>();

        task3.insert(5, "5");
        task3.insert(6, "6");
        task3.insert(8, "8");
        task3.insert(7, "7");
        task3.insert(9, "9");

        System.out.println("Before Size: " + task3.size());
        System.out.println("Remove: " + task3.removeAny()); // Root 제거
        System.out.println("Remove: " + task3.remove(8)); 
        System.out.println(task3.find(5));
        System.out.println(task3.find(6));
        System.out.println(task3.find(7));
        System.out.println(task3.find(8));
        System.out.println(task3.find(9));
        System.out.println("After Size: " + task3.size());

        System.out.println("\nTask 4 -------------------- ");
        Dictionary<Integer, String> task4 = new BST<>();

        task4.insert(5, "5번");
        task4.insert(4, "4번");
        task4.insert(9, "9번");
        task4.insert(7, "7번");
        task4.insert(11, "11번");
        task4.insert(2, "2번");
        task4.insert(3, "3번");
        task4.insert(6, "6번");
        task4.insert(1, "1번");
        task4.insert(10, "10번");
        task4.insert(8, "8번");

        task4.toString();
        System.out.println();
        task4.remove(7);
        task4.remove(2);
        task4.removeAny(); // Root 제거
        task4.toString();
    }

}


