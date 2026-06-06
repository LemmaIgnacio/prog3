package TP5.EJ6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;
    private int cantidadArcos;

    public GrafoDirigido() {
        this.cantidadArcos = 0;
        this.vertices = new HashMap<>();
    }

    // Implementar Hashmap para guardar el grafo
    @Override
    public void agregarVertice(int verticeId) {
        //el vertice todavía no está cargado en el grafo
        if(!this.vertices.containsKey(verticeId)){
            //agrega al hashmap
            //segundo hashmap representa la lista de adyacencia del vertice
            this.vertices.put(verticeId, new HashMap<Integer, Arco<T>>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        //si existe el grafo
        if(this.vertices.containsKey(verticeId)){
            //quitar los arcos salientes del vertice a borrar
            this.cantidadArcos = this.cantidadArcos - this.vertices.get(verticeId).size();
            //eliminar el vertice con sus adyacentes
            this.vertices.remove(verticeId);
            //recorrer las listas de adyacencia de los demás vertices
            // eliminar los arcos que tenían destino el vertice borrado
            for (HashMap<Integer, Arco<T>> a : this.vertices.values()){
                if (a.containsKey(verticeId)){
                    a.remove(verticeId);
                    cantidadArcos--;
                }
            }
        }
    }

    // verticeId1 vértice origen
    // verticeId2 vértice destino
    // etiqueta  información asociada al arco.
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        //si no existe lo agrego al grafo
        if (!this.vertices.containsKey(verticeId1)) {
            this.agregarVertice(verticeId1);
        }
        //si no exite el vertice destino lo  agrego al grafo
        if (!this.vertices.containsKey(verticeId2)) {
            this.agregarVertice(verticeId2);
        }

        //lista de adyecencia
        HashMap<Integer, Arco<T>> adyacentes = this.vertices.get(verticeId1);

        //si no hay arco entre el vertice origen y vertice destino
        //entonces agrego el nuevo arco y sumo cantidad de arcos
        if (!adyacentes.containsKey(verticeId2)) {
            this.cantidadArcos++;
        }
        //crear el arco dirigido
        Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
        //guardar el arco
        adyacentes.put(verticeId2, arco); //la clave del hashmap interno es el vertice destino
    }

    //No se borra el vértice origen ni el vértice destino
    // Solo se borra el arco que sale desde verticeId1 y llega a verticeId2
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // existe el vértice origen
        if (this.vertices.containsKey(verticeId1)) {
            // lista de adyacencia del vértice origen
            HashMap<Integer, Arco<T>> adyacentes = this.vertices.get(verticeId1);
            // existe un arco desde verticeId1 hacia verticeId2
            if (adyacentes.containsKey(verticeId2)) {
                // borrar arco
                adyacentes.remove(verticeId2);
                this.cantidadArcos--;
            }
        }
    }

    //los vértices se guardan como claves del Hashmap
    @Override
    public boolean contieneVertice(int verticeId) {
        // existe esa clave?
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        //si el vértice origen no existe, no hay arco
        if (this.vertices.containsKey(verticeId1)) {
            return this.vertices.get(verticeId1).containsKey(verticeId2);
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        //sino existe el arco devuelve null
        if (this.existeArco(verticeId1, verticeId2)) {
            return this.vertices.get(verticeId1).get(verticeId2);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        //devolver tamaño del hashmap
        //O(1)
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        //se utiliza una variable para la cantida de arcos
        //se actualiza en los métodos
        //no hay que recorrer el grafo
        // O(1)
        return this.cantidadArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        //vertices guarados en un hashmap
        //el orden en que se toman los vértices puede ser cualquiera
        return this.vertices.keySet().iterator();
    }

    //en los grafos dirigidos, los adyacentes son los vertices destino
    //desde el origen por un solo arco
    //cada vertice está en un hashmap con sus arcos salientes
    //con clave los vertices adyacentes
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        //si no existe devuele el Iterator vacio
        if (this.vertices.containsKey(verticeId)) {
            return new ArrayList<Integer>(this.vertices.get(verticeId).keySet()).iterator();
        }

        return new ArrayList<Integer>().iterator();
    }

    //cada vértice tiene guardados sus arcos salientes en su lista de adyacencia
    //recorrer todas las listas de adyacencia
    // meter los arcos en una lista retornable
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<Arco<T>>();
        //recorrer todas las listas de adyacencia del grafo
        for (HashMap<Integer, Arco<T>> adyacentes : this.vertices.values()) {
            //agregar todos los arcos salientes del vértice a la lista
            arcos.addAll(adyacentes.values());
        }
        return arcos.iterator();
    }


    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        //si el vértice existe, devuelvo los arcos guardados en esa lista
        if (this.vertices.containsKey(verticeId)) {
            return new ArrayList<Arco<T>>(this.vertices.get(verticeId).values()).iterator();
        }
        return new ArrayList<Arco<T>>().iterator();
    }

}