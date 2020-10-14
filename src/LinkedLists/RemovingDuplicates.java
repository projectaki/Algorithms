package LinkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

// Removing duplicates from unordered linked list
public class RemovingDuplicates<T> {
    private LinkedList<T> unorderedList;
    HashMap<T,Integer> tracker;

    public RemovingDuplicates() {
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

    public void removeDupsWithoutBuffer(LinkedList<T> list) {
        Iterator<T> iter = list.iterator();
        int countDown = list.size();
        while (iter.hasNext()) {
            T temp = iter.next();
            for (int i = (list.size()-countDown); i < list.size() ;i++ ) {
                if (temp.equals(list.get(i))) iter.remove();
            }
            countDown--;
        }
    }

    public static void main(String[] args) {
        RemovingDuplicates<String> r = new RemovingDuplicates<>();
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
