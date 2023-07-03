package com.dsa.graph;

import java.util.*;

/*Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of
size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].
 Find whether a path exists from node 1 to node A.
Return 1 if path exists else return 0. */

public class PathExists {

    public static void main(String[] args) {

        PathExists pathExists = new PathExists();
       // int[][] input = {{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}};
        int[][] input = {{1,2},{2,3},{3,4},{4,5}};

        int ans = pathExists.solve(5, input);
        System.out.println("Output is :: " + ans);

    }

    public int solve(int A, int[][] B) {

        List<List<Integer>> adj = findAdjacencyList(B);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int[] visitedArr = new int[adj.size()+1];
        Arrays.fill(visitedArr, 0);
        visitedArr[0] = 1;
        visitedArr[1] = 1;

        while (!q.isEmpty()) {
           int polledElement = q.poll();
           if (polledElement == A) {
               return 1;
           }

           List<Integer> adjList = adj.get(polledElement);

           for(int element : adjList) {
               if (visitedArr[element] != 1) {
                   q.offer(element);
                   visitedArr[element] = 1;
               }
           }

        }

        return 0;
    }

    public List<List<Integer>> findAdjacencyList (int[][] edges) {

        int size = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<=size; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;

    }
}
