package techArticle.algorithm.leetcode.array;

import techArticle.algorithm.leetcode.linkedlist.ListNode;
import techArticle.algorithm.leetcode.tree.TreeNode;

import java.security.Key;
import java.util.*;

/**
 * Created by crist on 2022/3/30
 *
 * @author cc
 */
public class Leetcode1331_ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = new int[arr.length];
        System.arraycopy(arr,0,sorted,0,arr.length);
        Arrays.sort(sorted);
        int index = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int val:sorted){
            if(!map.containsKey(val)){
                map.put(val,index++);
            }
        }
        int[] ans = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<astr.length();i++){
            if(!set.contains(astr.charAt(i))){
                set.add(astr.charAt(i));
            }else {
                return false;
            }

        }
        return true;
    }


    public static boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0;i<len1;i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            arr1[a - 'a'] += 1;
            arr2[b - 'a'] += 1;
        }
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean canPermutePalindrome(String s) {
        int len = s.length();
        int[] arr = new int[256];
        for(int i = 0;i<len;i++){
            char c = s.charAt(i);
            arr[c - ' '] += 1;
        }
        if(len % 2 == 0){
            for(int v:arr){
                if(v % 2 != 0){
                    return false;
                }
            }
            return true;

        }else {
            int index = 0;
            for(int v:arr){
                if(v % 2 != 0){
                    index++;
                }
            }
            if(index != 1){
                return false;
            }
            return true;
        }

    }


    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(char c: S.toCharArray()){
            if(index >= length){
                break;
            }
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
            index++;
        }
        return sb.toString();
    }

