package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_calculate {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int _x = 0;
        int _y = 0;
        char[] commands = command.toCharArray();

        while (true){
            for(int i=0;i<commands.length;i++){
                if(commands[i] == 'U'){
                    _y ++;
                } else if(commands[i] == 'R'){
                    _x ++;
                }
                if(obstacles(obstacles,_x,_y)){
                    return false;
                }
                if(x == _x && y == _y){
                    return true;
                }
            }
        }
    }

    public boolean obstacles(int[][] obstacles, int x, int y){
        if(null == obstacles){
            return false;
        }
        for(int[] o:obstacles){
            if(o[0] == x && o[1] ==y ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String command = "URR";
        int x = 3;
        int y = 2;
        LeetCode_calculate test = new LeetCode_calculate();
        test.robot(command,null,x,y);
    }

}
