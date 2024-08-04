package org.example.lesson23.hm;

//1. Создать класс MyRunnable который
//a. принимает на вход список строк
//b. распечатывает каждый элемент и ждет одну секунду перед распечатыванием следующего элемента
//c. создать и запустить поток, принимающий экземпляр этого Runnable с произвольным списком

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MyRunnable implements Runnable {
    private List<String> list;

    @Override
    public void run() {
        for (String s : list) {
            System.out.println(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d", "e", "f", "g", "h");
        MyRunnable myRunnable = new MyRunnable(list);
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
