package edu.unl.ed.grafosponderados;
import java.util.*;

public class GrafoPonderado {
    private int numNodos;
    private List<List<Arista>> adyacencia;  // Lista de listas de aristas

    public static class Arista {
        int destino;
        int peso;

        Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public GrafoPonderado(int numNodos) {
        this.numNodos = numNodos;
        this.adyacencia = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
    }

    public List<Arista> getVecinos(int nodo) {
        return adyacencia.get(nodo);
    }

    public int getNumNodos() { return numNodos; }
}
