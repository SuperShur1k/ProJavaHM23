package org.example.lesson23.hm;

//3. Создайте класс AtomicTester
//a. создайте в нем статическое поле counter типа AtomicInteger со значением 10
//b. создайте в нем статический метод decrease5 который принимает на вход AtomicInteger и
//    пять раз уменьшает его (decrementAndGet)
//c. Создайте и запустите два потока, каждый из которых выполняет метод decrease5 передавая туда counter
//d. В методе main дождитесь окончания работы потоков (join()) и
//     распечатайте значение counter

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTester {
    // a. Статическое поле counter типа AtomicInteger со значением 10
    static AtomicInteger counter = new AtomicInteger(10);

    // b. Статический метод decrease5, который принимает на вход AtomicInteger и пять раз уменьшает его
    public static void decrease5(AtomicInteger counter) {
        for (int i = 0; i < 5; i++) {
            counter.decrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Counter: " + counter);
        // c. Создаем и запускаем два потока, каждый из которых выполняет метод decrease5, передавая туда counter
        Thread thread1 = new Thread(() -> decrease5(counter));
        Thread thread2 = new Thread(() -> decrease5(counter));

        thread1.start();
        thread2.start();

        // d. Дожидаемся окончания работы потоков и распечатываем значение counter
        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + counter);
    }
}