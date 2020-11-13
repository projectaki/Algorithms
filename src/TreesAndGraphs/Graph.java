package TreesAndGraphs;

public class Graph {

    protected static class Node {
        String name;
        Node[] adjacent = new Node[10];
        boolean visited;

        public Node(String n) {
            name = n;
        }
    }

    public Node[] nodes = new Node[10];

}
