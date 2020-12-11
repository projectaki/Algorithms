package TreesAndGraphs;

import java.util.*;

/* Topological sort on directed graph, if its acyclic it will return the build order, otherwise it throws a build error
 * @date 11/12/2020 - 09:40
 * @project Algorithms
 * @author akos madarasz
 */
public class TopologicalSort {
    /**
     * Inner class for Graph Nodes
     */
    public static class Node {
        String name;
        ArrayList<Node> adj = new ArrayList<>();
        int state = 0;

        public Node() {}

        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * Inner class for representing Graph
     */
    public static class Graph {
        HashMap<String, Node> nodes = new HashMap<>();

        public Graph() {}

        public Graph(HashMap<String, Node> hs) {
            this.nodes = hs;
        }
    }

    /**
     * Make a Directed graph from the list of given dependencies
     * @param projects List of dependencies, the second project depends on the first one
     * @return Returns the directed graph
     */
    public static Graph makeDirectedGraph(String[][] projects) {
        HashMap<String, Node> hm = new HashMap<>();
        for (String[] project : projects) {
            String first = project[0];
            String second = project[1];
            Node firstNode = new Node(first);
            Node secondNode = new Node(second);

            if (!hm.containsKey(first)) hm.put(first, firstNode);
            if (!hm.containsKey(second)) hm.put(second, secondNode);

            hm.get(first).adj.add(hm.get(second));
        }

        return new Graph(hm);
    }

    /**
     * Topological sort for directed graph, if there is a cycle it throws a build error, otherwise adds a build path to the stack
     * @param x Node in the graph
     * @param buildOrder Buildorder stack
     */
    public static void sort(Node x, Stack<String> buildOrder) {

        if(x == null) throw new NoSuchElementException("Node is null");
        if(x.state == 2) return;
        x.state = 1;
        for (Node node : x.adj) {
            if(node.state == 1) throw new Error("Build Error");
            else if(node.state == 0) sort(node, buildOrder);
        }
        buildOrder.add(x.name);
        x.state = 2;
    }

    /**
     * Loop through the graph nodes, and call sort on them
     * @param projects List of dependencies
     * @return Returns the build order stack
     */
    public static Stack<String> topSortGraph(String[][] projects) {
        Graph graph = makeDirectedGraph(projects);
        Stack<String> buildOrder = new Stack<>();
        for(Node x : graph.nodes.values()) {
            sort(x, buildOrder);
        }
        return buildOrder;
    }

    public static void main(String[] args) {

        String[][] projects = new String[8][2];

        projects[0][0] = "a";
        projects[0][1] = "b";
        projects[1][0] = "b";
        projects[1][1] = "c";
        projects[2][0] = "b";
        projects[2][1] = "d";
        projects[3][0] = "a";
        projects[3][1] = "e";
        projects[4][0] = "e";
        projects[4][1] = "f";
        projects[5][0] = "f";
        projects[5][1] = "b";
        projects[6][0] = "f";
        projects[6][1] = "g";
        projects[7][0] = "b";
        projects[7][1] = "a";

        System.out.print(topSortGraph(projects));

    }
}
