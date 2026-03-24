# Ejercicio 1
Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y
responda:
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
    - O(n), compara cada elemento con el siguiente, en el peor caso recorre todo el array
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    - Ocupa mas memoria, cada recursividad se guarda en una pila
    - StackOverflow, sin un caso base o de corte
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
    - Un array accede en O(1) y la lista O(n) (Avanzar con cursor.next O(1))
    - Si se recorre la lista con cursores se mantiene la complejidad O(n)