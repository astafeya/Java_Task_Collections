import mylinkedlist.MyLinkedList;
import java.util.*;

public class TestTime {
    int size;
    int times;

    public TestTime(int size, int times) {
        this.size = size;
        this.times = times;
    }

    private long arithmeticMean(long[] array) {
        long result = 0;
        for (int i = 0; i < times; i++) {
            result += array[i];
        }
        result /= times;
        return result;
    }

    public String testMyList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            myLinkedList.add(newElement);
            javaLinkedList.add(newElement);
        }
        long startTime;
        long[] myInsertTime = new long[times];
        long[] javaInsertTime = new long[times];
        long[] myRemoveTime = new long[times];
        long[] javaRemoveTime = new long[times];
        long[] myAddTime = new long[times];
        long[] javaAddTime = new long[times];
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            javaLinkedList.add(newElement);
            javaAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            myLinkedList.add(newElement);
            myAddTime[i] = System.nanoTime() - startTime;

            //-----Insert-----
            newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            javaLinkedList.add(size / 2, newElement);
            javaInsertTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            myLinkedList.add(size / 2, newElement);
            myInsertTime[i] = System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            javaLinkedList.remove(size / 2);
            javaRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            myLinkedList.remove(size / 2);
            myRemoveTime[i] = System.nanoTime() - startTime;

        }

        return "\nJavaLinkedList:\nAdd: " + arithmeticMean(javaAddTime) + "\nInsert: " + arithmeticMean(javaInsertTime) + "\nRemove: " + arithmeticMean(javaRemoveTime)
                + "\n\nMyLinkedList:\nAdd: " + arithmeticMean(myAddTime) + "\nInsert: " + arithmeticMean(myInsertTime) + "\nRemove: " + arithmeticMean(myRemoveTime);
    }

    public String testList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            linkedList.add(newElement);
            arrayList.add(newElement);
        }
        long startTime;
        long[] lAddTime = new long[times];
        long[] aAddTime = new long[times];
        long[] lInsertTime = new long[times];
        long[] aInsertTime = new long[times];
        long[] lRemoveTime = new long[times];
        long[] aRemoveTime = new long[times];
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            linkedList.add(newElement);
            lAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            arrayList.add(newElement);
            aAddTime[i] = System.nanoTime() - startTime;

            //-----Insert-----
            newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            linkedList.add(size / 2, newElement);
            lInsertTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            arrayList.add(size / 2, newElement);
            aInsertTime[i] = System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            linkedList.remove(size / 2);
            lRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            arrayList.remove(size / 2);
            aRemoveTime[i] = System.nanoTime() - startTime;
        }

        return "\nLinkedList:\nAdd: " + arithmeticMean(lAddTime) + "\nInsert: " + arithmeticMean(lInsertTime) + "\nRemove: " + arithmeticMean(lRemoveTime) +
                "\n\nArrayList:\nAdd: "+ arithmeticMean(aAddTime) + "\nInsert: " + arithmeticMean(aInsertTime) + "\nRemove: " + arithmeticMean(aRemoveTime);
    }

    public String testSet() {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer toRemove = 0;
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            hashSet.add(newElement);
            linkedHashSet.add(newElement);
            treeSet.add(newElement);
            if (i == size / 2) toRemove = newElement;
        }
        long startTime;
        long[] hAddTime = new long[times];
        long[] lAddTime = new long[times];
        long[] tAddTime = new long[times];
        long[] hRemoveTime = new long[times];
        long[] lRemoveTime = new long[times];
        long[] tRemoveTime = new long[times];
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            hashSet.add(newElement);
            hAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            linkedHashSet.add(newElement);
            lAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            treeSet.add(newElement);
            tAddTime[i] = System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            hashSet.remove(toRemove);
            hRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            linkedHashSet.remove(toRemove);
            lRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            treeSet.remove(toRemove);
            tRemoveTime[i] = System.nanoTime() - startTime;
        }

        return "\nHashSet:\nAdd: " + arithmeticMean(hAddTime) + "\nRemove: " + arithmeticMean(hRemoveTime) +
                "\n\nLinkedHashSet:\nAdd: " + arithmeticMean(lAddTime) + "\nRemove: " + arithmeticMean(lRemoveTime) +
                "\n\nTreeSet:\nAdd: " + arithmeticMean(tAddTime) + "\nRemove: " + arithmeticMean(tRemoveTime);
    }

    public String testMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Integer toRemove = 0;
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            hashMap.put(i, newElement);
            linkedHashMap.put(i, newElement);
            treeMap.put(i, newElement);
            if (i == size / 2) toRemove = newElement;
        }
        long startTime;
        long[] hAddTime = new long[times];
        long[] lAddTime = new long[times];
        long[] tAddTime = new long[times];
        long[] hRemoveTime = new long[times];
        long[] lRemoveTime = new long[times];
        long[] tRemoveTime = new long[times];
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            hashMap.put(size + i, newElement);
            hAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            linkedHashMap.put(size + i, newElement);
            lAddTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            treeMap.put(size + i, newElement);
            tAddTime[i] = System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            hashMap.remove(size/2 + i);
            hRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            linkedHashMap.remove(size/2 + i);
            lRemoveTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            treeMap.remove(size/2 + i);
            tRemoveTime[i] = System.nanoTime() - startTime;
        }

        return "\nHashMap:\nAdd: " + arithmeticMean(hAddTime) + "\nRemove: " + arithmeticMean(hRemoveTime) +
                "\n\nLinkedHashMap:\nAdd: " + arithmeticMean(lAddTime) + "\nRemove: " + arithmeticMean(lRemoveTime) +
                "\n\nTreeMap:\nAdd: " + arithmeticMean(tAddTime) + "\nRemove: " + arithmeticMean(tRemoveTime);
    }
}
