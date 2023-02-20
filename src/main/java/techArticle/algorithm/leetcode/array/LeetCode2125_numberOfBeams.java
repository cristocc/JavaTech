package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/26
 * https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 * @author cc
 */
public class LeetCode2125_numberOfBeams {

    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(String s:bank){
            int a = 0;
            for(char c:s.toCharArray()){
                if(c == '1'){
                    a++;
                }
            }
            if(a > 0){
                list.add(a);
            }
        }
        for(int i = 0;i<list.size()-1;i++){
            ans += list.get(i) * list.get(i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
