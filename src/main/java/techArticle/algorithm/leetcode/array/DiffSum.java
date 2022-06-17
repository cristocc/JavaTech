package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2022/3/30
 *
 * @author cc
 */
public class DiffSum {

    // 差分数组
    private int[] diff ;
    //  i   j
    //8,2,6,3,1
    //8,-6,4,-3,-2

    //diff[i] += 3,
    // diff[j+1] -= 3

    //8,5,9,6,1
    //8,-3,4,-3,-5

    /* 输入一个数组，构造前缀和 */
    public DiffSum(int[] nums) {
        diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 返回结果数组 */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

}
