package techArticle.algorithm.leetcode.middle.string;

import java.util.*;

/**
 * Created by crist on 2022/7/18
 *
 * @author cc
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0,j = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
