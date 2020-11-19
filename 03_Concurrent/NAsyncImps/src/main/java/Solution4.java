/**
 * @author Dongfanger
 * @date 2020/11/19
 */

import common.Fibo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Solution4 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int result = 0;
        try {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Fibo::sum);
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}