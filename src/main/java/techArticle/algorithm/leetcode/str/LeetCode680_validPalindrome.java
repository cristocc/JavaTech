package techArticle.algorithm.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode680_validPalindrome {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return validPalindrome(s,left + 1,right) || validPalindrome(s,left ,right - 1);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s,int low,int high) {
        for(int i = low,j = high;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

}



