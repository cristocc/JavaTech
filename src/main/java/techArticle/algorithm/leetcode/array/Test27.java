package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/31
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author cc
 */
public class Test27 {

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
