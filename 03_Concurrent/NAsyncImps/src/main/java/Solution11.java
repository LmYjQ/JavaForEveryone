import common.Fibo;

/**
 * @author Dongfanger
 * @date 2020/11/19
 */

public class Solution11 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] result = new int[1];
        new Thread( () -> { synchronized (Solution11.class) { result[0] = Fibo.sum(); Solution11.class.notify(); } } ).start();

        try {
            synchronized (Solution11.class) {
                Solution11.class.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+ result[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }}
