package techArticle.algorithm.leetcode.slidewindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author cc
 */
public class LeetCode567_checkInclusion {
    // 判断 s 中是否存在 t 的排列
    static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            char c = s2.charAt(i);
            char d = s2.charAt(i - n);
            ++cnt2[c- 'a'];
            --cnt2[d- 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion("ab","eidba");
    }

    public boolean checkInclusion1(String t, String s) {
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
                if (Arrays.equals(need, window))
                    return true;
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need[d - 'a'] > 0) {
                    window[d - 'a']--;
                }
            }
        }
        return false;
    }
}
