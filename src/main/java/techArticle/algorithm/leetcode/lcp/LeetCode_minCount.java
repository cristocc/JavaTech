package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_minCount {

    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for(int i=0;i<guess.length;i++){
            if(guess[i] == answer[i]){
                ans++;
            }
        }
        return ans;
    }
}
