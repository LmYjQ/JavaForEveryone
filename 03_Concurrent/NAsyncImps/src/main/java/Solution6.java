/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.LinkedBlockingQueue;

/*
方案6 启动新线程计算结果，用LinkedBlockingQueue传递计算结果，新线程计算
完成之前主线程阻塞在LinkedBlockingQueue获取数据的方法上
 */

public class Solution6 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        LinkedBlockingQueue<Integer> que = new LinkedBlockingQueue<Integer>();
        new Thread( () -> {
            try {
                que.put(Fibo.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ).start();


        int result = 0;
        try {
            result = que.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
