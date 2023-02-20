package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author cc
 */
public class LeetCode435_eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        int n = intvs.length;
        return n-count;
    }
}
