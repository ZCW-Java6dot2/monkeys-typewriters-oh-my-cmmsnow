package io.zipcoder;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        SafeCopier safeCopier = new SafeCopier(introduction);

        Thread[] unsafeMonkeys = new Thread[5];
        for (int i=0; i<5; i++){
            unsafeMonkeys[i] = new Thread(unsafeCopier);
            unsafeMonkeys[i].start();
        }

        Thread[] safeMonkeys = new Thread[5];
        for (int i=0; i<5; i++){
            safeMonkeys[i] = new Thread(safeCopier);
            safeMonkeys[i].start();
        }

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
            //in youtube he printed here
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        System.out.println("Unsafe copy:\n" + unsafeCopier.copied + "\n");
        System.out.println("Safe copy:\n" + safeCopier.copied + "\n");
    }
}