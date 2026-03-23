# Ejercicio 2
Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
complejidad computacional contra un array en las siguientes operaciones:
1. Insertar al principio

    - lista vinculada: O(1), crea un nuevo nodo y cambia las referencias de los nodos existentes, no depende 
                                del tamaño de la lista
    - array: O(n), correr todos los elementos a la derecha, depende de cuantos elementos haya
2. Buscar un elemento en una posición
    
    - lista vinculada: O(n) recorrer los nodos hasta encontrar la posicion
    - array: O(1), acceso es directo mediante un indice porque estan contiguos en memoria.
3. Determinar la cantidad de elementos

    - lista vinculada: O(1), guardar el tamaño con variable "size"
    - array: O(1), array.length o fijar tamaño con una constante
4. Borrar un elemento de una posición determinada

    - lista vinculada: O(n), hay que recorrer la lista hasta llegar al nodo anterior y actualizar las referencias
    - array: O(n), correr los elementos hacia la izquierda.