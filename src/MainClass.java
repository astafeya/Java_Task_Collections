import mylinkedlist.MyLinkedList;

import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        int size = 10;
        int times = 10;
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            myLinkedList.add(newElement);
            javaLinkedList.add(newElement);
        }
        double startTime = 0, myInsertTime = 0, javaInsertTime = 0, myRemoveTime = 0, javaRemoveTime = 0,
                myAddTime = 0, javaAddTime = 0;

        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            myLinkedList.add(newElement);
            myAddTime = myAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            javaLinkedList.add(newElement);
            javaAddTime = javaAddTime + System.nanoTime() - startTime;

            //-----Insert-----
            newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            myLinkedList.add(size / 2, newElement);
            myInsertTime = myInsertTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            javaLinkedList.add(size / 2, newElement);
            javaInsertTime = javaInsertTime + System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            myLinkedList.remove(size / 2);
            myRemoveTime = myRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            javaLinkedList.remove(size / 2);
            javaRemoveTime = javaRemoveTime + System.nanoTime() - startTime;
        }
        myInsertTime /= times;
        javaInsertTime /= times;
        myRemoveTime /= times;
        javaRemoveTime/= times;
        myAddTime /= times;
        javaAddTime/= times;

        System.out.println("Add\nJava: " + javaAddTime + "\nMy: " + myAddTime);
        System.out.println("Insert\nJava: " + javaInsertTime + "\nMy: " + myInsertTime);
        System.out.println("Remove\nJava: " + javaRemoveTime + "\nMy: " + myRemoveTime);
    }
}
