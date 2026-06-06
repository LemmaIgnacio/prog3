
codigo generico algoritmo de backtracking:
```java
BACK(estado e, solucionActual sol) { //

    if (SOLUCION(e)) {
        OperarSobreSolucion(e, sol);
    } else {
        int nrohijo = 1;
        estado siguiente;

        while (HIJOS(nrohijo, e, siguiente)) {

            if (!PODA(siguiente, sol)) {

                AgregarASolucionActual(siguiente, sol);

                BACK(siguiente, sol);

                QuitarDeSolucionActual(siguiente, sol);
            }

            nrohijo++;
        }
    }
}
```
BACK(estado e, solucionActual sol) = Voy a explorar todas las soluciones posibles que se pueden construir desde este estado
estado = lo que cambia de una llamada recursiva a otra
- ejemplo:

  | Tipo de problema     | Estado puede ser                              |
  | -------------------- | --------------------------------------------- |
  | Camino en grafo      | último vértice + visitados + costo            |
  | Suma de subconjuntos | índice actual + suma acumulada                |
  | Tablero              | posición actual + tablero parcial + usados    |
  | Procesadores         | tarea actual + cargas de procesadores         |
  | Laberinto            | celda actual + costo acumulado + visitadas    |
  | 15 puzzle            | tablero actual + posición vacía + movimientos |

solucionActual sol = lo que llevo construido hasta ahora
- ejemplo:

  | Problema             | `solucionActual`                            |
  | -------------------- | ------------------------------------------- |
  | Suma de subconjuntos | elementos elegidos o vector de 0/1 parcial  |
  | Camino               | lista de vértices/celdas recorridas         |
  | Procesadores         | asignaciones hechas hasta ahora             |
  | Tablero mágico       | tablero parcialmente llenado                |
  | 8 reinas             | columnas elegidas para las filas anteriores |
  | 15 puzzle            | lista de movimientos realizados             |

if (SOLUCION(e)) = estado actual ya representa una solución completa o candidata;  ya tengo una respuesta para evaluar?
- ejemplo:

  | Problema              | Condición de solución                                              |
  | --------------------- | ------------------------------------------------------------------ |
  | Suma subconjuntos     | ya procesé todos los elementos, o suma == M si quiero cortar antes |
  | Camino entrada-salida | llegué al destino                                                  |
  | Procesadores          | asigné todas las tareas                                            |
  | Tablero mágico        | llené todas las casillas                                           |
  | 8 reinas              | coloqué todas las reinas                                           |
  | Robot/laberinto       | llegué a la base/destino                                           |
  | 15 puzzle             | tablero está ordenado                                              |

OperarSobreSolucion(e, sol) = Que hago con la solucion candidata
 - una sola solución -> devuelvo y corto recursion
 - todas las soluciones ->  la guardo en una lista y sigo buscando
 - quiero la mejor solución -> la comparo contra la mejor actual, si mejora, reemplazo

else: Si entra es que no encontre una solucion completa, entonces genero decisiones posibles

int nrohijo = 1; estado siguiente; = voy a probar una por una las decisiones posibles desde este estado

while (HIJOS(nrohijo, e, siguiente)) = Generar el próximo estado posible a partir del estado actual
- hijo -> el resultado de tomar una decisión válida o candidata desde e

  | Problema          | Hijos                                                    |
  | ----------------- | -------------------------------------------------------- |
  | Suma subconjuntos | tomar / no tomar el elemento actual                      |
  | Contraseña        | poner 0, 1, 2, ..., 9 en la posición actual              |
  | Camino en grafo   | moverse a cada adyacente                                 |
  | Laberinto         | moverse norte, sur, este, oeste si se puede              |
  | Procesadores      | asignar tarea actual al procesador 1, 2, ..., m          |
  | Tablero mágico    | poner cada número disponible en la casilla actual        |
  | 8 reinas          | probar columnas para la fila actual                      |
  | 15 puzzle         | mover la casilla vacía arriba, abajo, izquierda, derecha |

if (!PODA(siguiente, sol)) = sirve la rama en la que estoy bajando?

| Restricción del problema  | Poda                                         |
| ------------------------- | -------------------------------------------- |
| No repetir salas/celdas   | si ya está visitada, no sigo                 |
| Suma exacta con positivos | si suma actual > objetivo, no sigo           |
| Camino mínimo             | si costo actual >= mejor costo, no sigo      |
| N reinas                  | si comparte columna/diagonal, no sigo        |
| Tablero mágico            | si suma parcial de fila > S, no sigo         |
| Subconjunto tamaño N      | si ya elegí más de N, no sigo                |
| 15 puzzle                 | si ya vi ese tablero en este camino, no sigo |

AgregarASolucionActual(siguiente, sol) = tomo la decisión y modifico la solución parcial

| Problema          | Agregar                           |
| ----------------- | --------------------------------- |
| Camino            | agregar vértice/celda al camino   |
| Suma subconjuntos | marcar 1 o agregar elemento       |
| Procesadores      | asignar tarea a procesador        |
| Tablero           | escribir número en casilla        |
| 8 reinas          | colocar reina en columna          |
| 15 puzzle         | aplicar movimiento y guardar paso |

BACK(siguiente, sol) = exploro todo lo que puede pasar después de tomar esa decisión

QuitarDeSolucionActual(siguiente, sol) = si termine de probar esa rama, la quito para probar otra

| Problema     | Quitar                                |
| ------------ | ------------------------------------- |
| Camino       | sacar último vértice/celda            |
| Visitados    | desmarcar visitado                    |
| Suma         | restar el elemento agregado           |
| Procesadores | restar tiempo al procesador           |
| Tablero      | borrar número de casilla              |
| 8 reinas     | quitar reina                          |
| 15 puzzle    | deshacer movimiento o restaurar copia |

nrohijo++ = probar la siguiente decisión posible
