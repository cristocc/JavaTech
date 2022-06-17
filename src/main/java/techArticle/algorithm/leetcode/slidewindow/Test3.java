package techArticle.algorithm.leetcode.slidewindow;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author cc
 */
public class Test3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] window = new int[26];
        int left = 0,right = 0;
        int ans = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window[c-'a']++;
            right++;
            while(window[c-'a'] > 1){
                char d = s.charAt(left);
                left++;
                window[d-'a']--;
            }
            ans = Math.max(ans,right - left);
        }
        return ans;
    }

}
