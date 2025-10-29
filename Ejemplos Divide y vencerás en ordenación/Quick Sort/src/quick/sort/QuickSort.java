/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quick.sort;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {45, 12, 78, 23, 56, 10};
        quickSort(A);
        
        System.out.println("Ordenados (QuickSort):");
        for (int num : A) System.out.print(num + " ");
    }

    static void quickSort(int[] A) {
        // Si el tamaño del arreglo es 1 o menor, no se ordena
        if (A.length <= 1) return;

        // P = elegir pivote (el elemento central)
        int P = A[A.length / 2];

        // Crear listas L, E y G
        List<Integer> L = new ArrayList<>(); // menores que P
        List<Integer> E = new ArrayList<>(); // iguales a P
        List<Integer> G = new ArrayList<>(); // mayores que P

        // Clasificar elementos en las tres listas
        for (int num : A) {
            if (num < P) L.add(num);
            else if (num > P) G.add(num);
            else E.add(num);
        }

        // QuickSort(L) y QuickSort(G)
        int[] Larr = L.stream().mapToInt(i -> i).toArray();
        int[] Garr = G.stream().mapToInt(i -> i).toArray();
        quickSort(Larr);
        quickSort(Garr);

        // A = concatenar(L, E, G)
        int index = 0;
        for (int num : Larr) A[index++] = num;
        for (int num : E) A[index++] = num;
        for (int num : Garr) A[index++] = num;
    }
}