package techArticle.algorithm;

/**
 * Created by crist on 2022/6/23
 *
 * @author cc
 */
public class Test191 {

    public int hammingWeight(int n) {
        int res = 0;
        for(int i=31;i>=0;i--){
            if(((n >> i) & 1) == 1){
                res ++;
            }
        }
        return res;
    }


    public boolean isPowerOfTwo(int n) {
        int res = 0;
        for(int i=31;i>=0;i--){
            if(((n >> i) & 1) == 1){
                res ++;
            }
        }
        return res == 1;
    }

    int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }
        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;

        return new int[]{dup, missing};
    }


    public static void main(String[] args) {
        Test191 test = new Test191();
        int [] nums = {1,2,2,4};
        test.findErrorNums(nums);
    }
}
