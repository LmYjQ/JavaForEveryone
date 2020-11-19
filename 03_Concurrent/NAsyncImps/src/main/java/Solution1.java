/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.*;

public class Solution1 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 线程池submit提交Callable接口实现类的实例
        Future<Integer> f = pool.submit(
                Fibo::sum
        );
        pool.shutdown();

        int result = 0;
        try {
            result = f.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

}
