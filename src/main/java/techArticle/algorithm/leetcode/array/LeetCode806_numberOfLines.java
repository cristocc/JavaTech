package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/26
 * https://leetcode.cn/problems/number-of-lines-to-write-string/
 * @author cc
 */
public class LeetCode806_numberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        int row = 1;
        int width = 0;
        int[] ans = new int[2];
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            int c = chars[i] - 'a';
            int cwidth = widths[c];
            if(width + cwidth < 100 ){
                width += cwidth;
            }else if(width + cwidth == 100 ){
                width += cwidth;
            }else if(width + cwidth > 100 ){
                width = cwidth;
                row++;
            }
        }
        ans[0] = row;
        ans[1] = width;
        return ans;
    }
}
