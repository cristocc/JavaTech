package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/26
 * https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 * @author cc
 */
public class LeetCode506_findRelativeRanks {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for(int i=left + 1;i<=right;i++){
            ans = ans & i;
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
