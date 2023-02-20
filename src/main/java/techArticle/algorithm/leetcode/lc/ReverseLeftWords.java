package techArticle.algorithm.leetcode.lc;

import java.util.Stack;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class ReverseLeftWords {

/*    输入: s = "abcdefg", k = 2
    输出: "cdefgab"*/

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        if(n > len){
           n = (n % len);
        }
        StringBuilder ans = new StringBuilder();
        for(int i = n;i<len;i++){
            ans.append(s.charAt(i));
        }
        for(int i = 0;i<n;i++){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ReverseLeftWords t = new ReverseLeftWords();
        t.reverseLeftWords("abcdefg",2);
        t.reverseLeftWords("abcdefg",9);
        t.reverseLeftWords("abcdefg",16);
    }
}
