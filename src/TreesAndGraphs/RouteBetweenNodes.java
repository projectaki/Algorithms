package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    /**
     * BFS Implementation to find if there is a path between 2 Nodes
     * @param root The start Node
     * @param second The node to check path against
     * @return Returns True if there is a path otherwise returns False
     */
    public static boolean isPath(Graph.Node root, Graph.Node second) {
        Queue<Graph.Node> queue = new LinkedList<>();
        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            Graph.Node x = queue.poll();
            if (x == second) return true;
            for (Graph.Node n : x.adjacent) {
                if (n == null) break;
                if (!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
    // Implement a Bidirectional search

    public static void main(String[] args) {
////        // setup test graph
//////        Graph graph = new Graph();
//////        Graph.Node a = new Graph.Node();
//////        Graph.Node b = new Graph.Node();
//////        Graph.Node c = new Graph.Node();
//////        Graph.Node d = new Graph.Node();
//////        Graph.Node e = new Graph.Node();
//////        Graph.Node f = new Graph.Node();
////
////        a.name = "a";
////        a.adjacent[0] = b;
////
////        b.name = "b";
////        b.adjacent[0] = c;
////
////        c.name = "c";
////        c.adjacent[0] = e;
////        c.adjacent[1] = d;
////
////        e.name = "e";
////        d.name = "d";
////        f.name = "f";
////
////        graph.nodes[0] = a;
////        graph.nodes[1] = b;
////        graph.nodes[2] = c;
////        graph.nodes[3] = d;
////        graph.nodes[4] = e;
////        graph.nodes[5] = f;
//
//        // check isPAth
//        System.out.println(isPath(graph.nodes[0], graph.nodes[5]));
    }
}
