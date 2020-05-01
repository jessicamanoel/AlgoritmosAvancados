package com.algoritmos;

import java.time.Instant;

/*
* A Multiplicação Inteira de n-bits recebe dois números inteiros x e y de n-bits e retorna o resutado de x * y.
* Assim, novamente:
* implemente o algortimo abaixo;
* teste-o para os 3 casos de valores inteiros: com 4 bits, com 16 bits e com 64 bits. Nestes testes, contabilize
* o número de iterações que o algoritmo executa, e o tempo gasto.
* O algoritmo está dado abaixo:
*           MULTIPLY(x, y, n)
*               IF (n = 1)
*                   RETURN x * y.
*               ELSE
*                   m ← ⎡ n / 2 ⎤.
*                   a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
*                   c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
*                   e ← MULTIPLY(a, c, m).
*                   f ← MULTIPLY(b, d, m).
*                   g ← MULTIPLY(b, c, m).
*                   h ← MULTIPLY(a, d, m).
*                   RETURN 2^(2m)*e + 2^m*(g + h) + f.
*
* Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).
*/

public class Exercicio4 {

    private static int iteracoes;

    private static long multiply(long x, long y, long n) {
        iteracoes++;
        if (n == 1) {
            return x * y;
        }

        long m = n / 2;
        long a = (long) (x / Math.pow(2, m)), b = (long) (x % Math.pow(2, m));
        long c = (long) (y / Math.pow(2, m)), d = (long) (y % Math.pow(2, m));
        long e = multiply(a, c, m);
        long f = multiply(b, d, m);
        long g = multiply(b, c, m);
        long h = multiply(a, d, m);
        return (long) (Math.pow(2, 2 * m) * e + Math.pow(2, m) * (g + h) + f);
    }

    public static void main(String[] args) {
        long startTime = Instant.now().toEpochMilli();
        long resultado = multiply(100, 2, 4);
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - startTime;

        System.out.println("Resultado: " + resultado);
        System.out.println("Tempo de execução: " + timeElapsed + " Milissegundos");
        System.out.println("Numero de iterações: " + iteracoes);
    }
}