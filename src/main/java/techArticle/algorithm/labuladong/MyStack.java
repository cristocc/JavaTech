package techArticle.algorithm.labuladong;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2021/11/19
 *
 * @author cc
 */
public class MyStack {

    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;
    /** 添加元素到栈顶 */
    public void push(int x){
        q.offer(x);
        top_elem = x;
    }

    /** 删除栈顶的元素并返回 */
    public int pop(){
        int size = q.size();
        // 留下队尾 2 个元素
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        // 记录新的队尾元素
        top_elem = q.peek();
        q.offer(q.poll());
        // 删除之前的队尾元素
        return q.poll();
    }

    /** 返回栈顶元素 */
    public int top(){
        return top_elem;
    }

    /** 判断栈是否为空 */
    public boolean empty(){
        return  q.isEmpty();
    }


    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                  //返回中轴的位置
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = {6,5,1,7,2,10};
        getMiddle(array,0,array.length-1);
    }

}
