package test;

public class Test3 {

    public static void main(String[] args) {

/*        iconst_1
        1: istore_1
        2: iload_1
        3: iinc          1, 1
        6: istore_2

        int x = 1;
        int y = x++;
        System.out.println(x);
        System.out.println(y);*/
// --------
 /*       0: iconst_1
        1: istore_1
        2: iinc          1, 1
        5: iload_1
        6: istore_2*/

        int x = 1;
        int y = ++x;
        System.out.println(x);
        System.out.println(y);
    }
}
