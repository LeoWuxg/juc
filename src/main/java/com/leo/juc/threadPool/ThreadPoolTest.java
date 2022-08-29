package com.leo.juc.threadPool;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolTest
 * @Author leoWu
 * @Description TODO
 * @CreateDate 2021-11-03 20:40:15
 */
public class ThreadPoolTest {
    //自定义线程池
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
}
