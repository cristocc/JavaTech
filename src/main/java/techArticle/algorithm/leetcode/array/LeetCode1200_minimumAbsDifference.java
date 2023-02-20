package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by crist on 2021/3/30
 *
 * @author cc
 */
public class LeetCode1200_minimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int length = arr.length;
        for(int i =0;i< length - 1;i++){
            int temp = arr[i+1] - arr[i];
            min = Math.min(temp,min);
        }
        for(int i =0;i< length - 1;i++){
            int temp = arr[i+1] - arr[i];
            if(temp == min){
                List<Integer> list = Arrays.asList(arr[i],arr[i + 1]);
                result.add(list);
            }
        }
        return result;

    }
}
