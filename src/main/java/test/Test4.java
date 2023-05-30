package test;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        Integer x = list.get(0);

    }

    public void for_(){
        for(int i = 0;i<10;i++){
            System.out.println(i);
        }
    }

    public void foreach_(){
        int[] index = {1,2};
        for(int v:index){
            System.out.println(v);
        }
    }
}
