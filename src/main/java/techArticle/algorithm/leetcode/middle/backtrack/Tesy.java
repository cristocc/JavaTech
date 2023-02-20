package techArticle.algorithm.leetcode.middle.backtrack;

import java.util.*;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class Tesy {
    Map<Character, String> map = new HashMap<>();

    public  List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Deque<Character> path = new ArrayDeque<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, ans, path);
        return ans;
    }

    private  void backtrack(String digits, int begin, List<String> ans, Deque<Character> path) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            ans.add(sb.toString());
            return;
        }
        for (int i = begin; i < digits.length(); i++) {
            String s = map.get(digits.charAt(i));
            for (int j = 0; j < s.length(); j++) {
                path.addLast(s.charAt(j));
                backtrack(digits, i + 1, ans, path);
                path.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        Tesy tesy = new Tesy();
        tesy.letterCombinations("23");
    }
}
