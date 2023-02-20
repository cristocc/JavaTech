package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode258_addDigits {

    public static int addDigits(int num) {
        while (num >= 10){
            int sum = 0;
            while (num >0){
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }



    public static void main(String[] args) {
    }
}
