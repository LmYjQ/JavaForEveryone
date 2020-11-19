/**
 * @author Dongfanger
 * @date 2020/11/19
 */

/*
方案2 线程池submit FutureTask对象，主线程用FutureTask的get方法获取结果
 */

import common.Fibo;

import java.util.concurrent.*;

public class Solution2 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        FutureTask<Integer> ft = new FutureTask<>(Fibo::sum);

        pool.submit(ft);
        pool.shutdown();

        int result = 0;
        try {
            result = ft.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

}

