package TreesAndGraphs;

public class Graph {

    protected static class Node {
        String name;
        Node[] adjacent = new Node[10];
        boolean visited;
    }

    public Node[] nodes = new Node[10];

}
