package com.algoritmos;

import java.time.Instant;
import java.util.Random;

import static java.lang.Integer.max;

/*
* */
public class Exercicio3 {
    private static int iteracoes;

    private static int maxVal2(int A[], int init, int end) {
        iteracoes++;
        if (end - init <= 1) {
            return max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            int v1 = maxVal2(A, init, m);
            int v2 = maxVal2(A, m + 1, end);
            return max(v1, v2);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        final int SIZE = 1000000;
        int[] unsortedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            unsortedArray[i] = random.nextInt(100);
        }

        long startTime = Instant.now().toEpochMilli();

        int maxValue = maxVal2(unsortedArray, 0, unsortedArray.length - 1);
        long endTime = Instant.now().toEpochMilli();
        System.out.println(maxValue);
        long timeElapsed = endTime - startTime;

        System.out.println("Tempo de execução: " + timeElapsed + " Milissegundos");
        System.out.println("Numero de iterações: " + iteracoes);
    }
}