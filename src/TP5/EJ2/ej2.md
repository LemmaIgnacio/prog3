DFS es un recorrido en profundidad. Se inicializan todos los vértices como no visitados,
representados con el color BLANCO. Luego se recorren todos los vértices del grafo y,
si alguno sigue en BLANCO, se llama recursivamente a DFS_Visit.
En DFS_Visit, el vértice actual se marca como AMARILLO, se agrega al recorrido y se recorren
sus adyacentes. Por cada adyacente que todavía esté en BLANCO, se realiza una llamada
recursiva. Cuando ya no quedan adyacentes por procesar, el vértice se marca como NEGRO.
El uso de colores evita visitar dos veces el mismo vértice, algo necesario porque en un grafo
se puede llegar a un mismo vértice por más de un camino.

BFS usa una fila/cola y recorre el grafo por capas: primero los vértices a distancia 1,
después los de distancia 2, luego los de distancia 3, y así sucesivamente.
Por eso BFS es útil cuando se necesita encontrar el camino con menor cantidad de arcos
en un grafo no ponderado.