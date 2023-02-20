package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/combination-sum/
 * @author cc
 */
public class LeetCode_permute {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return ans;
    }

    public void dfs(int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums);
            temp.remove(temp.size() - 1);
        }

    }

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        // 对cnt=1的情况单独处理
        if (cnt == 1) {
            for (int i = cards.length-1; i >= 0; i--) {
                if (cards[i]%2 == 0) return cards[i];
            }
            return 0;
        }
        int sum = 0;
        // 获取倒数cnt个数
        int i = cards.length-1;
        for (; i >= cards.length-cnt; i--) {
            sum += cards[i];
        }
        // 如果和为偶数直接返回
        if (sum % 2 == 0) return sum;
        // i < 0表示cnt == cards.length,即只有一种选择
        if (i < 0) return 0;
        // 分析可知n个数的和（sum）为奇数，则n个数里一定存在奇数和偶数
        // 获取倒数cnt+1数的奇偶性：true为偶数，false为奇数
        boolean flag = cards[i] % 2 == 0;
        // 从倒数cnt数开始，向后遍历，寻找和（倒数cnt+1数）奇偶不同差值最小的数
        int index = i+1;
        while (index < cards.length && (flag == (cards[index]%2==0))) {
            index++;
        }
        // 找到后用倒数cnt+1数替换此数，如 5 7 9 14，cnt = 2, sum = 23 + 7 - 14 = 16
        return sum + cards[i] - cards[index];
    }

}
