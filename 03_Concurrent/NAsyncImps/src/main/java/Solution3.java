import common.Fibo;

/**
 * @author Dongfanger
 * @date 2020/11/19
 */

public class Solution3 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        /** 这里result如果只用一个int值，会提示lambda表达式中的变量必须是final或者和final等效
         * Variable used in lambda expression should be final or effectively final
         * idea自动提示两种解决方案：
         * 1. result变成atomic
         * 2. result变成final一维数组
         */
        final int[] result = new int[1];
        Thread t = new Thread(() -> result[0] = Fibo.sum());
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}