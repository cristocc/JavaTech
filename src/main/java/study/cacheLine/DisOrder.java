package study.cacheLine;

public class DisOrder {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;


    // 乱序
    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        for(;;){
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(() ->{
                a = 1;
                x = b;
            });

            Thread other = new Thread(() ->{
                b = 1;
                y = a;
            });
            one.start();other.start();
            one.join();other.join();
            if(x == 0 && y ==0 ){
                System.out.println("a="+a);
                System.out.println("b="+b);
                System.out.println("x="+x);
                System.out.println("y="+y);
                break;
            }
        }

    }
}
