package TP5.EJ4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaminoMayor<T> {
    /*
     Grafo aciclico
     No haber ciclos no deberia ocurrir que un camino vuelva a pasar por un vertice ya recorrido
     DFS recursivo
     vertice actual pruebo cada adyacente y busco  recursivamente el camino
     mas largo desde ese adyacente hasta el destino
     */
    public List<Integer> caminoMayorLongitud(Grafo<T> grafo, int origen, int destino) {
        //Si un vertice no existe no hay camino
        if (!grafo.contieneVertice(origen) || !grafo.contieneVertice(destino)) {
            return new ArrayList<Integer>();
        }
        return caminoMayorLongitudDesde(grafo, origen, destino);
    }

    private List<Integer> caminoMayorLongitudDesde(Grafo<T> grafo, int actual, int destino) {
        /*
          Si el vertice actual es el destino entonces hay un camino
          El camino desde destino hasta destino es una lista que contiene solo ese vertice
         */
        if (actual == destino) {
            List<Integer> camino = new ArrayList<Integer>();
            camino.add(actual);
            return camino;
        }
        //guardar el mejor camino desde algun adyacente hasta el destino
        List<Integer> mejorCamino = new ArrayList<Integer>();
        /*
          Recorro todos los adyacentes del vertice actual
          grafo dirigido son los vertices a los que puedo llegar desde actual usando un solo arco
         */
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
             // Busco recursivamente el camino mas largo desde el adyacente hasta el destino
            List<Integer> caminoDesdeAdyacente = caminoMayorLongitudDesde(grafo, adyacente, destino);

            /*
             Si esta vacio no se pudo llegar al destino
             Si no esta vacio hay un camino
             entonces comparo con el mejor camino
             */
            if (!caminoDesdeAdyacente.isEmpty() && caminoDesdeAdyacente.size() > mejorCamino.size()) {
                mejorCamino = caminoDesdeAdyacente;
            }
        }

        // Si  quedo vacio  desde el vertice actual no hay forma de llegar al destino
        if (mejorCamino.isEmpty()) {
            return new ArrayList<Integer>();
        }

        /*
         * Si encontre un camino desde algun adyacente hasta el destino
         * entonces agrego el vertice actual al principio
         * actual = 1
         * mejorCamino = [3, 5, 7]
         * Resultado:
         * [1, 3, 5, 7]
         */
        List<Integer> resultado = new ArrayList<Integer>();
        resultado.add(actual);
        resultado.addAll(mejorCamino);
        return resultado;
    }
}
