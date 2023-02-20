package techArticle.algorithm.leetcode.middle.backtrack;

import io.netty.handler.timeout.ReadTimeoutException;

import java.util.*;

/**
 * Created by crist on 2022/7/18
 *
 * @author cc
 */
public class Subsets {

    List<String> ans = new ArrayList<>();
    Deque<Character> track = new ArrayDeque<>();
    Map<Character,String> map = new HashMap<>();

    // 23
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if("".equals(digits)){
            return ans;
        }
        char[] cs = digits.toCharArray();
        dfs(cs,0);
        return ans;

    }

    public void dfs(char[] cs,int start){
        if(cs.length == track.size()){
            StringBuilder sb = new StringBuilder();
            for (Character character : track) {
                sb.append(character);
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < cs.length; i++) {
            String val = map.get(cs[i]);
            int len = val.length();
            for (int j = 0; j < len; j++) {
                track.addLast(val.charAt(j));
                dfs(cs,i +1);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        test.letterCombinations("23");
    }

}
