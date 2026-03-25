# Ejercicio 8
Investigar cómo está implementado el algoritmo Collection.Sort de Java y qué características
deben cumplir los elementos almacenados dentro de la colección a ordenar.

Coleccion.sort delega a List.sort que copia los elementos a un array, ordena el array, y los
vuelve a escribir en una lista
Utiliza el algoritmo "TimSort" es similar al MergeSort, pero de forma iterativa.
No altera el orden de los elementos iguales, y aprovecha los array parcialmente ordenados.
Los elementos deben poder:
- Implementar Comparable
- Poder compararse usando Comparator
- Mutualmente comparables
- Lista puede modificarse

Sino se cumple Java lanza una excepcion