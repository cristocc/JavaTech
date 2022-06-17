package techArticle.algorithm.sort;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] nums = {-3,1,2,4,0,-1,5};
        process(nums,0,nums.length -1);
        System.out.println("");
    }

    public static void process(int[] nums ,int L,int R){
        if(L == R){
            return;
        }
        int middle = L + ((R - L)>>1);
        process(nums,L,middle);
        process(nums,middle+1,R);
        merge(nums,L,middle,R);
    }


    public static void merge(int[]nums ,int L,int M,int R){
        int [] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while(p1 <= M && p2 <= R){
            help[i++] = nums[p1] <= nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1 <= M){
            help[i++] = nums[p1++];
        }
        while(p2 <= R){
            help[i++] = nums[p2++];
        }
        for(i=0;i<help.length;i++){
            nums[L+i] = help[i];
        }
    }
    private static int[] temp;
    private static void merge1(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                // 右半边数组已全部被合并
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
