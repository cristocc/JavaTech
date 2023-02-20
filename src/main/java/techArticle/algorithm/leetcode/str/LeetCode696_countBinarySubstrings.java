package techArticle.algorithm.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode696_countBinarySubstrings {


    // 00110011
    public static int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int n = s.length();
        int first = s.charAt(0) - '0';
        int count = 1;
        for(int i=1;i<n;i++){
            int cur = s.charAt(i)  - '0';
            if(cur == first){
                count++;
            }else{
                counts.add(count);
                count = 1;
            }
            first = cur;
            if(i == n - 1){
                counts.add(count);
            }
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;

    }

    public static void main(String[] args) {
        countBinarySubstrings("0101");
    }


}



