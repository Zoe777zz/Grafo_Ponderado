package edu.unl.ed.grafosponderados;

public class MainDemo {
    public static void main(String[] args) {
        String ruta = "Archivos/grafo_ponderado_dijkstra_10n.txt";

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ALGORITMO DE DIJKSTRA                       ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║      Archivo: " + ruta + "                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");


        GrafoPonderado grafo = CargadorGrafoPonderado.desdeArchivo(ruta);

        // Dijkstra desde nodo 0
        Dijkstra.Resultado resultado = Dijkstra.desdeNodo(grafo, 0);

        System.out.println("┌─ DISTANCIAS MÍNIMAS DESDE NODO 0 ──────────────────────────────┐");
        System.out.printf("| %-2s | %-8s | %-8s |%n", "Nodo", "Distancia", "Camino");
        System.out.println("|────|──────────|──────────|");
        for (int i = 0; i < 10; i++) {
            String camino = reconstruirCamino(resultado.prev, i);
            System.out.printf("| %2d | %8d | %8s |%n",
                    i, resultado.distancias[i], camino);
        }
        System.out.println("└────────────────────────────────────────────────────────────────┘\n");

        System.out.println(" DIJKSTRA COMPLETADO CORRECTAMENTE");
    }

    private static String reconstruirCamino(int[] prev, int destino) {
        if (prev[destino] == -1 && destino != 0) return "∞";
        if (destino == 0) return "-";

        StringBuilder sb = new StringBuilder();
        int actual = destino;
        while (actual != -1) {
            sb.insert(0, actual + " ");
            actual = prev[actual];
        }
        return sb.reverse().toString().trim();
    }
}
