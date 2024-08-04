package org.example.lesson23.hm;

//2. Создайте класс HomeWorkThreads
//a создайте в нем два целых статических поля result1 и result2
//b. создайте в нем метод public static int waitSomeTime который
//     спит рандомное время от 0 до 1000 мс и
//     возвращает это время в качестве результата
//c. Создайте и запустите два потока, каждый из которых выполняет метод waitSomeTime и
//     первый сохраняет результат в поле поля result1
//     второй сохраняет результат в поле поля result2
//d. В методе main дождитесь окончания работы потоков (join()) и
//     распечатайте сумму result1 и result2

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkThreads {
    static int result1;
    static int result2;

    public static int waitSomeTime() {
        int randomTime = ThreadLocalRandom.current().nextInt(1000);

        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return randomTime;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> result1 = waitSomeTime());
        Thread t2 = new Thread(() -> result2 = waitSomeTime());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int sum = result1 + result2;
        System.out.println("Result1: " + result1 + "ms");
        System.out.println("Result2: " + result2 + "ms");
        System.out.println("Sum: " + sum + "ms");
    }
}
