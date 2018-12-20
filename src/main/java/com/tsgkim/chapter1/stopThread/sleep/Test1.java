package com.tsgkim.chapter1.stopThread.sleep;

import me.andpay.ti.test.mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class Test1 {

    @Test
    public void myTest() {

        Thread thread = new Thread(() -> {

            try {

                System.out.println("1111");

                Thread.sleep(5000);

                System.out.println("222");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }


}
