package com.dsa.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneLetter {

    Map<Character, String> map;
    List<String> res;

    public String[] letterCombinations(String A) {

        map = new HashMap<>();
        map.put('0',"0");
        map.put('1',"1");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        res = new ArrayList<>();

        permute(A, 0, new ArrayList<Character>());

        return res.stream().toArray(String[]::new);

    }

    public void permute(String A, int index, List<Character> currList) {

        if (A.length() == currList.size()) {

            String s = currList.stream().map(String::valueOf).collect(Collectors.joining());
            res.add(s);
            return;
        }

        for (char ch : map.get(A.charAt(index)).toCharArray()) {
            currList.add(ch);
            permute(A, index+1, currList);
            currList.remove(currList.size()-1);

        }

    }

    public static void main(String[] args) {
        PhoneLetter phoneLetter = new PhoneLetter();
        String[] res = phoneLetter.letterCombinations("23");
        System.out.println(Arrays.toString(res));
    }
}