/*    输入:
    first = "pale"
    second = "ple"
    输出: True*/

    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        int[][] dp = new int[m + 1][n + 1];//两个字符的前i j 个字符变成一样的，编辑距离
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n] <= 1;//不编辑或者只有一次编辑的机会
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] temp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = temp[i][j];
            }
        }

    }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next = node.next.next;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums,0,nums.length-1);
    }

    public static TreeNode dfs(int[] nums,int l,int r){
        if(l > r){
            return null;
        }
        int middle = r - (r - l)/2;
        System.out.println(middle);
        TreeNode node = new TreeNode(nums[middle]);
        node.left = dfs(nums,l,middle-1);
        node.right = dfs(nums,middle+1,r);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }


    public int findMagicIndex(int[] nums) {
        int index = 0;

        for(int i = 0;i<nums.length;i++){
            if(nums[i] == index){
                break;
            }
            index++;
        }
        return index;

    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return -1;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1!= l2){
            if(l1 == null){
                l1 = headB;
            }else {
                l1 = l1.next;
            }
            if(l2 == null){
                l2 = headA;
            }else {
                l2 = l2.next;
            }
        }
        return l1;
    }

    TreeNode  head = new TreeNode(-1);
    TreeNode pre = head;

    public TreeNode convertBiNode(TreeNode root) {
        if(null == root){
            return null;
        }
        inOrder(root);
        return head.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        pre.right = root;
        pre = root;
        root.left = null;
        inOrder(root.right);
    }

    public int add(int a, int b) {
        while(b != 0){
            int temp = a ^ b ;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }


    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;

    }

    public boolean checkTree(TreeNode root) {
        int main = root.val;
        int left = root.left.val;
        int right = root.right.val;
        return main == left + right;
    }

    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] arr = new int[2 * len];
        for(int i = 0;i<len;i++){
            arr[i] = nums[i];
            arr[i + len] = nums[i];
        }
        return arr;
    }

    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for(int i = 0;i<len;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int countAsterisks(String s) {
        int ans = 0;
        int index = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '|'){
                index++;
            }
            if(c == '*' && index %2 ==0){
                ans++;
            }
        }
        return ans;
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String s:operations){
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == 'X'){
                    continue;
                }
                if(s.charAt(i) == '+'){
                    ans++;
                    break;
                }
                if(s.charAt(i) == '-'){
                    ans--;
                    break;
                }
            }

        }
        return ans;

    }

    public char repeatedCharacter(String s) {
        Set set = new HashSet();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                return c;
            }else {
                set.add(c);
            }
        }
        return ' ';

    }

    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for(String s:sentences){
            String [] words = s.split("\\ ");
            max = Math.max(max,words.length);
        }
        return max;
    }

    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        char a = s.charAt(0);
        char b = s.charAt(3);
        char start = s.charAt(1);
        char end = s.charAt(4);
        for(char j = a;j<=b;j++) {
            for(char i = start;i<=end;i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(j).append(i);
                ans.add(sb.toString());
            }
        }
        return ans;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for(int c : candies){
            max = Math.max(c,max);
        }
        for(int c : candies){
            if(extraCandies + c >= max){
                ans.add(true);
            }else {
                ans.add(false);
            }
        }
        return ans;
    }

    static int size = 3 ;
    static Queue<Integer> queue = new LinkedList();
    static int length = 0;
    static int sum = 0;

    public void MovingAverage(int size) {
        this.size = size;

    }

    public static double next(int val) {
        queue.offer(val);
        sum += val;
        length++;
        int a = length;
        if(length > size){
            sum = sum - queue.poll();
            a = size;
        }
        double ans = (double) sum / a;
        return ans;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 1;

        while (d < depth - 1){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if( node.right != null){
                    queue.offer(node.right);
                }
            }
            d++;
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }

    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String w:words){
            boolean flag = true;
            for(int i = 0;i<pref.length();i++){
                if(w.length() < pref.length()){
                    flag = false;
                    break;
                }
                if(w.charAt(i) != pref.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }

    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String p:patterns){
            if(word.contains(p)){
                ans++;
            }
        }
        return ans;

    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 0;
        for(int i = 2;i<len;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }

    public static String kthDistinct(String[] arr, int k) {

        Map<String,Integer> set = new HashMap<>();
        for(String s:arr){
            Integer val = set.getOrDefault(s,0) + 1;
            set.put(s,val);
        }
        for(String s:arr){
            Integer val = set.get(s);
            if(val > 1){
                continue;
            }
            if(k == 0){
                return s;
            }
            k --;
        }
        return "";
    }

    public int minTimeToType(String word) {
        int res = 0;
        int prev = 0;   // 当前位置
        for (char ch : word.toCharArray()){
            // 计算键入每个字符的最小耗时并更新当前位置
            int curr = ch - 'a';
            res += 1 + Math.min(Math.abs(curr - prev), 26 - Math.abs(curr - prev));
            prev = curr;
        }
        return res;
    }


    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        set.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if (!set.contains(node.val)) {
                    return false;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return true;

    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> m1 = new HashMap<>();
        Map<String,Integer> m2 = new HashMap<>();
        String[] a1 = s1.split("\\ ");
        String[] a2 = s2.split("\\ ");
        for(String s : a1){
            Integer val = m1.getOrDefault(s,0)+ 1;
            m1.put(s,val);
        }
        for(String s : a2){
            Integer val = m2.getOrDefault(s,0)+ 1;
            m2.put(s,val);
        }
        List<String> list = new ArrayList<>();
        Set<String> set1 = m1.keySet();
        for(String s:set1){
            Integer val1 = m1.get(s);
            Integer val2 = m2.get(s);
            if(val1 == 1 && null == val2){
                list.add(s);
            }
        }

        Set<String> set2 = m2.keySet();
        for(String s:set2){
            Integer val1 = m1.get(s);
            Integer val2 = m2.get(s);
            if(val2 == 1 && null == val1){
                list.add(s);
            }
        }
        return list.toArray(new String[0]);

    }

    Queue<Integer> list = new LinkedList<>();


    public void BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root){
        if(null == root){
            return;
        }
        dfs(root.left);
        list.offer(root.val);
        dfs(root.right);
    }

    public int next() {
        return list.poll();

    }

    public boolean hasNext() {
        return list.isEmpty();
    }


    public static void main(String[] args) {
/*        System.out.println(next(1));
        System.out.println(next(10));
        String[] s = {"d","b","c","b","c","a"};
        kthDistinct(s,2);*/
    }

}
