import mylinkedlist.MyLinkedList;

import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        int size = 10000;
        int times = 20;

        TestTime testTime = new TestTime(size, times);
        System.out.println(testTime.testMyList());
        System.out.println(testTime.testList());
        System.out.println(testTime.testSet());
        System.out.println(testTime.testMap());
    }
}
