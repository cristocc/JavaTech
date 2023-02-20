package techArticle.algorithm.sort;

/**
 * Created by crist on 2022/10/13
 *
 * @author cc
 */
public class ShellSort {

    public static void main(String[] args) {
        int [] nums = {9,1,2,7,11,13,5,8,23};
        sort(nums);
        System.out.println("");
    }

    public static void sort(int[] nums){
        int inner,outer;
        int temp;
        int h = 1;
        int length = nums.length ;

        while (h <= length/3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for(outer = h;outer < length;outer++){
                temp = nums[outer];
                inner = outer;
                while (inner > h - 1 && nums[inner - h]>= temp){
                    nums[inner] = nums[inner-h];
                    inner = h;
                }
                nums[inner] = temp;

            }
            h = (h-1) / 3;
        }
    }
}
