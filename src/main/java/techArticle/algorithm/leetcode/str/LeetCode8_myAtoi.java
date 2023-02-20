package techArticle.algorithm.leetcode.str;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode8_myAtoi {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] temp = new int[len1 + len2];
        int index = 0;
        int first = 0;
        int second = 0;
        while (first < len1 && second <len2){
            if(nums1[first] >= nums2[second]){
                temp[index] = nums2[second];
                second++;
            }else{
                temp[index] = nums1[first];
                first++;
            }
            index++;
        }
        while (first < len1){
            temp[index] = nums1[first];
            index++;
            first++;

        }
        while (second < len2){
            temp[index] = nums2[second];
            index++;
            second++;
        }
        int middle = (len1 + len2) / 2;
        if((len1 + len2) % 2 == 0){
            double ans = (double) (temp[middle] + temp[middle - 1]) / 2;
            return ans;
        }else {
            return temp[middle];
        }
    }

    public static void main(String[] args) {
        LeetCode8_myAtoi test = new LeetCode8_myAtoi();
        int[] a1 = {1,2};
        int[] a2 = {3,4};
        System.out.println( test.findMedianSortedArrays(a1,a2));
    }
}
