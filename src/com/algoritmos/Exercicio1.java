package com.algoritmos;

import java.time.Instant;
import java.util.*;

/*
 * Vamos começar com um algorítmo já estudado e conhecido (em AEDI).
 * O Merge Sort é um algorítmo de ordenação baseado nos seguintes passos:
 * recursivamente ordene a metade esquerda do vetor
 * recursivamente ordene a metade direita do vetor
 * mescle (faça o merge) das duas metades para ter o vetor ordenado.
 * Assim:
 * implemente o algortimo abaixo;
 * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576.
 * Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
 * MERGE-SORT(L: List with n elements) : Ordered list with n elements
 *       IF (list L has one element)
 *           RETURN L.
 *       Divide the list into two halves A and B.
 *       A ← MERGE-SORT(A).
 *       B ← MERGE-SORT(B).
 *       L ← MERGE(A, B).
 *       RETURN L.
 */
public class Exercicio1 {
    private static int iteracoes;

    public static List<Integer> mergeSort(List<Integer> lista, int start, int end) {
        if (start < end && (end - start) >= 1) {
            int mid = (end + start) / 2;
            mergeSort(lista, start, mid);
            mergeSort(lista, mid + 1, end);

            merge(lista, start, mid, end);
        }
        iteracoes++;
        return lista;
    }

    public static void merge(List<Integer> lista, int start, int mid, int end) {

        ArrayList<Integer> listaSorteada = new ArrayList<>();

        int firstHalf = start;
        int secondHalf = mid + 1;

        while (firstHalf <= mid && secondHalf <= end) {
            if (lista.get(firstHalf) <= lista.get(secondHalf)) {
                listaSorteada.add(lista.get(firstHalf));
                firstHalf++;
            } else {
                listaSorteada.add(lista.get(secondHalf));
                secondHalf++;
            }
        }

        //Either of below while loop will execute
        while (firstHalf <= mid) {
            listaSorteada.add(lista.get(firstHalf));
            firstHalf++;
        }

        while (secondHalf <= end) {
            listaSorteada.add(lista.get(secondHalf));
            secondHalf++;
        }

        int i = 0;
        int j = start;
        while (i < listaSorteada.size()) {
            lista.set(j, listaSorteada.get(i++));
            j++;
        }
    }

    public static void main(String[] args) {
        List<Integer> unsortedArray = new ArrayList<>();
        for (int i = 0; i < 32; i++) unsortedArray.add(i);
        Collections.shuffle(unsortedArray);

        System.out.println("---------Initial Unsorted Array---------");
        unsortedArray.forEach(System.out::println);
        System.out.println("\n------------Sorted Array------------");
        long startTime = Instant.now().toEpochMilli();
        mergeSort(unsortedArray, 0, unsortedArray.size() - 1).forEach(System.out::println);
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - startTime;
        System.out.println("Tempo de execução: " + timeElapsed);
        System.out.println("Numero de iterações: " + iteracoes);
    }
}
