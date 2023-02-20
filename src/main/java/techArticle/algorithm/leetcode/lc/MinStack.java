package techArticle.algorithm.leetcode.lc;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class MinStack {

/*    MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
            minStack.pop();
minStack.top();      --> 返回 0.
            minStack.min();   --> 返回 -2.*/

    Stack<Integer> a,b;

    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.add(x);
        if(b.empty() || b.peek() >= x){
            b.add(x);
        }
    }

    public void pop() {
        Integer val = a.pop();
        if(val.equals(b.peek())){
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}
