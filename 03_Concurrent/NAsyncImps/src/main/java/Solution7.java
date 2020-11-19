/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
方案7 启动新线程计算结果，用Condition条件变量控制两个线程同步
 */

public class Solution7 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        Condition calcFinish = lock.newCondition();
        int[] result = new int[1];

        new Thread( () -> { lock.lock(); result[0] = Fibo.sum(); calcFinish.signal(); lock.unlock(); } ).start();
        // lock需要紧跟try/catch代码块，并且unlock在finally第一行
        lock.lock();
        try {
            calcFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println("异步计算结果为："+ result[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }}
