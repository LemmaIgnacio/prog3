Ejercicio 4 (2do intento)
Se desea desarrollar una aplicación para mejorar la atención de una biblioteca en cuanto a la
búsqueda de libros dentro del catálogo disponible. Cada libro estará compuesto por un
identificador único y datos propios de los libros (título, autor, géneros, año de publicación,
cantidad de ejemplares, etc.)
Se sabe, además, que los libros nuevos se agregan al catálogo en horarios fuera de la
atención al público.
Se desean proveer los siguientes servicios:
- Obtener la cantidad de ejemplares de un libro dado su identificador único.
- Obtener todos los libros de un género dado.
- Obtener todos los libros publicados entre dos años de publicación dados.
Responda y justifique:
1) ¿Qué estructura de datos utilizaría para almacenar todos los libros en memoria dentro
   de la aplicación?
    - Utilizaria una lista vinculada para almacenar todos los libros
2) ¿Cómo resolvería cada uno de los servicios solicitados? ¿Utilizaría alguna estructura
   adicional de acceso para mejorar el costo de respuesta de cada servicio?
    - Cantidad de ejemplares de un libro segun identificador:
      - Un hashmap que dado el indentificador, traiga la cantidad de ejemplares
    - Obtener todo los libros dado un genero:
      - Un hashmap dado el genero X, traiga todos los objetos que tengan el atributo X
    - Todos los libros entre dos fechas
      - Busqueda con arboles ordenado por anio de publiacion, dado que hay una condicion, hay que recorrer todos los elementos
      - y hashmap es ineficiente para eso, y no es su principal funcion
    - Utilizaria alguna estructura adicional:
      - Se utilizaria treemap junto a hashmap como estructuras adiconales, para resolver
      - los servios solicitados, aunque aumenta el costo en memoria, pero mejora la complejidad computacional