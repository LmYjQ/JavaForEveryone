/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.Exchanger;

public class Solution10 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread( () -> {
            try {
                exchanger.exchange(Fibo.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ).start();

        int result = 0;
        try {
            result = exchanger.exchange(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }}
