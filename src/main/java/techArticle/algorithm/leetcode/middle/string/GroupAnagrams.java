package techArticle.algorithm.leetcode.middle.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2022/7/18
 *
 * @author cc
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        boolean[] used = new boolean[len];
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0;i<len;i++){
            if(used[i]){
                continue;
            }
            String a = strs[i];
            List<String> list = new ArrayList<>();
            list.add(a);
            used[i] = true;
            int[] arrs = new int[26];
            for(int x = 0;x<a.length();x++){
                char c = a.charAt(x);
                arrs[c - 'a']++;
            }
            for(int j = 1;j<len;j++){
                if(used[j]){
                    continue;
                }
                String b = strs[j];
                int[] barrs = new int[26];
                for(int y = 0;y<b.length();y++){
                    char c = b.charAt(y);
                    barrs[c - 'a']++;
                }
                if(Arrays.equals(arrs,barrs)){
                    list.add(b);
                    used[j] = true;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
