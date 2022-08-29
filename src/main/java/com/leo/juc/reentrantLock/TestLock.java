package com.leo.juc.reentrantLock;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("t1----start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("t1----end");
        }, "t1");

        Thread t2 = new Thread(() -> {
            log.debug("t2----start");
        }, "t2");

        t1.start();
        t2.start();
    }
}
