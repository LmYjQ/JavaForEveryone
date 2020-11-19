/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.CountDownLatch;


public class Solution9 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(1);
        int[] result = new int[1];

        new Thread( () -> { result[0] = Fibo.sum(); latch.countDown(); } ).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+ result[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }}
