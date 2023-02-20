package techArticle.algorithm.leetcode.lcp;

import java.util.Arrays;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_reverseList {


    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int ans = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        for(int i = 0;i<staple.length;i++){
            if(staple[i] > x){
                break;
            }
            for(int j=0;j<drinks.length;j++){
                if(staple[i] + drinks[j] <= x){
                    ans++;
                }else {
                    break;
                }
            }
        }
        return ans ;
    }
}
