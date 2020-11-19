import common.Fibo;

/**
 * @author Dongfanger
 * @date 2020/11/19
 */

public class Solution12 {

    private static int result = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法


        Runnable runnable = () -> {
            result = Fibo.sum(); //这是得到的返回值
        };
        Thread thread = new Thread(runnable);
        thread.start();
        while (Thread.activeCount()>2){//当前线程的线程组中的数量>2
            Thread.yield();
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }}
