/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ikerlan.loom;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.SplittableRandom;

/**
 *
 * @author aconde
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // A ThreadFactory that creates virtual threads
        var factory = Thread.ofVirtual().factory();
        int numberThreads = 2000000;
        SplittableRandom gene = new SplittableRandom();
        var threadList = new ArrayList<Thread>();

        for (int i = 0; i < numberThreads; i++) {
            var th = factory.newThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //simulate IO/Wait on thread
                        TimeUnit.SECONDS.sleep(gene.nextInt(20));
                        System.out.println("Thread id: " + Thread.currentThread().getId() + " finished computation");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            threadList.add(th);
            th.start();
        }
        // Join all the threads
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
