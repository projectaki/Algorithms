package TreesAndGraphs;
import java.util.*;

/**
 * Implementation of Build order
 */
public class BuildOrder {

    /**
     * Node of the graph, implements comparable on the priority field (Number of dependencies)
     */
    private static class GraphNode implements Comparable<GraphNode>{
        private String name;
        private final ArrayList<GraphNode> children = new ArrayList<>();
        private boolean visited;
        private int dependencies;

        public GraphNode() {

        }

        public GraphNode(String n) {
            this.name = n;
        }

        /**
         * compareTo method for comparing GraphNode objects for sorting
         * @param that Compare this with that
         * @return Returns the comparison
         */
        public int compareTo(GraphNode that) {
            if (this.dependencies > that.dependencies) return 1;
            else if (this.dependencies < that.dependencies) return -1;
            else return 0;
        }
    }

    /**
     * Object for pair of dependencies
     */
    private static class Dependencies {
        GraphNode first;
        GraphNode second;

        public Dependencies() {

        }

        public Dependencies(GraphNode first, GraphNode second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Creates a directed graph from the list of dependencies given
     * @param depArray Given list of dependencies
     * @return Returns the roots of the graph (Nodes with 0 dependencies) (this is where the build order will start)
     */
    public static ArrayList<GraphNode> setUpGraph(LinkedList<Dependencies> depArray) {
        HashMap<String, GraphNode> roots = new HashMap<>();
        HashMap<String, GraphNode> cantBeRoot = new HashMap<>();

        for (Dependencies x : depArray) {
            cantBeRoot.put(x.second.name, x.second);
            if(!cantBeRoot.containsKey(x.first.name)) roots.put(x.first.name, x.first);
            x.first.children.add(x.second);
            x.second.dependencies += 1;
        }

        ArrayList<GraphNode> toReturn = new ArrayList<>();
        for (GraphNode x : roots.values()) {
            toReturn.add(x);
        }
        return toReturn;
    }

//    public static LinkedList<String> BFSOnGraphRoot(GraphNode root) {
//        LinkedList<String> buildOrder = new LinkedList<>();
//        Queue<GraphNode> queue = new LinkedList<>();
//        root.visited = false;
//        queue.add(root);
//
//        while(!queue.isEmpty()) {
//            GraphNode x = queue.poll();
//            if(!x.visited) {
//                buildOrder.add(x.name);
//                x.visited = true;
//            }
//            for (GraphNode z : x.children) {
//                queue.add(z);
//            }
//
//        }
//        return buildOrder;
//    }

    /**
     * Method for creating the build order, given the starting roots of the directed graph
     * @param roots List of starting roots
     * @return Returns the list of build order
     */
    public static LinkedList<String> getPriority(ArrayList<GraphNode> roots) {
        LinkedList<String> buildOrder = new LinkedList<>();
        HashMap<String, GraphNode> childrenToAdd;
        PriorityQueue<GraphNode> minPQ = new PriorityQueue<> ();
        for (GraphNode x : roots) {
            if (!x.visited) minPQ.add(x); x.visited = true;
        }
        do {
            childrenToAdd = new HashMap<>();
            while (!minPQ.isEmpty()) {
                GraphNode min = minPQ.poll();
                if (min.dependencies != 0) throw new NoSuchElementException("BUILD ERROR");
                buildOrder.add(min.name);
                for (GraphNode children : min.children) {
                    children.dependencies -= 1;
                    childrenToAdd.put(children.name, children);
                }
            }
            for (GraphNode elems : childrenToAdd.values()) {
                if (!elems.visited) minPQ.add(elems); elems.visited = true;
            }
        } while (childrenToAdd.size() != 0);
        return buildOrder;
    }

    public static LinkedList<String> getBuildOrder(LinkedList<Dependencies> depArray) {
        ArrayList<GraphNode> roots = setUpGraph(depArray);
        return getPriority(roots);
    }


    public static void main(String[] args) {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");
        Dependencies one = new Dependencies(a,d);
        Dependencies two = new Dependencies(f,b);
        Dependencies three = new Dependencies(b,d);
        Dependencies four = new Dependencies(f,a);
        Dependencies five = new Dependencies(d,c);
        Dependencies six = new Dependencies(a,b);
        Dependencies seven = new Dependencies(e,a);
        Dependencies eight = new Dependencies(f,e);
        Dependencies nine = new Dependencies(e,f);

        LinkedList<Dependencies> listOfDeps = new LinkedList<>();
        listOfDeps.add(one);
        listOfDeps.add(two);
        listOfDeps.add(three);
        listOfDeps.add(four);
        listOfDeps.add(five);
        listOfDeps.add(six);
        listOfDeps.add(seven);
        listOfDeps.add(eight);
        listOfDeps.add(nine);
        System.out.println(getBuildOrder(listOfDeps));
    }







}
