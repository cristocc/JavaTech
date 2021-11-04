package techArticle.algorithm.leetcode;

/**
 * Created by crist on 2021/3/29
 *
 * @author cc
 */
public class ReverseBit {

    static int n = 10010101;

    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 8 && n != 0; ++i) {

            rev |= (n & 1) << (7 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(n));
    }

}
