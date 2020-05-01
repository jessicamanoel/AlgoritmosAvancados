package com.algoritmos;

import java.time.Instant;
import java.util.Random;

import static java.lang.Integer.max;

/*
* O algoritmo a seguir (que utiliza divisão-e-conquista) encontra o maior valor em um vetor.
* Assim, novamente:
* implemente o algortimo abaixo;
* teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576.
* Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
*           int maxVal2(int A[], int init, int end) {
*               if (end - init <= 1)
*                   return max(A[init], A[end]);
*               else {
*                   int m = (init + end)/2;
*                   int v1 = maxVal2(A,init,m);
*                   int v2 = maxVal2(A,m+1,end);
*                   return max(v1,v2);
*               }
}*/
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
        final int SIZE = 32;
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