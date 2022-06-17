package techArticle.algorithm.labuladong;

import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * Created by crist on 2021/11/9
 *
 * @author cc
 */
public class ListNodeTest {
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

    //合并 k 个有序链表
   static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

// 返回链表的倒数第 k 个节点
    static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }


    // 主函数
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public static ListNode remove(ListNode head, int n){
        ListNode dummy = head;
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        while(dummy !=null){
            int val = dummy.val;
            if(val == n){
                //dummy = dummy.next;
                temp.next = new ListNode();
            }else{
                temp.val = val;
                temp.next = new ListNode();
            }
            temp = temp.next;
            dummy = dummy.next;
        }
        return ret.next;
    }

   /* public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums2 = {2,3,7};
        ListNode l1 = getNode(nums);
        ListNode l2 = getNode(nums2);
        ListNode[] listNodes = {l1,l2};
       // reverse(l2);
        //reverse(l1);
        //remove(l1,1);
        //mergeKLists(listNodes);
        //ListNode l3 = removeNthFromEnd(l1,2);
        //System.out.println(l3);

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
       // maxSubArray(arr);
        String text2 = "sea";
        String text1 = "eat";
        //minimumDeleteSum(text1,text2);
        //int max = Integer.MAX_VALUE - Integer.MIN_VALUE;
        //System.out.println(max);

        int amount = 5;
        int coins[] = {1,2,5};
        change(amount,coins);

    }*/

    static ListNode getNode(int[] nums){
        ListNode node = new ListNode();
        ListNode l1 = node;
        for(int i=0;i < nums.length;i++){
            l1.val = nums[i];
            if(i != nums.length -1 ){
                l1.next =  new ListNode();
                l1 = l1.next;
            }

        }
        return node;
    }

    static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

   static ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    static  ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

   static ListNode reverse2(ListNode head) {
        // 1->2->3->4->5
       //
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /*    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 子数组 是数组中的一个连续部分。*/
    //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            //{-2,1,-3,4,-1,2,1,-5,4}
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            //[-2,1,-2,4,3,5,6]
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j+1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i), dp[i][j+1] + s2.codePointAt(j));
                }
            }
        }
        return dp[0][0];
    }

    //给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
    //如果存在则返回 true，不存在返回 false。
    //nums = [1,2,3,1], k = 3, t = 0
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    int memo[];
    //  amount = 11 coins 1，2，5
    int coinChange(int[] coins, int amount){
        memo = new int[amount + 1];
        Arrays.fill(memo ,-666);
        return dp(coins,amount);
    }

    int dp(int[] coins, int amount){
        if(amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if(memo[amount] != -666){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin :coins){
            int sub = coinChange(coins,amount-coin);
            if(sub == -1){
                continue;
            }
            res = Math.min(sub + 1,res);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1:res;
        return memo[amount];
    }

    //amoumt 5, coins 1,2,5
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) { //1,2,5
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

   // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
/*    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
            1.  1 阶 + 1 阶
2.  2 阶*/
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] numRows = 5
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

   // 给定一个整数数组，判断是否存在重复元素。如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }


//[10, 15, 20]
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int n = s.length();
        int left = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left =Math.max(left,map.get(c)+1);

            }
            map.put(c,i);
            ans = Math.max(ans,i-left+1);

        }
        return ans;
    }



    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }





    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static int getMaxLen(int[] nums) {
        int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 !=null){
            if(p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    //1->2
    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            if(cur.val == cur.next.val){
                cur = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        Deque path = new ArrayDeque();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(len == depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    //输入：n = 4, k = 2
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque path = new ArrayDeque();
        dfs(n,k,1,path,res);
        return res;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin;i<=n;i++){
            path.add(i);
            dfs(n,k,i+1,path,res);
            path.removeLast();
        }

    }

    //isValid("([{]])");
    public static boolean isValid(String s) {
        int n = s.length();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque stack = new LinkedList();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || !stack.getLast().equals(pairs.get(ch))){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }

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

/*    输入：strs = ["flower","flow","flight"]
    输出："fl"*/
    public static String longestCommonPrefix(String[] strs) {
        String temp = strs[0];
        int start = 0;
        int end = temp.length();
        while(start < end){
            char front = temp.charAt(start);
            for(String str : strs){
                if(str.length() - 1 < start){
                    return temp.substring(0,start);
                }
                if(front != str.charAt(start) ){
                    return temp.substring(0,start);
                }
            }
            start++;
        }
        return temp.substring(0,start);
    }




/*    输入：nums = [3,30,34,5,9]
    输出："9534330"*/
    public String largestNumber(int[] nums) {
        boolean[] flag =  new boolean[nums.length];
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){

            //res[i] =
        }
        return "";
    }
/*    输入：nums = [0,1,2,4,5,7]
    输出：["0->2","4->5","7"]
    解释：区间范围是：
            [0,2] --> "0->2"
            [4,5] --> "4->5"
            [7,7] --> "7"*/

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int b = nums[i+1];
            if( b - a ==1){
                end = i;
            }else{

                start = i;
            }


        }

        return res;
    }



    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

