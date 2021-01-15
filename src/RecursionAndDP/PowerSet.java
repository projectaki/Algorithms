package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author akos madarasz
 * @date 10/01/2021 - 12:45
 * @project Algorithms
 */
public class PowerSet {

    public static HashSet<ArrayList<Integer>> powerSet(ArrayList<Integer> set) {
        HashSet<ArrayList<Integer>> powerSet = new HashSet<>();
        powerSet(set, powerSet);
        ArrayList<Integer> emptySet = new ArrayList<>();
        powerSet.add(emptySet);
        return powerSet;
    }

    public static void powerSet(ArrayList<Integer> subSet, HashSet<ArrayList<Integer>> powerSet) {
        if (subSet.size() == 0) return;
        if (powerSet.contains(subSet)) return;

        ArrayList<ArrayList<Integer>> oneLessSubsets = getPrevLevelSubSets(subSet);
        for (ArrayList<Integer> x : oneLessSubsets) {
            powerSet(x, powerSet);
        }
        powerSet.add(subSet);
    }

    public static ArrayList<ArrayList<Integer>> getPrevLevelSubSets(ArrayList<Integer> subSet) {
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();
        for (int i = 0; i < subSet.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < subSet.size(); j++) {
                if (j != i) temp.add(subSet.get(j));
            }
            subSets.add(temp);
        }
        return subSets;
    }


    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.print(powerSet(set));



    }
}
