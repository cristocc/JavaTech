package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author cc
 */
public class LeetCode253 {

    // 返回需要申请的会议室数量
    int minMeetingRooms(int[][] meetings){
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        // 把左端点和右端点单独拿出来
        for(int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        // 排序后就是图中的红点
        Arrays.sort(begin);
        // 排序后就是图中的绿点
        Arrays.sort(end);
        // 扫描过程中的计数器
        int count = 0;
        // 双指针技巧
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                // 扫描到一个红点
                count++;
                i++;
            } else {
                // 扫描到一个绿点
                count--;
                j++;
            }
            // 记录扫描过程中的最大值
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] meetings  = {{5,30},{5,10},{15,20}};
        LeetCode253 test = new LeetCode253();
        System.out.println(test.minMeetingRooms(meetings));


    }
}
