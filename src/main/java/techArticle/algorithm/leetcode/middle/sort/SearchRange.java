package techArticle.algorithm.leetcode.middle.sort;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class SearchRange {

    public int findPeakElement(int[] nums) {
        int ans = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                ans = i + 1;
            }else if(nums[i+1] < nums[i]){
                ans= i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange test = new SearchRange();
        int[] nums = {1,2,3};
        test.findPeakElement(nums);
    }

}
