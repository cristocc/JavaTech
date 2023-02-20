package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 * https://leetcode.cn/problems/subdomain-visit-count/
 * @author cc
 */
public class LeetCode811_subdomainVisits {

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String ,Integer> map = new HashMap<>();
        for(String s:cpdomains){
            String [] cpinfo = s.split("\\s+");
            String [] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String key: map.keySet()){
            ans.add("" + map.get(key) + " " + key);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"9001 discuss.leetcode.com"};
        subdomainVisits(s);
    }

}



