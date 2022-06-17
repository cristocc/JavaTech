package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/30
 * https://leetcode-cn.com/problems/reverse-string/
 * @author cc
 */
public class LeetCode344_reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right){
            char cr = s[right] ;
            s[right] = s[left];
            s[left] = cr;
            left++;
            right--;

        }
    }

}
