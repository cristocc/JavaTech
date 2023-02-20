package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_printNumbers {

    public int[] printNumbers(int n) {
        int ans = 1;
        for(int i = 1;i< n + 1;i++){
            ans = ans * 10;
        }
        ans = ans -1 ;
        int[] arr = new int[ans];
        for(int i = 0;i<ans;i++){
            arr[i] = i + 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int n =3;
        int ans = 1;
        for(int i = 1;i< n + 1;i++){
            ans = ans * 10;
        }
        System.out.println(ans - 1);



    }
}
