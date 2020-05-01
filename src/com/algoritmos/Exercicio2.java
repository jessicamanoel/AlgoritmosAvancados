package com.algoritmos;

import java.time.Instant;
import java.util.Random;

/*
* O algoritmo a seguir (que não utiliza divisão-e-conquista) encontra o maior valor em um vetor.
* Assim, novamente:
* implemente o algortimo abaixo;
* teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048
* e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
*       int maxVal1(int A[], int n) {
*           int max = A[0];
*           for (int i = 1; i < n; i++) {
*               if( A[i] > max )
*               max = A[i];
*           }
*           return max;
*       }
*/

public class Exercicio2 {
    private static int iteracoes;

    private static int maxVal1(int[] A, int n) {
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            iteracoes++;
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        final int SIZE = 32;
        int[] unsortedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            unsortedArray[i] = random.nextInt(100);
        }

        long startTime = Instant.now().toEpochMilli();

        int maxValue = maxVal1(unsortedArray, unsortedArray.length);
        long endTime = Instant.now().toEpochMilli();
        System.out.println(maxValue);
        long timeElapsed = endTime - startTime;

        System.out.println("Tempo de execução: " + timeElapsed + " Milissegundos");
        System.out.println("Numero de iterações: " + iteracoes);
    }
}