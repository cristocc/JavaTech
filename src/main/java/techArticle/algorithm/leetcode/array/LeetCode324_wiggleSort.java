package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode324_wiggleSort {


    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int[]temp = new int[n];
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            System.out.print("i:"+i+"j:"+j+"k:"+k);
            temp[i] = arr[j];
            if (i + 1 < n) {
                temp[i + 1] = arr[k];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //1,1,1,4,5,6
        //1,6,1,5,1,4
        //1,6,1,4,5,1
        int[] nums = {1,5,1,1,6,4};
        LeetCode324_wiggleSort test = new LeetCode324_wiggleSort();
        test.wiggleSort(nums);
        System.out.println(nums);
    }
}
