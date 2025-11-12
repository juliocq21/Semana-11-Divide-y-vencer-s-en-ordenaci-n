/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demostradorrecursividad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemostradorRecursividad extends JFrame {

    private JTextArea areaTexto;

    public DemostradorRecursividad() {
        setTitle("🧩 Demostrador de Recursividad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Área de texto para mostrar resultados ---
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // --- Panel con botones ---
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton btnFactorial = new JButton("Factorial Recursivo");
        JButton btnIndirecta = new JButton("Recursividad Indirecta");
        JButton btnBacktracking = new JButton("Backtracking");
        JButton btnComparacion = new JButton("Recursión vs Iteración");

        panelBotones.add(btnFactorial);
        panelBotones.add(btnIndirecta);
        panelBotones.add(btnBacktracking);
        panelBotones.add(btnComparacion);

        add(panelBotones, BorderLayout.SOUTH);

        // --- Acciones de cada botón ---
        btnFactorial.addActionListener(e -> mostrarFactorial());
        btnIndirecta.addActionListener(e -> mostrarRecursividadIndirecta());
        btnBacktracking.addActionListener(e -> mostrarBacktracking());
        btnComparacion.addActionListener(e -> mostrarComparacion());
    }

    // ===== 1️⃣ Factorial recursivo =====
    private void mostrarFactorial() {
        String input = JOptionPane.showInputDialog(this, "Ingresa un número:");
        try {
            int n = Integer.parseInt(input);
            areaTexto.setText("🧮 Cálculo del factorial de " + n + ":\n\n");
            long resultado = factorial(n);
            areaTexto.append("\nResultado final: " + resultado);
        } catch (Exception e) {
            areaTexto.setText("Por favor, ingresa un número válido.");
        }
    }

    private long factorial(int n) {
        areaTexto.append("factorial(" + n + ") llamado...\n");
        if (n <= 1) {
            areaTexto.append("→ Caso base alcanzado: factorial(" + n + ") = 1\n");
            return 1;
        } else {
            long resultado = n * factorial(n - 1);
            areaTexto.append("↩ factorial(" + n + ") = " + n + " * factorial(" + (n - 1) + ") = " + resultado + "\n");
            return resultado;
        }
    }

    // ===== 2️⃣ Recursividad indirecta =====
    private void mostrarRecursividadIndirecta() {
        areaTexto.setText("🔁 Ejemplo de recursividad indirecta:\n\n");
        funcionA(3);
    }

    private void funcionA(int n) {
        if (n > 0) {
            areaTexto.append("Función A con n = " + n + "\n");
            funcionB(n - 1);
        }
    }

    private void funcionB(int n) {
        if (n > 0) {
            areaTexto.append("Función B con n = " + n + "\n");
            funcionA(n - 1);
        }
    }

    // ===== 3️⃣ Backtracking (laberinto 4x4) =====
    private void mostrarBacktracking() {
        areaTexto.setText("🏁 Ejemplo de backtracking (laberinto 4x4):\n\n");
        int[][] lab = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        resolverLaberinto(lab, 0, 0);
    }

    private boolean resolverLaberinto(int[][] lab, int x, int y) {
        int n = lab.length;

        // Caso base: llegada
        if (x == n - 1 && y == n - 1) {
            areaTexto.append("✔ Llegó a la meta (" + x + "," + y + ")\n");
            return true;
        }

        // Movimiento válido
        if (x >= 0 && y >= 0 && x < n && y < n && lab[x][y] == 1) {
            areaTexto.append("Visitando (" + x + "," + y + ")\n");
            lab[x][y] = 0; // marca como visitado

            if (resolverLaberinto(lab, x + 1, y)) return true;
            if (resolverLaberinto(lab, x, y + 1)) return true;

            areaTexto.append("⤴ Retroceso desde (" + x + "," + y + ")\n");
            lab[x][y] = 1; // backtrack
        }
        return false;
    }

    // ===== 4️⃣ Comparación Recursión vs Iteración =====
    private void mostrarComparacion() {
        String input = JOptionPane.showInputDialog(this, "Ingresa un número:");
        try {
            int n = Integer.parseInt(input);
            long inicioRec = System.nanoTime();
            factorial(n);
            long finRec = System.nanoTime();

            long inicioIt = System.nanoTime();
            long resIt = factorialIterativo(n);
            long finIt = System.nanoTime();

            areaTexto.setText("⚖ Comparación Recursión vs Iteración (n=" + n + ")\n\n");
            areaTexto.append("Recursivo: " + (finRec - inicioRec) + " ns\n");
            areaTexto.append("Iterativo: " + (finIt - inicioIt) + " ns\n");
            areaTexto.append("Resultado iterativo: " + resIt + "\n\n");
            areaTexto.append("🧠 Observa que la recursión usa más memoria (pila de llamadas).");
        } catch (Exception e) {
            areaTexto.setText("Número inválido.");
        }
    }

    private long factorialIterativo(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DemostradorRecursividad().setVisible(true));
    }
}

