package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode451_frequencySort {

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "tree";
        frequencySort(s);

    }


}



