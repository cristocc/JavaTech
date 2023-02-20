package techArticle.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Created by crist on 2021/4/30
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * @author cc
 */
public class LeetCode_getLeastNumbers {

// 1,2,2,3,4
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOf(arr,k);

        }

}
