package TP5.EJ2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Recorrido <T>{

    private static final String BLANCO = "BLANCO"; //no visitado
    private static final String AMARILLO = "AMARILLO"; //descubierto, por procesarse
    private static final String NEGRO = "NEGRO"; //ya procesado

    //DFS -> RECORRIDO EN PROFUNDIDAD
    // 1. MARCAR VERTICE EN BLANCO (LOS NO VISITADOS)
    // 2. RECORRER VERTICES DEL GRAFO
    // 3. SI UN VERTICE ESTA EN BLANCO LLAMAR METODO RECURSIVO EN EL VERTICE
    // RECORRER TODO EL GRAFO PORQUE PUEDE HABER VERTICES NO ALCANZABLES

    public List<Integer> dfs(Grafo<T> grafo) {
        List<Integer> recorrido = new ArrayList<Integer>();
        HashMap<Integer, String> colores = new HashMap<Integer, String>();
        //Poner todos los vertices en blanco
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, BLANCO);
        }
        //Recorro todos los vertices del grafo
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            //Si el vertice es blanco, llamo con metodo recursivo
            if (colores.get(vertice).equals(BLANCO)) {
                dfsVisit(grafo, vertice, colores, recorrido);
            }
        }
        return recorrido;
    }

    private void dfsVisit(Grafo<T> grafo, Integer vertice, HashMap<Integer, String> colores, List<Integer> recorrido) {
        //Pintar el vertice de amarillo
        colores.put(vertice, AMARILLO);
        //Agrego al recorrido
        recorrido.add(vertice);

        //Recorrer adyacentes
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            //Si no esta visitado, llamo al metodo recursivo
            if (colores.get(adyacente).equals(BLANCO)) {
                dfsVisit(grafo, adyacente, colores, recorrido);
            }
        }
        //si ya termine lo marco de negro (ya visitado y procesado)
        colores.put(vertice, NEGRO);
    }


    //BFS -> RECORRIDO EN AMPLITUD
    //Recorrido por niveles o por capas
    //NO es recursivo
    //BFS usa Queue
    //Procesa los vertices en el mismo orden en que fueron descubiertos
    // 1. Marcar todos los vertices como blanco (no visitados)
    // 2. Recorrer todos los vertices del grafo
    // 3. Si un vertice esta en BLANCO iniciar BFS desde ese vertice
    // 4. Marcar el vertice inicial como visitado y agregarlo a la fila
    // 5. Mientras la fila no este vacia:
    //      - Sacar un vertice de la fila
    //      - Recorrer sus adyacentes
    //      - Si un adyacente esta en blanco marcarlo como visitado y agregarlo a la fila
    //
    //Se recorre todo el grafo porque puede haber vertices no alcanzables desde
    //Si queda algun vertice blanco se inicia otro BFS desde ese vertice

    public List<Integer> bfs(Grafo<T> grafo) {
        List<Integer> recorrido = new ArrayList<Integer>();
        HashMap<Integer, String> colores = new HashMap<Integer, String>();
        //Poner todos los vertices en blanco
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, BLANCO);
        }

        //Recorro todos los vertices del grafo
        //Esto permite cubrir tambien grafos no conexos o vertices no alcanzables
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            //si esta en blanco es porque no fue visitado por ningun BFS anterior
            if (colores.get(vertice).equals(BLANCO)) {
                bfsVisit(grafo, vertice, colores, recorrido);
            }
        }
        return recorrido;
    }

    private void bfsVisit(Grafo<T> grafo, Integer vertice, HashMap<Integer, String> colores, List<Integer> recorrido) {
        //Creo la queue que va a usar BFS
        //La fila respeta fifo, el primero que entra es el primero que sale
        Queue<Integer> fila = new LinkedList<Integer>();
        //Marco el vertice inicial como AMARILLO.
        colores.put(vertice, AMARILLO);
        //Agrego el vertice inicial a la queue
        fila.add(vertice);
        //Agrego el vertice al recorrido
        recorrido.add(vertice);
        //Mientras haya vertices pendientes en la queue
        while (!fila.isEmpty()) {
            //Saco el primer vertice de la queue, que voy a procesar
            Integer actual = fila.poll();
            //Obtengo los adyacentes del vertice actual
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            //Recorro todos los adyacentes del vertice actual
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                //Si esta en blanco
                if (colores.get(adyacente).equals(BLANCO)) {
                    //Marcarlo en amarrillo
                    //Evita que otro vertice lo vuelva a agregar a la queue
                    colores.put(adyacente, AMARILLO);
                    //Agrego a la queue
                    fila.add(adyacente);
                    //Agregar al recorrido
                    recorrido.add(adyacente);
                }
            }
            //Marcar negro
            colores.put(actual, NEGRO);
        }
    }
}
