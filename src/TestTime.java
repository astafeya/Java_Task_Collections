import java.util.*;

public class TestTime {
    int size = 10000;
    int times = 10;

    public TestTime(int size, int times) {
        this.size = size;
        this.times = times;
    }

    public String testList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Integer newElement = (int) Math.round((Math.random() * 100));
            linkedList.add(newElement);
            arrayList.add(newElement);
        }
        double startTime, lAddTime = 0, aAddTime = 0, lInsertTime = 0, aInsertTime = 0,
                lRemoveTime = 0, aRemoveTime = 0;
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            linkedList.add(newElement);
            lAddTime = lAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            arrayList.add(newElement);
            aAddTime = aAddTime + System.nanoTime() - startTime;

            //-----Insert-----
            newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            linkedList.add(size / 2, newElement);
            lInsertTime = lInsertTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            arrayList.add(size / 2, newElement);
            aInsertTime = aInsertTime + System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            linkedList.remove(size / 2);
            lRemoveTime = lRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            arrayList.remove(size / 2);
            aRemoveTime = aRemoveTime + System.nanoTime() - startTime;
        }
        lAddTime /= times;
        aAddTime /= times;
        lInsertTime /= times;
        aInsertTime /= times;
        lRemoveTime /= times;
        aRemoveTime /= times;
        return "\nLinkedList:\nAdd: " + lAddTime + "\nInsert: " + lInsertTime + "\nRemove: " + lRemoveTime +
                "\n\nArrayList:\nAdd "+ aAddTime + "\nInsert: " + aInsertTime + "\nRemove: " + aRemoveTime;
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
        double startTime, hAddTime = 0, lAddTime = 0, tAddTime = 0, hRemoveTime = 0, lRemoveTime = 0, tRemoveTime = 0;
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            hashSet.add(newElement);
            hAddTime = hAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            linkedHashSet.add(newElement);
            lAddTime = lAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            treeSet.add(newElement);
            tAddTime = tAddTime + System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            hashSet.remove(toRemove);
            hRemoveTime = hRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            linkedHashSet.remove(toRemove);
            lRemoveTime = lRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            treeSet.remove(toRemove);
            tRemoveTime = tRemoveTime + System.nanoTime() - startTime;
        }
        hAddTime /= times;
        lAddTime /= times;
        tAddTime /= times;
        hRemoveTime /= times;
        lRemoveTime /= times;
        tRemoveTime /= times;
        return "\nHashSet:\nAdd: " + hAddTime + "\nRemove: " + hRemoveTime +
                "\n\nLinkedHashSet:\nAdd " + lAddTime + "\nRemove: " + lRemoveTime +
                "\n\nTreeSet:\nAdd " + tAddTime + "\nRemove: " + tRemoveTime;
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
        double startTime, hAddTime = 0, lAddTime = 0, tAddTime = 0, hRemoveTime = 0, lRemoveTime = 0, tRemoveTime = 0;
        for (int i = 0; i < times; i++) {
            //-----Add-----
            Integer newElement = (int) Math.round((Math.random() * 100));
            startTime = System.nanoTime();
            hashMap.put(size + i, newElement);
            hAddTime = hAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            linkedHashMap.put(size + i, newElement);
            lAddTime = lAddTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            treeMap.put(size + i, newElement);
            tAddTime = tAddTime + System.nanoTime() - startTime;

            //-----Remove-----
            startTime = System.nanoTime();
            hashMap.remove(size/2);
            hRemoveTime = hRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            linkedHashMap.remove(size/2);
            lRemoveTime = lRemoveTime + System.nanoTime() - startTime;
            startTime = System.nanoTime();
            treeMap.remove(size/2);
            tRemoveTime = tRemoveTime + System.nanoTime() - startTime;
        }
        hAddTime /= times;
        lAddTime /= times;
        tAddTime /= times;
        hRemoveTime /= times;
        lRemoveTime /= times;
        tRemoveTime /= times;
        return "\nHashMap:\nAdd: " + hAddTime + "\nRemove: " + hRemoveTime +
                "\n\nLinkedHashMap:\nAdd " + lAddTime + "\nRemove: " + lRemoveTime +
                "\n\nTreeMap:\nAdd " + tAddTime + "\nRemove: " + tRemoveTime;
    }
}
