package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/combination-sum/
 * @author cc
 */
public class LeetCode907_sumSubarrayMins {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] flag;
    int length = 0;

    public int combinationSum(int[] candidates) {
        List<Integer> track = new ArrayList<>();
        length = candidates.length;
        flag = new boolean[length];
        dfs(candidates,track,0);
        long result = 0 ;
        final int MOD = 1000000007;
        for(List<Integer> list : ans){
            int min = getMin(list);
            result = (result + min) % MOD;
        }
        return (int)result;
    }

    public int getMin(List<Integer> list){
        int min = Integer.MAX_VALUE;
        for(Integer i:list){
            if(i< min){
                min = i;
            }
        }
        return min;
    }


    private void dfs(int[] candidates,List<Integer> track,int index){
        if(index > length){
            return;
        }
        if(track.size() > 0){
            if(track.size() == 1){
                ans.add(new ArrayList<>(track));
            }else {
                boolean series = true;
                List<Integer> list = new ArrayList<>();
                for(int i = 0;i<flag.length;i++){
                    if(flag[i]){
                        list.add(i);
                    }
                }
                int first = list.get(0);
                for(int i = 1;i < list.size();i++){
                    int cur = list.get(i);
                    if(cur - first != 1){
                        series = false;
                        break;
                    }
                    first = cur;
                }
                if(series){
                    ans.add(new ArrayList<>(track));
                }
            }
        }
        for(int i=index;i<candidates.length;i++){
            if(flag[i]){
                continue;
            }
            track.add(candidates[i]);
            flag[i] = true;
            dfs(candidates,track,i+1);
            track.remove(track.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        LeetCode907_sumSubarrayMins s = new LeetCode907_sumSubarrayMins();
        s.combinationSum(arr);
        for(List<Integer> list:s.ans){
            System.out.println(list);
        }
/*        boolean[] f = new boolean[]{false,true,true,true,true,false};
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<f.length;i++){
            if(f[i]){
                list.add(i);
            }
        }
        int first = list.get(0);
        for(int i = 1;i < list.size();i++){
            int cur = list.get(i);
            if(cur - first != 1){
                System.out.println("is not 1");
                break;
            }
            first = cur;
        }*/


    }
}
