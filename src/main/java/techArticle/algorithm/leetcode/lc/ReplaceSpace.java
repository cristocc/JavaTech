package techArticle.algorithm.leetcode.lc;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class ReplaceSpace {

    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
/*    输入：s = "We are happy."
    输出："We%20are%20happy."*/


    public String replaceSpace(String s) {
        if(null == s || s.length() == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
