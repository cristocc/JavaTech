package test;

public class InitTest {

    //初始化测试


    public static void main(String[] args)throws Exception {

        //不会触发初始化
        //System.out.println(A.a); //访问static final(基本类型，字符串)不会初始化
        //System.out.println(A.class);//访问Aclass
        //A[] a = new A[]{};//创建A数组


        //会触发初始化 new 关键字
        //System.out.println(A.b); //
        //System.out.println(B.b); //子类访问父类静态对象只会触发父类初始化
        //System.out.println(B.bb);//子类初始化，如果父类没有初始化，会引发父类初始化
        //Class.forName("test.A");
        //Class.forName("test.B");
        InitTest.class.getClassLoader().loadClass("");

    }


}
 class A {

    static final String a = "a";
    static  String b = "b";

    static {
        System.out.println("clz A static");
    }
}

 class B extends A {
    static final String ba = "ba";
    static String bb = "bb";
    static {
        System.out.println("clz B static");
    }

    //https://blog.csdn.net/qq_38974638/article/details/123460228
}