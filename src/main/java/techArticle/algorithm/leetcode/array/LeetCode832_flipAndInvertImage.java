package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/26
 * https://leetcode.cn/problems/flipping-an-image/
 * @author cc
 */
public class LeetCode832_flipAndInvertImage {

    public static int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        for(int[] row:image){
            for(int i=0, j = len -1;i<len / 2;i++,j--){
                swap(row,i,j);
            }
        }
        for(int[] row:image){
            for(int i=0;i<len;i++){
                if(row[i] == 0){
                    row[i] = 1;
                }else{
                    row[i] = 0;
                }
            }
        }
        return image;
    }

    private static void swap(int[] row,int start,int end){
        int temp = row[end];
        row[end] = row[start];
        row[start] = temp;

    }

    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(image);
    }
}
