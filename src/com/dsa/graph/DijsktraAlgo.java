package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
*  Dijsktras's Algo helps us find the shortest path in graph
* NOTE : It doesn't work for -ve weights
*
* */

class Edge {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;

    }
}

public class DijsktraAlgo {

    public int[] solve(int A, int[][] B, int C) {

        List<List<Edge>> adjList = getAdjList(A, B);

        int[] dir = new int[A];
        Arrays.fill(dir, Integer.MAX_VALUE);
        dir[C] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            if (a.weight < b.weight) {
                return -1;
            } else if (a.weight > b.weight) {
                return 1;
            } else {
                if (a.node < b.node) {
                    return -1;
                } else if (a.node > b.node) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        pq.offer(new Edge(C, 0));

        while (!pq.isEmpty()) {

            Edge edge = pq.poll();

            for (Edge e : adjList.get(edge.node)) {
                int total = edge.weight + e.weight;
                if (total < dir[e.node]) {
                    dir[e.node] = total;
                    pq.offer(new Edge(e.node, total));
                }

            }

        }

        for (int i=0; i<dir.length; i++) {
            if (dir[i] == Integer.MAX_VALUE) {
                dir[i] = -1;
            }
        }

        return dir;

    }

    public List<List<Edge>> getAdjList(int A, int[][] B) {

        List<List<Edge>> adjList = new ArrayList<>();

        for (int i=0; i<A; i++) {
            adjList.add(new ArrayList<Edge>());
        }

        for (int[] arr : B) {
            adjList.get(arr[0]).add(new Edge(arr[1], arr[2]));
            adjList.get(arr[1]).add(new Edge(arr[0], arr[2]));
        }

        return adjList;

    }

    public static void main(String[] args) {

        DijsktraAlgo dijsktraAlgo = new DijsktraAlgo();
        int[] res = dijsktraAlgo.solve(6, new int[][]{{0,4,9},{3,4,6},{1,2,1},
                {2,5,1},{2,4,5},{0,3,7},{0,1,1},{4,5,7},{0,5,1}}, 4);
        System.out.println(Arrays.toString(res));

    }
}
