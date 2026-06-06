package TP5.EJ7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CaminoAlter<T> {

    /*
     * Ejercicio 7:
     * Dado un grafo no orientado que modela rutas,
     * devolver todos los caminos alternativos desde origen hasta destino,
     * evitando un tramo cortado.
     *
     * En el enunciado:
     * origen  = Buenos Aires
     * destino = Tandil
     * tramo cortado = Las Flores - Rauch
     *
     * Como el grafo es no orientado, el tramo cortado debe evitarse
     * en ambos sentidos:
     *
     * Las Flores -> Rauch
     * Rauch -> Las Flores
     *
     * Para encontrar todos los caminos usamos DFS recursivo.
     */
    public List<List<Integer>> obtenerCaminosAlternativos(Grafo<T> grafo,
                                                          int origen,
                                                          int destino,
                                                          int corte1,
                                                          int corte2) {

        List<List<Integer>> caminos = new ArrayList<List<Integer>>();
        List<Integer> caminoActual = new ArrayList<Integer>();
        Set<Integer> visitados = new HashSet<Integer>();

        // Si el origen o el destino no existen, no puede haber caminos.
        if (!grafo.contieneVertice(origen) || !grafo.contieneVertice(destino)) {
            return caminos;
        }

        buscarCaminos(grafo, origen, destino, corte1, corte2,
                caminoActual, visitados, caminos);

        return caminos;
    }

    private void buscarCaminos(Grafo<T> grafo,
                               int actual,
                               int destino,
                               int corte1,
                               int corte2,
                               List<Integer> caminoActual,
                               Set<Integer> visitados,
                               List<List<Integer>> caminos) {

        // Agrego el vértice actual al camino que estoy construyendo.
        caminoActual.add(actual);

        // Marco el vértice actual como visitado para no repetirlo
        // dentro del mismo camino.
        visitados.add(actual);

        /*
         * Caso base:
         * Si llegué al destino, encontré un camino completo.
         */
        if (actual == destino) {

            // Guardo una copia del camino actual.
            // Es importante copiarlo, no guardar la misma referencia.
            caminos.add(new ArrayList<Integer>(caminoActual));

        } else {

            // Si todavía no llegué al destino, sigo recorriendo adyacentes.
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);

            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();

                /*
                 * Verifico si el arco actual corresponde al tramo cortado.
                 *
                 * Como el grafo es no orientado, tengo que controlar
                 * los dos sentidos:
                 *
                 * corte1 -> corte2
                 * corte2 -> corte1
                 */
                boolean esTramoCortado =
                        (actual == corte1 && adyacente == corte2) ||
                                (actual == corte2 && adyacente == corte1);

                /*
                 * Solo avanzo si:
                 * 1) El adyacente no fue visitado en el camino actual.
                 * 2) El tramo no corresponde al tramo cortado.
                 */
                if (!visitados.contains(adyacente) && !esTramoCortado) {
                    buscarCaminos(grafo, adyacente, destino, corte1, corte2,
                            caminoActual, visitados, caminos);
                }
            }
        }

        /*
         * Al terminar de explorar desde este vértice,
         * lo saco del camino actual y lo desmarco como visitado.
         *
         * Esto permite probar otros caminos alternativos.
         */
        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }
}