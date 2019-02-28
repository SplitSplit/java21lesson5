package ru.ponomaryov.se;

public class ThreadsLauncher {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        System.out.println("Method One start");
        try {
            methodOne();
        } catch (InterruptedException e) {
        }
        System.out.println("Method Two start");
        try {
            methodTwo();
        } catch (InterruptedException e) {
        }
    }

    private static void methodOne() throws InterruptedException {
        float[] arr = new float[size];
        CalculateThread threadOne = new CalculateThread(arr);
        long a = System.currentTimeMillis();
        threadOne.start();
        while (threadOne.isAlive()) {
        }
        System.out.println("Method One time: " + (System.currentTimeMillis() - a) / 1000.0);
    }

    private static void methodTwo() throws InterruptedException {
        float[] arr = new float[size];
        float[] a1 = new float[size / 2];
        float[] a2 = new float[size / 2];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        CalculateThread threadOne = new CalculateThread(a1);
        CalculateThread threadTwo = new CalculateThread(a2);

        threadOne.start();
        threadTwo.start();

        while (threadOne.isAlive() || threadTwo.isAlive()) {
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Method Two time: " + (System.currentTimeMillis() - a) / 1000.0);
    }
}
