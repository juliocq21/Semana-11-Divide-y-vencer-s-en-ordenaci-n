/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shellsort;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] A = {45, 12, 78, 23, 56, 10};
        int n = A.length;
        int h = 1;

        // Generar secuencia de Knuth: 1, 4, 13, 40, ...
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        // Ordenamiento Shell
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i;
                int temp = A[i];
                while (j >= h && A[j - h] > temp) {
                    A[j] = A[j - h];
                    j -= h;
                }
                A[j] = temp;
            }
            h = h / 3; // Reducir intervalo
        }

        System.out.println("Ordenados (ShellSort):");
        for (int num : A) System.out.print(num + " ");
    }
}
