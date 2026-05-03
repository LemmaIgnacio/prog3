package TP5.EJ3;

import java.util.HashMap;
import java.util.Iterator;

public class Ciclo<T> {

    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";

    // DETERMINAR SI UN GRAFO DIRIGIDO TIENE CICLO
    // Usamos DFS con colores

    // En un grafo dirigido hay ciclo si durante el DFS encuentro un adyacente AMARILLO

    // Por que amarrillo representa un vertice que esta en el path actual
    // de la recursion
    // Si desde el vertice actual puedo volver
    // a un vertice amarrillo, significa que encontre un camino cerrado
    //
    // Ejemplo:
    // 1 -> 2 -> 3
    //      ^    |
    //      |____|
    //
    // Si estoy en el 3 y encuentro como adyacente a 2
    // y 2 todavia esta amarillo, entonces hay ciclo

    public boolean tieneCiclo(Grafo<T> grafo) {
        HashMap<Integer, String> colores = new HashMap<Integer, String>();
        //marcar todos como blanco
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, BLANCO);
        }

        // Recorro todos los vertices del grafo
        // NECESARIO porque el grafo podria no ser conexo,
        //no alcanza con iniciar DFS desde un unico vertice.
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (colores.get(vertice).equals(BLANCO)) {
                // Si el DFS desde este vertice encuentra un ciclo
                // retorno true
                if (tieneCicloVisit(grafo, vertice, colores)) {
                    return true;
                }
            }
        }
        // Si termine de recorrer todos los vertices y nunca encuentra
        // un adyacente entonces el grafo no tiene ciclo.
        return false;
    }

    private boolean tieneCicloVisit(Grafo<T> grafo, Integer vertice, HashMap<Integer, String> colores) {
        //Marcar vertice amaruillo
        colores.put(vertice, AMARILLO);

        // Recorro todos los adyacentes del vertice
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (colores.get(adyacente).equals(BLANCO)) {
                // Si en la llamada recursiva se encuentra ciclo
                // propago el true hacia arriba de la pila
                if (tieneCicloVisit(grafo, adyacente, colores)) {
                    return true;
                }
            }
            // Si encuentro un adyacente amarillo, significa que estoy
            // intentando ir hacia un vertice que ya esta activo en el camino actual
            // entonces hay ciclo
            else if (colores.get(adyacente).equals(AMARILLO)) {
                return true;
            }
        }
        // Si termine de procesar todos los adyacentes y no encontre ciclo
        // marco el vertice como negro
        colores.put(vertice, NEGRO);
        return false;
    }
}