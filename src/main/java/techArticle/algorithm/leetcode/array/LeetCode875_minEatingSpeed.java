package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/19
 * https://leetcode.cn/problems/koko-eating-bananas/
 * @author cc
 */
public class LeetCode875_minEatingSpeed {

    public static int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        minEatingSpeed(piles,8);
    }
}
