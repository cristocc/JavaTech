package techArticle.algorithm.leetcode.middle.sort;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right){
            if(nums[index] == 0){
                swap(nums,left++,index++);
            }else if(nums[index] == 1){
                index++;
            }else {
                swap(nums,right--,index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
