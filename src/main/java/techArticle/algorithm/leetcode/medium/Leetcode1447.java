package techArticle.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/simplified-fractions/
public class Leetcode1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
/*
    如何快速判断两个数组成的分数是否为最简（即判断两个数的最大公约数是否为 1）。
    快速求得 aa 和 bb 的最大公约数的主要方式有两种 :「更相减损法」和「欧几里得算法」，其中「欧几里得算法」的递归实现最为好写，复杂度为
    O(\log{(a + b)})O(log(a+b))，在绝大多数的情况下适用，只有在需要实现高精度时，才会考虑使用「更相减损法」。*/


}
