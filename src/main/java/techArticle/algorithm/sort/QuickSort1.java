package techArticle.algorithm.sort;

import java.util.Random;

/**
 * Created by crist on 2022/6/8
 *
 * @author cc
 */
public class QuickSort1 {
    // 快速排序 1：基本快速排序


    private static int[] quickSort1(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition1(arr, left, right);
            quickSort1(arr, left, partitionIndex - 1);
            quickSort1(arr, partitionIndex + 1, right);
        }
        return arr;
    }
    private static int partition1(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for(int i = index;i<=right;i++){
            if(arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index - 1);
        return index - 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {1,3,2,4,0,-1,5};
        quickSort1(nums,0,nums.length-1);
    }

}
