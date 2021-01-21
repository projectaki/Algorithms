package RecursionAndDP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author akos madarasz
 * @date 21/01/2021 - 11:06
 * @project Algorithms
 */
public class StackBoxes {

    private static class Box implements Comparable<Box> {
        private int height;
        private int width;
        private int length;

        public Box() {}

        public Box(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }
        public int compareTo(Box that) {
            return Integer.compare(this.height, that.height);
        }
    }

    public static int stackBoxes(ArrayList<Box> boxes) {
        Collections.sort(boxes);
        Box b = new Box(0,0,0);
        return stackBoxes(boxes, 0, b);
    }

    public static int stackBoxes(ArrayList<Box> boxes, int startIndex, Box prev) {
        int boxHeight = prev.height;
        int max = 0;
        for (int i = startIndex; i < boxes.size(); i++) {

            if(canStack(prev, boxes.get(i))) {
                int height = stackBoxes(boxes, i + 1, boxes.get(i));
                max = Math.max(max, height);
            }
        }
        return boxHeight + max;
    }

    public static boolean canStack(Box smaller, Box bigger) {
        return bigger.height > smaller.height && bigger.width > smaller.width && bigger.length > smaller.length;
    }

    public static void main(String[] args) {
        Box box1 = new Box(5,5,5);
        Box box2 = new Box(4,5,5);
        Box box3 = new Box(3,3,3);
        Box box4 = new Box(10,10,2);
        Box box5 = new Box(9,9,6);

        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);
        boxes.add(box5);

        System.out.println(stackBoxes(boxes));
    }

}
