package study.cacheLine;

public class WriteCombining {

    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static final byte[] arrayA = new byte[ITEMS];
    private static final byte[] arrayB = new byte[ITEMS];
    private static final byte[] arrayC = new byte[ITEMS];
    private static final byte[] arrayD = new byte[ITEMS];
    private static final byte[] arrayE = new byte[ITEMS];
    private static final byte[] arrayF = new byte[ITEMS];

    public static void main(String[] args) {
        for(int i = 0;i<=3;i++){
            System.out.println("caseOne=" + caseOne());
            System.out.println("caseTwo=" + caseTwo());
        }

    }

    public static long caseOne(){
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0){
            int slot = i & MASK;
            byte b = (byte)i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
        }

        return System.nanoTime() - start;
    }
    public static long caseTwo(){
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0){
            int slot = i & MASK;
            byte b = (byte)i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;

        }
        i = ITERATIONS;
        while (--i != 0){
            int slot = i & MASK;
            byte b = (byte)i;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
