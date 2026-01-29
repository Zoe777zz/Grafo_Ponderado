package edu.unl.ed.grafosponderados;

import java.util.*;

public class Dijkstra {
    public static class Resultado {
        int[] distancias;
        int[] prev;

        Resultado(int[] distancias, int[] prev) {
            this.distancias = distancias;
            this.prev = prev;
        }
    }

    public static Resultado desdeNodo(GrafoPonderado grafo, int origen) {
        int n = grafo.getNumNodos();
        int[] dist = new int[n];
        int[] prev = new int[n];
        PriorityQueue<NodoDijkstra> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.dist, b.dist)
        );

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origen] = 0;
        prev[origen] = -1;

        pq.add(new NodoDijkstra(origen, 0));

        while (!pq.isEmpty()) {
            NodoDijkstra actual = pq.poll();
            int u = actual.nodo;

            if (actual.dist > dist[u]) continue;

            for (GrafoPonderado.Arista arista : grafo.getVecinos(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                int nuevaDist = dist[u] + peso;

                if (nuevaDist < dist[v]) {
                    dist[v] = nuevaDist;
                    prev[v] = u;
                    pq.add(new NodoDijkstra(v, nuevaDist));
                }
            }
        }

        return new Resultado(dist, prev);
    }

    private static class NodoDijkstra {
        int nodo, dist;
        NodoDijkstra(int nodo, int dist) {
            this.nodo = nodo;
            this.dist = dist;
        }
    }
}
