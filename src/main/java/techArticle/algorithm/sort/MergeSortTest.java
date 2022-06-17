package techArticle.algorithm.sort;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int [] nums = {5,2,3,1};
        sortArray(nums);
        System.out.println("");
    }
    private static int[] temp;

    public static int[]  sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
        return nums;
    }

    static void sort(int[] nums,int lo,int hi){
        if(lo == hi){
            return;
        }
        int middle = lo + (hi - lo)/2;
        sort(nums,lo,middle);
        sort(nums,middle+1,hi);
        merge(nums,lo,middle,hi);
    }

    static void merge1(int[] nums,int lo,int mid,int hi){
        int[] help = new int[hi - lo + 1];
        int i = 0;
        int left = lo;
        int right = mid+1;
        while (left <= mid && right<=hi){
            help[i++] = nums[left] <= nums[right]?nums[left++]:nums[right++];
        }
        while (left <= mid){
            help[i++] = nums[left++] ;
        }
        while (right<=hi){
            help[i++] =nums[right++];
        }
        for(i = 0;i<help.length;i++){
            nums[lo+i] = temp[i];
        }
    }


    static void merge(int[] nums,int lo,int mid,int hi){
        for(int i = lo;i<=hi;i++){
            temp[i] = nums[i];
        }
        int left = lo;
        int right = mid + 1;

        for(int i = lo;i<=hi;i++){
            if(left == mid+1){
                nums[i] = temp[right++];
            }else if(right == hi + 1){
                nums[i] = temp[left++];
            }else if(temp[left] >= temp[right]){
                nums[i]=temp[right++];
            }else{
                nums[i]=temp[left++];
            }
        }
    }

}
