package techArticle.algorithm.leetcode.str;

import java.util.*;

/**
 * Created by crist on 2021/4/20
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author cc
 */
public class LeetCode684_replaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);

    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList("cat","bat","rat")) ;
        String sentence = "the cattle was rattled";

        LeetCode684_replaceWords test = new LeetCode684_replaceWords();
        test.replaceWords(dict,sentence);
    }
}



