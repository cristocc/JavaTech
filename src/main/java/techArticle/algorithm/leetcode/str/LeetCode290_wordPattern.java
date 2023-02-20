package techArticle.algorithm.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by crist on 2021/4/20
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author cc
 */
public class LeetCode290_wordPattern {

    //abba
    // dog dog dog dog

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] ss = s.split(" ");
        if(ss.length != pattern.length()){
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String temp = map.get(c);
            if(temp == null){
                if(set.contains(ss[i])){
                    return false;
                }
                map.put(c,ss[i]);
                set.add(ss[i]);
            }else{
                if(!temp.equals(ss[i])){
                    return false;
                }
            }
        }
        return true;
    }

}



