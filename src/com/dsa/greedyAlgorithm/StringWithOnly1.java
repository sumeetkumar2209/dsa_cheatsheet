package com.dsa.greedyAlgorithm;

public class StringWithOnly1 {

    public int solve(String A, int B) {

        char[] ch = A.toCharArray();

        int ans = 0;

        for (int i=0; i<ch.length-B+1; i++) {

            if (ch[i] == '0') {

                ans++;
                for (int j=i; j<=i+B-1; j++) {
                    ch[j] = flip(ch[j]);
                }

            }

        }

        return ans;

    }

    public char flip (char c) {
        int x = c - '0';
        x = x^1;

        return (char)(x+'0');
    }

    public static void main(String[] args) {
        StringWithOnly1 obj = new StringWithOnly1();
        System.out.println(obj.solve("00010110", 3));
    }
}
