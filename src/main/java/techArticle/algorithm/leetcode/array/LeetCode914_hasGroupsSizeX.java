package techArticle.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/4/30
 * https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/
 * @author cc
 */
public class LeetCode914_hasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int val :deck){
            map.put(val,map.getOrDefault(val,0) +1);
        }
        int val = map.get(deck[0]);
        for(Integer key:map.keySet()){
            int temp = map.get(key);
            if(val != temp){
                return false;
            }
        }
        return true;
    }

}