/*    输入：s = "abcd", t = "abcde"
    输出："e"
    解释：'e' 是那个被添加的字母。*/
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        int sums1 = 0;
        int sums2 = 0;

        for(char c:s1){
            sums1 += c;
        }
        for(char c:s2){
            sums2 += c;
        }
        int diff = sums2 - sums1;

        return (char)diff;


    }

    public static int longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c:ca){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        int ans = 0;
        for(Character key:map.keySet()){
            Integer value = map.get(key);
            ans += value / 2 * 2;
            if (value % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }



    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i=1;i<=n;i++){
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = nums[length -1];
        List<Integer> res = new ArrayList<>();
        for(int i=length-1;i>=0;i--){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
            }
            if(res.size() == 3){
                break;
            }
        }
        if(res.size()<3){
            return max;
        }
        return res.get(2);
    }





    public static double findMaxAverage(int[] nums, int k) {

        double res = -Double.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp =0;
            if(i+k - 1>=nums.length){
                break;
            }
            for(int j=i;j<= i+k-1;j++){
                temp += nums[j];
            }
            double avg = 1.0 * temp / k;
            res = Math.max(avg,res);
        }
        return res;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n-3] * nums[n-2] * nums[n-1];
        int b = nums[0] * nums[1] * nums[n-1];
        return Math.max(a,b);

    }

    public int distributeCandies(int[] candies) {
        int length = candies.length;
        int maxtypes = length / 2;
        Set<Integer> set = new HashSet<>();
        for(int c:candies ){
            set.add(c);
        }
        return Math.min(maxtypes,set.size());
    }

    public boolean checkRecord(String s) {
        int a = 0;
        int ts = 0;
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            char t = c[i];
            if('A' == t){
                a ++;
                ts = 0;
                if(a == 2){
                    return false;
                }
            }else if ('L' == t){
                ts++;
                if(ts == 3){
                    return false;
                }
            }else{
                ts = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[] nums ={3,6,1,0};
        //dominantIndex(nums);

        //int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
       // isToeplitzMatrix(matrix);
        //rotateString("gcmbf","fgcmb");
       // "bbbacddceeb"
        //"ceebbbbacdd"

        //bbbacddceeb ceebbbbacdd
        //rotateString("abcde","cdeab");
        //largeGroupPositions("aaaa");
        //[5,5,10,10,5,20,5,10,5,5]
        //int[] nums ={5,5,10,10,5,20,5,10,5,5};
        //String[] words = {"bella","label","roller"};
        //commonChars(words);
        //sumZero(3);
        reverse(123);

    }



    public static int reverse(int x) {
        int digit = 1;
        if(x<0){
            digit = -1;
            x = Math.abs(x);
        }
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }

        try {
            return Integer.valueOf(sb.toString()) * digit;
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static int numberOfSteps(int num) {

        if(num == 0){
            return 0;
        }
        int res = 0;
        while(num>0){
            if(num % 2 == 0){
                num = num / 2;
            }else{
                num--;
            }
            res++;
        }
        return res;
    }

    public static int maximum69Number (int num) {
        int k = 10000;
        int res = 0;
        while(num > 0){
            //从左到右找到第一个6，将其变为9
            if(num / k == 6){
                res += 9 * k;
                res += (num % k);
            }else{
                res += (num/k) * k;
            }
            num %= k;
            k /= 10;
        }
        return res;
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        for(int i=0;i<res.length/2;i++){
            res[i] = n - i;
            res[res.length - i - 1] = -(n - i);
        }
        return res;
    }

    public int findNumbers(int[] nums) {

        int res = 0;
        for(int n:nums){
            String val = String.valueOf(n);
            if(val.length() %2 == 0){
                res++;
            }
        }
        return res;

    }


    public int balancedStringSplit(String s) {
        int res = 1;
        char[] sc = s.toCharArray();
        int left = 0;
        int right = 0;
        for(char c:sc ){
            if(c == 'L'){
                left ++;
            }
            if(c == 'R'){
                right ++;
            }
            if(left == right){
                res++;
                left=0;
                right=0;
            }
        }
        return res;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static List<String> commonChars(String[] words) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int s = 0;
        for (int num : A) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3;
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        while (j + 1 < n) {  // 需要满足最后一个数组非空
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }

    public int smallestRangeI(int[] nums, int k) {

        Arrays.sort(nums);
        int small = nums[0];
        int big = nums[nums.length-1];
        int res = (big - k) - (small + k);
        if(res < 0){
            return 0;
        }
        return res ;

    }

    // 5 5 10 10 20
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int bill:bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five < 1){
                    return false;
                }
                five --;
                ten++;
            }else if(bill == 20){
                if((five < 3) && (five <1 || ten<1)){
                    return false;
                }
                if(five >=1 && ten >= 1){
                    five -- ;
                    ten -- ;
                }else {
                    five = five-3;
                }
            }
        }
        return false;
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if(s.length() == 3){
            if((s.charAt(0) == s.charAt(1)) && (s.charAt(1) == s.charAt(2))){
                res.add(Arrays.asList(0,2));
            }else{
                return res;
            }

        }
        int num = 1;
        for(int i =0;i<s.length()-1;i++){
            char cur = s.charAt(i);
            char next = s.charAt(i+1);
            if(cur == next){
                num ++;
            }else{
                if(num >=3){
                    List<Integer> list = new ArrayList<>();
                    list.add(i-num+1);
                    list.add(i);
                    res.add(list);
                }
                num = 1;
            }
        }
        return res;
    }

    public String toGoatLatin(String sentence) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String[] ss = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for(String s:ss){
            char first = s.charAt(0);
            StringBuilder behind = new StringBuilder("ma");
            StringBuilder news = new StringBuilder();
            for(int i= 1;i<=index;i++){
                behind.append("a");
            }
            if(!set.contains(first)){
                for(int i=1;i<s.length();i++){
                    news.append(s.charAt(i));
                }
                news.append(s.charAt(0));
            }else{
                news.append(s);
            }
            news.append(behind);
            sb.append(news).append(" ");
            index ++;
        }
        String res = sb.toString();

        return res.substring(0,res.length()-1);
    }

    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans,-1);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                set.add(i);
                ans[i] = 0;
            }
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != c){
                int min = Integer.MAX_VALUE;
                for (Iterator it = set.iterator(); it.hasNext(); ) {
                    Integer index = (Integer) it.next();
                    int length = Math.abs(i - index);
                    min = Math.min(min,length);
                }
                ans[i] = min;
            }
        }
        return ans;
    }

    public static  boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);

    }

    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length();i++){
            char c = stones.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        for(int i=0;i<jewels.length();i++){
            if(null != map.get(jewels.charAt(i))){
                res += map.get(jewels.charAt(i));
            }

        }
       return res;
    }


    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            if(i ==matrix.length -1){
                break;
            }
            for(int j=0;j<matrix[0].length;j++){
                if(j == matrix[0].length - 1){
                    break;
                }
                if(matrix[i][j] != matrix[i + 1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int dominantIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int last = nums[nums.length-1];
        int last2 = nums[nums.length-2];
        if(last2 * 2 > last){
            return -1;
        }
        return map.get(last);

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char last = letters[letters.length - 1];
        if(target - last >= 0){
            return letters[0];
        }
        for(char c:letters){
            if(target - c < 0){
                return c;
            }
        }
        return 'a';
    }

}
