package com.dsa.stack;

import java.util.Stack;

public class BracketComparison {

    public static void main(String[] args) {
        BracketComparison bcomp = new BracketComparison();
        System.out.println(bcomp.solve("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
    }

    public int solve(String A, String B) {

        String s1 = evaluate(A);
        System.out.println(s1);
        String s2 = evaluate(B);
        System.out.println(s2);

        return s1.equals(s2)?1:0;
    }

    public String evaluate (String A) {

        Stack<Boolean> st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<A.length(); i++) {
            if (i !=0 && A.charAt(i) == '(') {
                boolean b = A.charAt(i-1) == '+' ? true : false;

                if (!st.isEmpty()) {
                    if (A.charAt(i-1) == '-') {
                        boolean popEle = st.pop();
                        if (popEle) {
                            st.push(false);
                        } else {
                            st.push(true);
                        }
                    }
                } else if (A.charAt(i-1) == '+') {
                    st.push(true);
                } else {
                    st.push(false);
                }
            }
            else if (A.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else if (Character.isLetter(A.charAt(i))) {
                if (st.isEmpty() || st.peek()) {
                    sb.append(String.valueOf('+'));
                    sb.append(String.valueOf(A.charAt(i)));
                } else {
                    sb.append(String.valueOf('-'));
                    sb.append(String.valueOf(A.charAt(i)));
                }
            }
        }

        String res = sb.toString();
        if (res.startsWith("+")) {
            res = res.substring(1);
        }

        return res;

    }
}
