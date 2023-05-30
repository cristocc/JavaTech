package techArticle.java.thread;

public class Test1 {

    public static void main(String[] args) {
        TestFinal t = new TestFinal();
        System.out.println(t.a);
        System.out.println(t.b);
    }

    static class TestFinal{
        final int a = 20;
        int b = 30;
    }
}
