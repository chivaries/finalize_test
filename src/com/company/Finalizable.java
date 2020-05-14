package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Finalizable {
    static AtomicInteger aliveCount = new AtomicInteger(0);

    Finalizable() {
        aliveCount.incrementAndGet();
    }

//    @Override
//    protected void finalize() throws Throwable {
//        Finalizable.aliveCount.decrementAndGet();
//    }

    public static void main(String[] args) throws Exception {
        //Thread.sleep(10000);
        int j = 0;
        for (int i = 0;; i++) {

            if ((i % 100_000) == 0) {
                Finalizable f = new Finalizable();
                j++;
                System.out.format("After creating %d objects, %d are still alive.%n", new Object[] {j, Finalizable.aliveCount.get() });
            }
        }
    }
}
