package TP5.EJ6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CaminoMasCorto<T> {

    /*
     * Ejercicio 6:
     * Una ciudad se modela como un grafo.
     *
     * - Cada vertice representa una esquina.
     * - Cada arista representa una calle/cuadra.
     *
     * Se pide devolver el camino mas corto entre dos esquinas,
     * de manera de caminar la menor cantidad de cuadras posible.
     *
     * Como las aristas no tienen peso, el camino mas corto es el que
     * tiene menor cantidad de aristas.
     *
     * Para eso usamos BFS, porque BFS recorre por niveles:
     * primero los vertices a distancia 1,
     * despues los vertices a distancia 2,
     * despues los vertices a distancia 3,
     * y asi sucesivamente.
     */
    public List<Integer> caminoMasCorto(Grafo<T> grafo, int origen, int destino) {

        List<Integer> camino = new ArrayList<Integer>();

        // Si alguno de los vertices no existe, no puede haber camino.
        if (!grafo.contieneVertice(origen) || !grafo.contieneVertice(destino)) {
            return camino;
        }

        /*
         * Caso especial:
         * Si origen y destino son el mismo vertice, el camino es ese mismo vertice.
         * La cantidad de cuadras caminadas seria 0.
         */
        if (origen == destino) {
            camino.add(origen);
            return camino;
        }

        /*
         * visitados guarda los vertices que ya fueron descubiertos por BFS.
         * Esto evita repetir vertices y evita ciclos.
         */
        Set<Integer> visitados = new HashSet<Integer>();

        /*
         * padres guarda desde que vertice llegue a cada vertice.
         *
         * Ejemplo:
         * Si llegue al vertice 5 desde el vertice 3, guardo:
         *
         * padres.put(5, 3);
         *
         * Esto despues permite reconstruir el camino desde destino hacia origen.
         */
        HashMap<Integer, Integer> padres = new HashMap<Integer, Integer>();

        /*
         * BFS usa una fila.
         * La fila respeta FIFO: el primero que entra es el primero que sale.
         */
        Queue<Integer> fila = new LinkedList<Integer>();

        // Marco el origen como visitado y lo agrego a la fila.
        visitados.add(origen);
        fila.add(origen);

        boolean encontreDestino = false;

        /*
         * Mientras la fila no este vacia y todavia no haya encontrado el destino,
         * sigo recorriendo el grafo por niveles.
         */
        while (!fila.isEmpty() && !encontreDestino) {

            // Saco el primer vertice de la fila.
            Integer actual = fila.poll();

            // Recorro todos los adyacentes del vertice actual.
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);

            while (adyacentes.hasNext() && !encontreDestino) {
                Integer adyacente = adyacentes.next();

                /*
                 * Si el adyacente todavia no fue visitado,
                 * lo descubro por primera vez.
                 *
                 * En BFS, la primera vez que llego a un vertice,
                 * llego por el camino con menor cantidad de aristas.
                 */
                if (!visitados.contains(adyacente)) {

                    // Marco el adyacente como visitado.
                    visitados.add(adyacente);

                    // Guardo que llegue al adyacente desde actual.
                    padres.put(adyacente, actual);

                    /*
                     * Si el adyacente es el destino, ya encontre el camino mas corto.
                     * Puedo cortar porque BFS llega por niveles.
                     */
                    if (adyacente == destino) {
                        encontreDestino = true;
                    } else {
                        // Si no era el destino, lo agrego a la fila para procesarlo luego.
                        fila.add(adyacente);
                    }
                }
            }
        }

        /*
         * Si no encontre el destino, significa que no existe camino
         * desde origen hasta destino.
         */
        if (!encontreDestino) {
            return camino;
        }

        /*
         * Reconstruccion del camino:
         *
         * Como padres guarda desde donde llegue a cada vertice,
         * empiezo desde el destino y voy retrocediendo hasta el origen.
         *
         * Ejemplo:
         * padres[5] = 3
         * padres[3] = 1
         *
         * Si origen = 1 y destino = 5,
         * reconstruyo:
         * 5, 3, 1
         *
         * Pero como el camino debe devolverse desde origen hasta destino,
         * voy agregando cada vertice al principio de la lista.
         */
        Integer actual = destino;

        while (actual != origen) {
            camino.add(0, actual);
            actual = padres.get(actual);
        }

        // Agrego el origen al principio.
        camino.add(0, origen);

        return camino;
    }
}