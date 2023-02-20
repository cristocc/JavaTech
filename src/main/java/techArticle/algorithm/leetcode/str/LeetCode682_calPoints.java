package techArticle.algorithm.leetcode.str;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2021/4/20
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author cc
 */
public class LeetCode682_calPoints {

    public static int calPoints(String[] ops) {
        Deque<String> queue = new LinkedList<>();
        for(String val:ops){
            if("C".equals(val)){
                queue.pollLast();
            }else if("D".equals(val)){
                String last = queue.pollLast();
                Integer temp = Integer.valueOf(last) * 2;
                queue.offer(last);
                queue.offer(temp + "");
            }else if("+".equals(val)){
                String last1 = queue.pollLast();
                String last2 = queue.pollLast();
                Integer temp = Integer.valueOf(last1) + Integer.valueOf(last2);
                queue.offer(last2);
                queue.offer(last1);
                queue.offer(temp + "");
            }else {
                queue.offer(val);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()){
            ans += Integer.valueOf(queue.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        String []  a= {"5","-2","4","C","D","9","+","+"};
        calPoints(a);


    }
}



