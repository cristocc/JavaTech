package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode220_containsNearbyAlmostDuplicate {

/*    给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
    使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
    如果存在则返回 true，不存在返回 false。*/


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3, t = 0;

        LeetCode220_containsNearbyAlmostDuplicate test = new LeetCode220_containsNearbyAlmostDuplicate();
        test.containsNearbyAlmostDuplicate(nums,k,t);
    }
}
