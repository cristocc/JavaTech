package techArticle.algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/video-stitching/
 * @author cc
 */
public class LeetCode120_minimumTotal {

    private static int result = Integer.MAX_VALUE;
    int size;
    List<Integer> track = new LinkedList<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        size = triangle.size();
        dfs(triangle,0,0);
        return result;
    }

    void dfs(List<List<Integer>> triangle,int h,int i){
        if(h == size ){
            int temp = 0;
            for (Integer num:track){
                temp += num;
            }
            result = Math.min(result,temp);
            return;
        }
        List<Integer> list = triangle.get(h);
        for(Integer num:list){
            track.add(num);
            dfs(triangle, h+1,i);
            dfs(triangle, h+1,i+1);
            track.remove(num);
        }
    }

    Integer [][] memo ;
    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        memo = new Integer[size][size];
        return  dfs1(triangle,0,0);
    }

    int dfs1(List<List<Integer>> triangle,int h,int i){
        if(h == size ){
            return 0;
        }
        if(memo[h][i] != null){
            return memo[h][i];
        }
        memo[h][i] = Math.min(dfs1(triangle, h+1,i), dfs1(triangle, h+1,i+1)) + triangle.get(h).get(i);
        return memo[h][i];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(2,3));
        //triangle.add(Arrays.asList(6,5,7));
        //triangle.add(Arrays.asList(4,1,8,4));
        LeetCode120_minimumTotal test = new LeetCode120_minimumTotal();
        System.out.println(test.minimumTotal(triangle));

    }

}
