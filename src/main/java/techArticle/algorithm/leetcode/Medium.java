package techArticle.algorithm.leetcode;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
public class Medium {

    public static void main(String[] args) {
    }




    //https://leetcode-cn.com/problems/reverse-integer/ 整数反转
    public static int reverseinteger(int x) {
        int digit = 1;
        if(x<0){
            digit = -1;
            x = Math.abs(x);
        }
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }

        try {
            return Integer.valueOf(sb.toString()) * digit;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    //官方题解
/*    public int reverseinteger(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }*/



}
