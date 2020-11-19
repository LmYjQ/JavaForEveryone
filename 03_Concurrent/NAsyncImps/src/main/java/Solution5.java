/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.Semaphore;

public class Solution5 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Semaphore s = new Semaphore(0);

        int[] result = new int[1];
        new Thread(() -> {
            result[0] = Fibo.sum();
            s.release();
        }).start();
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}