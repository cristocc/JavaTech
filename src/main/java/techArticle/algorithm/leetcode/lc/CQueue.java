package techArticle.algorithm.leetcode.lc;

import java.util.LinkedList;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class CQueue {

    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

    LinkedList<Integer> A,B;

    public CQueue() {
        A = new LinkedList<>();
        B= new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()){
            return B.removeLast();
        }
        if(A.isEmpty()){
            return -1;
        }
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
