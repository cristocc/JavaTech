package techArticle.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode447_numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int i = 0;i<points.length;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0;j<points.length;j++){
                if(i == j){
                    continue;
                }
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int dist = x*x + y*y;
                map.put(dist,map.getOrDefault(dist,0) + 1);
            }
            for(Integer key:map.keySet()){
                int cnt = map.get(key);
                ans += cnt * (cnt - 1);
            }
        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
