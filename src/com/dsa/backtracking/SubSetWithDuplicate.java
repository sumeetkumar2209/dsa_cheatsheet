package com.dsa.backtracking;

import java.util.*;

public class SubSetWithDuplicate {

    List<List<Integer>> ans;

    Set<String> temp;
    public int[][] subsetsWithDup(int[] A) {
        ans = new ArrayList<>();
        temp = new HashSet<>();
        permute(A, 0, new ArrayList<Integer>());


        int[][] res = ans.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return sort_lexicographically(res);

    }

    public void permute (int[] A, int index, List<Integer> curr) {

        if (index == A.length) {

            temp.add(new ArrayList<>(curr).toString());
            return;
        }

        curr.add(A[index]);
        permute(A, index+1, curr);
        curr.remove(curr.size()-1);
        permute(A, index+1, curr);

    }

    public int[][] sort_lexicographically(int[][] res) {

        for (int[] arr : res) {
            Arrays.sort(arr);
        }

        Arrays.sort(res, (a, b) -> {
            int size = Math.min(a.length, b.length);
            for (int i=0; i<size; i++) {
                if (a[i] < b[i]) {
                    return -1;
                } else if (a[i] > b[i]) {
                    return 1;
                }
            }

            if (a.length < b.length) {
                return -1;
            }

            return 1;
        });

        return res;
    }

    public static void main(String[] args) {
        SubSetWithDuplicate sub = new SubSetWithDuplicate();
        sub.subsetsWithDup(new int[]{1,2,2});
    }
}
