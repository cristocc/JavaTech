package techArticle.algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/regular-expression-matching/
 * @author cc
 */
public class LeetCode611_triangleNumber {

    int ans = 0;
    List<Integer> track = new ArrayList<>();
    boolean[] visited ;

    public int triangleNumber(int[] nums) {
        int length = nums.length;
        if(nums.length <3){
            return ans;
        }
        visited = new boolean[length];
        Arrays.sort(nums);
        dfs(nums,0,length);
        return ans;
    }

    void dfs(int[] nums,int index,int length){
        if(track.size() == 3){
            int a = track.get(0);
            int b = track.get(1);
            int c = track.get(2);
            if(a + b > c){
                ans++;
            }
            for(boolean v:visited){
                System.out.print(v +" ");
            }
            System.out.println();
            return;
        }
        for(int i=index;i<length;i++){
            int num = nums[i];
            if(visited[i] ){
                continue;
            }
            visited[i] = true;
            if(num == 0){
                continue;
            }
            track.add(num);
            dfs(nums,i + 1,length);
            track.remove(track.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {24,3,82,22,35,84,19};
        LeetCode611_triangleNumber test = new LeetCode611_triangleNumber();
        System.out.println(test.triangleNumber(nums));
    }

}
