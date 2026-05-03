package TP5.EJ5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QueVerticeLlega <T>{

    public List<Integer> obtenerVerticesQueLleganA(Grafo<T> grafo, int destino) {
        List<Integer> resultado = new ArrayList<Integer>();
        //sino existe el vertice no existe no hay caminos posibles
        if (!grafo.contieneVertice(destino)) {
            return resultado;
        }

        //recorrer todos los vertices del grafo
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer origen = vertices.next();
            //crear un set para cada busqueda
            //DFS empieza desde un origen distinto
            Set<Integer> visitados = new HashSet<Integer>();
            //verificar si existe camino de origen al destino
            if (existeCamino(grafo, origen, destino, visitados)) {
                resultado.add(origen);
            }
        }
        return resultado;
    }

    /*
     * Metodo auxiliar recursivo.
     *
     * Devuelve true si existe un camino desde actual hasta destino.
     * Devuelve false si no existe.
     */
    private boolean existeCamino(Grafo<T> grafo, int actual, int destino, Set<Integer> visitados) {
         // Si el vertice actual es el destino entonces existe camino
         // Si estoy buscando llegar a 5 y actual == 5
         // ya encontre un camino que termina en destino
        if (actual == destino) {
            return true;
        }

        //marcar el vertice como visitado
        //evitar ciclo infinito
        visitados.add(actual);

        //recorrer adyacentes al vertice
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            //si no fue visitado, entonces busco camino desde el adyacente al destino
            if (!visitados.contains(adyacente)) {
                //si encontre un adyacente que llego adestino
                //entonces desde el vertice actual puedo llegar
                if (existeCamino(grafo, adyacente, destino, visitados)) {
                    return true;
                }
            }
        }
        //si ningun adyacente pudo llegar al destino, entonces no hay camino
        return false;
    }
}
