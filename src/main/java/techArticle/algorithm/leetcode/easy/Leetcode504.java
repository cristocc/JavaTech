package techArticle.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/12/29
 *https://leetcode-cn.com/problems/base-7/
 * @author cc
 */
public class Leetcode504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder digits = new StringBuilder();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();

    }

}
