package leetcode.array;

/**
 * Created by crist on 2021/5/6
 *
 * @author cc
 */
public class LeetCode1720_decode {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }

}
