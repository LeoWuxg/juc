package com.leo.juc.jmm;

import sun.misc.Unsafe;

/**
 * @className VisibilityTest
 * @author leoWu
 * @description 测试 JMM 可见性
 * @createDate 2021-10-28 23:36:55
 */
public class VisibilityTest {
    private boolean flag = true;
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest test = new VisibilityTest();
        Thread threadA = new Thread(test::working, "threadA");
        threadA.start();

        Thread.sleep(1000);

        Thread threadB = new Thread(test::updateFlag, "threadB");
        threadB.start();
    }

    public void working() {
        System.out.println(Thread.currentThread().getName() + "开始工作...");
        while (flag) {
            //业务逻辑
            count++;

//            Unsafe.getUnsafe().storeFence();
            Thread.yield();
            //volatile flag
            //Integer count
//            System.out.println();

        }
        System.out.println(Thread.currentThread().getName() + "跳出循环, count=" + count);
    }

    public void updateFlag() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag:" + flag);
    }
}
