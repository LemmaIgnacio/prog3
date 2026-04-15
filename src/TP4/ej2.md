# Ejercicio 2
Conteste si es posible o no y justifique:
1. Si se quisiera listar en orden todas las claves almacenadas en una estructura de
   hashing, ¿se podría? ¿Cómo? ¿Es la estructura más adecuada?
    - Es posible listar en orden las claves, pero no de forma directa ni eficiente
    - Las tablas de hashing no almacenan los datos de forma ordenada,
    - Distribuyen los datos segun el valor de la funcion de hashing
    - Habria que recorrer toda la tabla de hashing incluyendo el rebalse
    - Y hacer un ordenamiento
    - La idea de las tablas de hashing es permitir accesos a memoria de forma eficiente
    - O(1)
    - Es preferible para mantener un orden una estrucutura tal como un array o arboles de busqueda
    - Estos permiten recorrer elementos de forma eficiente
2. ¿Qué tipos de servicios resuelve un hashing? Es posible responder por ejemplo: La
   lista de todos los alumnos que obtuvieron una nota mayor que x en un curso dado?
   - El hashing esta diseniado para resolver ejercicios del tipo busqueda, insercion, elminiar por una  clave
   - Permite acceder directamente al elemento O(1)
   - En el caso de un alumno es muy util cuando se lo quiere buscar por DNI que es unico
   - Pero encontrar alumnos por una nota mayor que X en ineficiente
   - Las tablas de hash no mantienen un orden entre las claves, por lo que
   - Hacer busquedas es una forma ineficiente
   - Para buscar hay que recorrer toda la estructura ( O(n) ) y esto pierde la ventaja del hashing
   - Para esto es mejor una estructura ordenada para permitir consultas