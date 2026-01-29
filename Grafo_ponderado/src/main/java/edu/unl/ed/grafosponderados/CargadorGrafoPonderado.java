package edu.unl.ed.grafosponderados;

import java.io.BufferedReader;
import java.io.FileReader;

public class CargadorGrafoPonderado {
    public static GrafoPonderado desdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String[] primeraLinea = br.readLine().trim().split(" ");
            int n = Integer.parseInt(primeraLinea[0]);  // nodos
            int m = Integer.parseInt(primeraLinea[1]);  // aristas

            GrafoPonderado grafo = new GrafoPonderado(n);

            for (int i = 0; i < m; i++) {
                String[] arista = br.readLine().trim().split(" ");
                int u = Integer.parseInt(arista[0]);
                int v = Integer.parseInt(arista[1]);
                int w = Integer.parseInt(arista[2]);
                grafo.agregarArista(u, v, w);
            }

            return grafo;

        } catch (Exception e) {
            throw new RuntimeException("Error cargando grafo: " + e.getMessage());
        }
    }
}
