package com.company;

public class Uploader extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Загружаем файл на сервер");
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                sleep(1000);
            } System.out.println("\n Файл загружен на сервер");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

