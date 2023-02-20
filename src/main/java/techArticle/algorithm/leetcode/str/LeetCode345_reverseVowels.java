package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode345_reverseVowels {

    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);

    }

    public boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)>= 0;
    }

    public void swap(char[] chars ,int i,int j){
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;

    }

    public static void main(String[] args) {

    }


}



