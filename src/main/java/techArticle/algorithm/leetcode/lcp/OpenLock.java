package techArticle.algorithm.leetcode.lcp;

import java.util.*;

/**
 * Created by crist on 2022/7/25
 *
 * @author cc
 */
public class OpenLock {

/*    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
    每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
    字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。*/

/*    输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    输出：6
    解释：
    可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
    注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
    因为当拨动到 "0102" 时这个锁就会被锁定。*/


    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        String startStr = "0000";
        if(set.contains(startStr)){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startStr);
        visited.add(startStr);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                String str = queue.poll();
                for(int i = 0;i<4;i++){
                    char ch = str.charAt(i);
                    //strAdd表示加1的结果，strSub表示减1的结果
                    String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                    String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                    //如果找到直接返回
                    if (str.equals(target))
                        return level;
                    //不能包含死亡数字也不能包含访问过的字符串
                    if (!visited.contains(strAdd) && !set.contains(strAdd)) {
                        queue.offer(strAdd);
                        visited.add(strAdd);
                    }
                    if (!visited.contains(strSub) && !set.contains(strSub)) {
                        queue.offer(strSub);
                        visited.add(strSub);
                    }
                }

            }
            level++;
        }
        return level;

    }


}
