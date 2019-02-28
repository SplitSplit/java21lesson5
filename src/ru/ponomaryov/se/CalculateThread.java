package ru.ponomaryov.se;

public class CalculateThread extends Thread {

    private float[] arr;

    CalculateThread(float[] array) {
        this.arr = array;
    }

    @Override
    public void run() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            i++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }
}
