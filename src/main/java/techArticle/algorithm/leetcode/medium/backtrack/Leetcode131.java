package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/restore-ip-addresses/
public class Leetcode131 {

    static List<List<String>> ans = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        List<String> track = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray,track,0);
        return ans;
    }

    private static void dfs(char[] charArray,List<String> track,int index){
        if (index == charArray.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = index; i < charArray.length; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            track.add(new String(charArray, index, i + 1 - index));
            dfs(charArray,track, i + 1);
            track.remove(track.size() - 1);
        }
    }

    private static boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        partition("aab");
    }

}
