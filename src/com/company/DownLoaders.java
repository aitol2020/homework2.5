package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DownLoaders extends Thread {
    private int num;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public DownLoaders(int num, Semaphore semaphore, CountDownLatch countDownLatch) {
        this.num = num;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        super.run();
        try {
            semaphore.acquire();
            System.out.println("Юзер " + num + "скачивает файл");
            sleep(1000);
            System.out.println("Юзер " + num + " скачал файл");
            semaphore.release();
            sleep(1000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
