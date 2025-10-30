/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busquedalineal;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class BusquedaLineal {

    public static int busquedaLineal(int[] arreglo, int valor) {
        System.out.println("Buscando " + valor + " en la lista...");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Comparando con " + arreglo[i] + " (posicion " + i + ")");
            if (arreglo[i] == valor) {
                System.out.println("Encontrado en la posicion " + i);
                return i; // Devuelve la posición
            }
        }
        System.out.println("No se encontró el valor.");
        return -1; // No encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {8, 3, 12, 5, 7, 1, 9};
        busquedaLineal(numeros, 7);
    }
}