package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 * https://leetcode.cn/problems/most-common-word/
 * @author cc
 */
public class LeetCode819_mostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase();
        String[] paragraphs = paragraph.split("\\s+");
        for(String s:paragraphs){
            int len = s.length();
            char last = s.charAt(len - 1);
            if(last - 'a' < 0){
                s = s.substring(0,len - 1);
            }
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        int max = 0;
        String ans = "";
        for(String key:map.keySet()){
            if(!set.contains(key)){
                int count = map.get(key);
                if(count >= max){
                    max = count;
                    ans = key;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String paragraph = "a, a, a, a, b,b,b,c, c";
        String [] ban = {"a"};
        mostCommonWord(paragraph,ban);

    }
}



