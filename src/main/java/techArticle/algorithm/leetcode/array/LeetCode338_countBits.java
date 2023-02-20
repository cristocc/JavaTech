package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/31
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author cc
 */
public class LeetCode338_countBits {

    public static int[] countBits(int n) {
        int [] ans = new int[n+1];
        for(int i=1;i<=n;i++){
            int bit1 = 0;
            for(int j=31;j>=0;j--){
                if((i & (1<<j))==1){
                    bit1++;
                }
            }
            ans[i] = bit1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        //countBits(2);
        for(int j=31;j>=0;j--){
            System.out.print((n & (1<<j) ) == 0?"0":"1");

        }
    }

}
