package Pathfinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author akos madarasz
 * @date 25/12/2020 - 11:43
 * @project Algorithms
 */
public class Pathfinding {

    /**
     * Node class
     */
    private static class Node {
        Node prev = null;
        int i;
        int j;
    }

    /**
     * BFS pathfinding algorithm
     * @param grid Grid of Nodes
     * @param start start coordinates
     * @param end end coordinates
     * @return returns the Node which is found
     */
    public static Node BFS(Node[][] grid, int[][] start, int[][] end) {
        int startX = start[0][0];
        int startY = start[0][1];
        int endX = end[0][0];
        int endY = end[0][1];
        int[][] startCoords = new int[1][2];
        startCoords[0][0] = startX; startCoords[0][1] = startY;

        int[][] endCoords = new int[1][2];
        endCoords[0][0] = endX; endCoords[0][1] = endY;



        Queue<int[][]> nodesToProcess = new LinkedList<>();
        nodesToProcess.add(startCoords);
        grid[startX][ startY] = new Node();
        grid[startX][ startY].i = startX;
        grid[startX][ startY].j = startY;

        int[][] currentCoords = new int[1][2];
        while (!(currentCoords[0][0] == endCoords[0][0] && currentCoords[0][1] == endCoords[0][1])) {
            currentCoords = nodesToProcess.poll();
            ArrayList<int[][]> neighbours;
            neighbours = getNeighbours(currentCoords, grid);
            for (int[][] x : neighbours) {
                nodesToProcess.add(x);
            }

        }
        return grid[currentCoords[0][0]][currentCoords[0][1]];
    }

    /**
     * Gets the neighbours of the current Node
     * @param currentNodeCord Current Node coordinates
     * @param grid Grid of nodes
     * @return returns an arraylist of neighbours
     */
    public static ArrayList<int[][]> getNeighbours(int[][] currentNodeCord, Node[][] grid) {

        ArrayList<int[][]> neighbours = new ArrayList<>();
        int i = currentNodeCord[0][0];
        int j = currentNodeCord[0][1];

        // top
        int[][] top = new int[1][2]; top[0][0] = i - 1; top[0][1] = j;
        if (isValid(grid, top[0][0], top[0][1])) {
            neighbours.add(top);
            grid[top[0][0]][top[0][1]] = new Node();
            grid[top[0][0]][top[0][1]].prev = grid[i][j];
            grid[top[0][0]][top[0][1]].i = top[0][0];
            grid[top[0][0]][top[0][1]].j = top[0][1];

        }
        // right
        int[][] right = new int[1][2]; right[0][0] = i; right[0][1] = j + 1;
        if (isValid(grid, right[0][0], right[0][1])) {
            neighbours.add(right);
            grid[right[0][0]][right[0][1]] = new Node();
            grid[right[0][0]][right[0][1]].prev = grid[i][j];
            grid[right[0][0]][right[0][1]].i = right[0][0];
            grid[right[0][0]][right[0][1]].j = right[0][1];
        }
        // bottom
        int[][] bottom = new int[1][2]; bottom[0][0] = i + 1; bottom[0][1] = j;
        if (isValid(grid, bottom[0][0], bottom[0][1])) {
            neighbours.add(bottom);
            grid[bottom[0][0]][bottom[0][1]] = new Node();
            grid[bottom[0][0]][bottom[0][1]].prev = grid[i][j];
            grid[bottom[0][0]][bottom[0][1]].i = bottom[0][0];
            grid[bottom[0][0]][bottom[0][1]].j = bottom[0][1];
        }
        // left
        int[][] left = new int[1][2]; left[0][0] = i; left[0][1] = j - 1;
        if (isValid(grid, left[0][0], left[0][1])) {
            neighbours.add(left);
            grid[left[0][0]][left[0][1]] = new Node();
            grid[left[0][0]][left[0][1]].prev = grid[i][j];
            grid[left[0][0]][left[0][1]].i = left[0][0];
            grid[left[0][0]][left[0][1]].j = left[0][1];
        }
//        // topright
//        int[][] topright = new int[1][2]; topright[0][0] = i + 1; topright[0][1] = j - 1;
//        if (isValid(grid, topright[0][0], topright[0][1])) {
//            neighbours.add(topright);
//            grid[topright[0][0]][topright[0][1]].visited = true;
//            grid[topright[0][0]][topright[0][1]].prev = grid[i][j];
//        }
//        // rightbottom
//        int[][] rightbottom = new int[1][2]; rightbottom[0][0] = i + 1; rightbottom[0][1] = j + 1;
//        if (isValid(grid, rightbottom[0][0], rightbottom[0][1])) {
//            neighbours.add(rightbottom);
//            grid[rightbottom[0][0]][rightbottom[0][1]].visited = true;
//            grid[rightbottom[0][0]][rightbottom[0][1]].prev = grid[i][j];
//        }
//        // bottomleft
//        int[][] bottomleft = new int[1][2]; bottomleft[0][0] = i - 1; bottomleft[0][1] = j + 1;
//        if (isValid(grid, bottomleft[0][0], bottomleft[0][1])) {
//            neighbours.add(bottomleft);
//            grid[bottomleft[0][0]][bottomleft[0][1]].visited = true;
//            grid[bottomleft[0][0]][bottomleft[0][1]].prev = grid[i][j];
//        }
//        // lefttop
//        int[][] lefttop = new int[1][2]; lefttop[0][0] = i - 1; lefttop[0][1] = j - 1;
//        if (isValid(grid, lefttop[0][0], lefttop[0][1])) {
//            neighbours.add(lefttop);
//            grid[lefttop[0][0]][lefttop[0][1]].visited = true;
//            grid[lefttop[0][0]][lefttop[0][1]].prev = grid[i][j];
//        }

        return neighbours;
    }

    /**
     * Validates if a coordinate is valid
     * @param grid Grid of nodes
     * @param x x coord
     * @param y y coord
     * @return returns true if it is valid
     */
    public static boolean isValid(Node[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length ) return false;
        if (y < 0 || y >= grid[0].length ) return false;
        if (grid[x][y] != null) return false;
        return true;
    }

    public static void main(String[] args) {

        Node[][] grid = new Node[5][6];
        grid[1][2] = new Node();
        int[][] start = new int[1][2]; start[0][0] = 3; start[0][1] = 1;
        int[][] end = new int[1][2]; end[0][0] = 1; end[0][1] = 4;

        Node endNode = BFS(grid, start, end);

        while (endNode != null) {
            System.out.print(endNode.i  + ", " + endNode.j + "  -->  ");
            endNode = endNode.prev;
        }


    }
}
