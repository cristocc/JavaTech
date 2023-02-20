package techArticle.algorithm.leetcode.str;

/**
 * Created by crist on 2021/4/20
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cc
 */
public class LeetCode541_reverseStr {

    //"catsandog"
    //["cats","dog","sand","and","cat"]

    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int length = v1.length >= v2.length ? v1.length : v2.length;
        int result = 0;
        for(int i=0;i<length; i++){
            Integer s1,s2;
            if(i > v1.length -1){
                s1 = 0;
            }else{
                s1 = Integer.valueOf(v1[i]);
            }
            if(i > v2.length -1){
                s2 = 0;
            }else{
                s2 = Integer.valueOf(v2[i]);
            }
            if(s1 > s2){
                result = 1;
                break;
            }
            if(s1 < s2){
                result = -1;
                break;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        LeetCode541_reverseStr test = new LeetCode541_reverseStr();
        test.compareVersion("1.0","1.0.0");

    }


}



