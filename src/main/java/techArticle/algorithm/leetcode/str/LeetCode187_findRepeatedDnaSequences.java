package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode187_findRepeatedDnaSequences {



    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        int length = s.length();
        int size = 10;
        for(int i=0;i<length;i++){
            int end = i + size;
            if(end <= length){
               String temp = s.substring(i,end);
               if(map.containsKey(temp)){
                   map.put(temp,map.get(temp) + 1);
               }else{
                   map.put(temp,1);
               }
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if(map.get(key) > 1){
                result.add(key);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        LeetCode187_findRepeatedDnaSequences test = new LeetCode187_findRepeatedDnaSequences();
        String a = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        test.findRepeatedDnaSequences(a);
    }

}



