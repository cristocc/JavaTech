package techArticle.algorithm.labuladong;


import java.sql.PseudoColumnUsage;
import java.util.*;

/**
 * Created by crist on 2021/11/9
 *
 * @author cc
 */
public class ListNodeTest1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //递归
    //1->2->3
    static ListNode reserve(ListNode head){
        if(null == head.next){
            return head;
        }
        ListNode last = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //1->2->3
    //1<-2->3
    static ListNode reverse2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static class fib{
        // 1,1,2,3,5
        static int fib(int n){
            if(n ==1 || n==2){
                return 1;
            }
            return fib(n-1) + fib(n-2);
        }

        static int fib1(int n){
            int[] memo = new int[n+1];
            return helper(memo,n);
        }
        static int helper(int[] memo,int n){
            if(n ==1 || n==2){
                return 1;
            }
            if(memo[n] != 0){
                return memo[n];
            }
            memo[n] = helper(memo,n-1) + helper(memo,n-2);
            return memo[n];
        }

        static int fib2(int n){
            int[] memo = new int[n+1];
            memo[0] = 0;  memo[1] = 1;
            for(int i=2;i<=n;i++){
                memo[n] = memo[i-1] +memo[i-2];
            }
            return memo[n];
        }

        static int fib3(int n){
            int pre = 1;
            int cur = 1;
            for(int i=3;i<=n;i++){
                int sum = pre + cur;
                pre = cur;
                cur = sum;
            }
            return cur;
        }
    }



/*    输入：numbers = [2,7,11,15], target = 9
    输出：[1,2]
    解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。*/

    public int[] twoSum(int[] numbers, int target) {


        int left = 0;
        int right = numbers.length;
        int[] res = new int[2];
        while(left < right){
            if(target == numbers[left] + numbers[right]){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(target < numbers[left] + numbers[right]){
                right --;

            }else if(target > numbers[left] + numbers[right]){
                left++;
            }
        }
        return res;

    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char cr = s[right] ;
            s[right] = s[left];
            s[left] = cr;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");

        for(int i=0;i<ss.length;i++){
            char[] a = ss[i].toCharArray();
            int left = 0;
            int right = a.length - 1;
            while(left < right){
                char cr = a[right] ;
                a[right] = a[left];
                a[left] = cr;
                left++;
                right--;
            }
            if(ss.length -1 == i){
                sb.append(String.valueOf(a));
            }else{
                sb.append(String.valueOf(a)).append(" ");
            }

        }
        return sb.toString();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = Arrays.asList(1);
        List<Integer> two = Arrays.asList(1,1);
        res.add(one);
        if(numRows == 1){
            return res;
        }
        res.add(two);
        if(numRows == 2){
            return res;
        }
        for(int i = 3;i<=numRows;i++){
            List<Integer> temp = new ArrayList<>();
            List<Integer> pre = res.get(i-2);
            for(int j = 1;j <= i;j++){
                if(j == 1 || j==i){
                    temp.add(1);
                }else{
                    int val  = pre.get(j-2) + pre.get(j-1);
                    temp.add(val);
                }
            }
            res.add(temp);
        }
        return res;

    }


    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            if(nums[0]>0){
                return true;
            }else{
                return false;
            }
        }
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(max >= i){
                max = Math.max(max , i+nums[i]);
                if(max >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;

    }
// int[] nums1 = {2,3,1,1,4,3,2,1};
    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int steps = 1;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(max >= nums.length  -i){
                return steps;
            }
            steps ++;
        }
        return steps;
    }





/*    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        maxProfit(nums);

    }*/
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

//nums = [1,-2,-3,4]
    public int getMaxLen(int[] nums) {

        int positive = nums[0] > 0 ? 1:0;
        int negitive = nums[0] < 0 ? 1:0;
        int max = positive;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                positive++;
                negitive = negitive>0? negitive+1:0;
            }else if(nums[i]<0){
                int newp = negitive > 0 ? negitive + 1 : 0;
                int newn =  positive + 1;
                positive = newp;
                negitive = newn;
            }else{
                positive = 0;
                negitive=0;
            }
            max = Math.max(positive,max);
        }
        return max;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;

    }
/*

    有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。

    给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

    为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
    接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。

    最后返回经过上色渲染后的图像。
*/


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[x].length ) {
            return ;
        }
        if (image[x][y] == color) {
            image[x][y] = newColor;
            dfs(image, x + 1, y, color, newColor);
            dfs(image, x - 1, y, color, newColor);
            dfs(image, x, y + 1, color, newColor);
            dfs(image, x, y - 1, color, newColor);
        }
    }

    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

/*    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }*/

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                //System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
               // System.out.println("递归之后 => " + path);
            }
        }
    }

    //输入：n = 4, k = 2
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
       // permute(nums);
        isValid("([{]])");
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


}
