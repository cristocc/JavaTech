package techArticle.algorithm.leetcode.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author cc
 */
public class LeetCode438_findAnagrams {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> res = new ArrayList<>();
        int[] need = new int[26];
        int[] window  = new int[26];
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)-'a'] ++;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need[c - 'a'] > 0) {
                window[c- 'a']++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (Arrays.equals(need, window)){
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need[d - 'a'] > 0) {
                    window[d - 'a']--;
                }
            }
        }
        return res;
    }
}
