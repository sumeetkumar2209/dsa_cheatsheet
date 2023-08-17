package com.dsa.dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleIn2DArray {

    public static void main(String[] args) {
        MaxRectangleIn2DArray obj = new MaxRectangleIn2DArray();
        int[][] input = {{0,1,1},{1,0,0},{1,0,0},{1,0,0},{1,0,0},{1,1,1},{0,1,0}} ;
        System.out.println(obj.solve(input));
    }

    public int solve(int[][] A) {

        int ans = Integer.MIN_VALUE;

        int[] input = new int[A[0].length];

        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j] != 0) {
                    input[j] = input[j] + A[i][j];
                } else {
                    input[j] = 0;
                }
            }
            ans = Math.max(ans, maxRect(input));
        }

        return ans;
    }

    public int maxRect (int[] A) {

        int[] next = nextSmallest(A);
        int[] prev = prevSmallest(A);

        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(prev));

        int maxArea = Integer.MIN_VALUE;

        for (int i=0; i<A.length; i++) {

            maxArea = Math.max(maxArea, (A[i] * (next[i] - prev[i] - 1)));

        }

        return maxArea;

    }

    public int[] nextSmallest (int[] A) {
        int[] res = new int[A.length];

        Stack<Integer> s = new Stack<>();

        for (int i=A.length-1; i>=0; i--) {
            while (!s.isEmpty() && A[s.peek()] >= A[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                res[i] = s.peek();
            } else {
                res[i] = A.length;
            }
            s.push(i);
        }

        return res;
    }

    public int[] prevSmallest (int[] A) {
        int[] res = new int[A.length];

        Stack<Integer> s = new Stack<>();

        for (int i=0; i<A.length; i++) {
            while (!s.isEmpty() && A[s.peek()] >= A[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                res[i] = s.peek();
            } else {
                res[i] = -1;
            }
            s.push(i);
        }

        return res;
    }
}
