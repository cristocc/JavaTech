package techArticle.algorithm.leetcode.str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/minimum-window-substring/
 * @author cc
 */
public class LeetCode917_reverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end){
            while (start <s.length() -1 && (chars[start] < 65 || (chars[start]>= 91 && chars[start]<97))){
                start ++;
            }
            while (end>=0 && (chars[end] < 65 || (chars[end]>= 91 && chars[end]<97)) ){
                end --;
            }
            if(start > end){
                break;
            }
            swap(chars,start,end);
            start++;
            end--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars,int start,int end){
        char temp = chars[end];
        chars[end] = chars[start];
        chars[start] = temp;
    }

    public static void main(String[] args) {
        String s= "?6C40E";
        //"?6C40E"
        //"?6E40C"
        System.out.println(reverseOnlyLetters(s));
    }

}



