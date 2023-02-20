package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode1379_getTargetCopy {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int ans = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();

        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list2[j].equals(list1[i])){
                    if(i + j < ans){
                        ans = i + j;
                        list.clear();
                        list.add(list2[j]);
                    }else if(i + j == ans){
                        list.add(list2[j]);
                    }
                }
            }
        }
        String[] res = new String[list.size()];
        int index = 0;
        for(String str:list){
            res[index] = str;
            index++;
        }
        return res;
    }

}
