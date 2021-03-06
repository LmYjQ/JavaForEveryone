package common;

/**
 * @author Dongfanger
 * @date 2020/11/19
 */

public class Fibo {
    public static int sum() {
        return fibo(36);
    }

    public static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
