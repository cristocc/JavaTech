package techArticle.algorithm.leetcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author cc
 */
public class LeetCode76_minWindow1 {
   static String minWindow(String s, String t) {
        int[] need = new int[25];
        int[] window  = new int[25];
        for(int i=0;i<t.length();i++){
            int b = t.charAt(i)-'a';
            need[b] ++;
        }
        int left = 0, right = 0,valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need[c - 'a'] > 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a'])
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (valid == t.length()) { //需要判断 need[i] == window[i]
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need[d - 'a'] > 0) {
                    if (window[d - 'a'] == need[d - 'a'])
                        valid--;
                    window[d - 'a']--;
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("adobecodebanc","abc"));

    }
}
