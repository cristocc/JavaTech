package techArticle.algorithm.leetcode.interview;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_isFlipedString {

    public boolean isFlipedString(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 !=n2){
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
