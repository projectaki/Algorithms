package LinkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class for removing duplicates using Java s Linked list
 * @param <T>
 */
public class RemovingDuplicatesJavaLinkedList<T> {
    private LinkedList<T> unorderedList;
    HashMap<T,Integer> tracker;

    public RemovingDuplicatesJavaLinkedList() {
        unorderedList = new LinkedList<>();
        tracker = new HashMap<>();
    }


    public void removeDuplicates(LinkedList<T> list, HashSet<T> tracker) {
        Iterator<T> iter = list.iterator();
        while (iter.hasNext()) {
            T temp = iter.next();
            if (tracker.contains(temp)) iter.remove();
            tracker.add(temp);
        }
    }


    public static void main(String[] args) {
        RemovingDuplicatesJavaLinkedList<String> r = new RemovingDuplicatesJavaLinkedList<>();
        LinkedList<String> unorderedList = new LinkedList<>();
        HashSet<String> tracker = new HashSet<>();
        unorderedList.add("a");
        unorderedList.add("a");
        unorderedList.add("b");
        unorderedList.add("c");
        unorderedList.add("a");
        unorderedList.add("a");
        unorderedList.add("c");
        unorderedList.add("a");
        System.out.println(unorderedList);
        //r.removeDuplicates(unorderedList,tracker);
        //r.removeDupsWithoutBuffer(unorderedList);
        System.out.println(unorderedList);
    }










}
