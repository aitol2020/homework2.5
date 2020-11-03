package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Uploader uploader = new Uploader();
        uploader.start();
        uploader.join();
        Semaphore semaphore = new Semaphore(3);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= countDownLatch.getCount(); i++) {
            new DownLoaders(i, semaphore, countDownLatch).start();
        }
        countDownLatch.await();
        System.out.println("Файл удвлен с сервера");

    }
}
