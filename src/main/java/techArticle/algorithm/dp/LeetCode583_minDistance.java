package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @author cc
 */
public class LeetCode583_minDistance {

/*    输入：word1 = "horse", word2 = "ros"
    输出：3
    解释：
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')*/

   int [][] memo ;

    public int minDistance(String word1, String word2) {

    }

    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }


}
