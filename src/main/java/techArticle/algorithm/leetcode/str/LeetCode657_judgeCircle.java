package techArticle.algorithm.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode657_judgeCircle {

    public boolean judgeCircle(String moves) {
        char[] c = moves.toCharArray();
        int r = 0;
        int l = 0;
        int u = 0;
        int d = 0;
        for(int i=0;i<c.length;i++){
            if(c[i] == 'R'){
                r++;
            }
            if(c[i] == 'L'){
                l++;
            }
            if(c[i] == 'U'){
                u++;
            }
            if(c[i] == 'D'){
                d++;
            }
        }
        if(r == l && u == d){
            return true;
        }
        return false;

    }

}



