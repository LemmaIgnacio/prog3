# Ejercicio 3
Se está desarrollando una aplicación que almacena los datos y el saldo de las tarjetas de
compra de comida del comedor de una universidad. Cada cliente es identificado por su
número de DNI, y se poseen además sus datos personales y de la carrera que estudia.
CLIENTE: DNI, Nombre, Apellido, fecha de nacimiento, domicilio, CP ciudad de origen, saldo
de la cuenta, nombre carrera estudia
Se quiere:

a. Dado un DNI de cliente, responder el saldo de su cuenta

- Tabla de hashing
- Clave como DNI, y apunta al objeto cliente
- Complejidad (O(n))
- Con el DNI accede directamente al cliente y este llama a la funcion corresponndiente que trae el saldo
- Hash por DNI
  - 12345678 -> referencia a c1
  - 23456789 -> referencia a c2
  - 34567890 -> referencia a c3

b. Imprimir un listado de Nombre y Apellido de todos los clientes que tienen en su saldo
de cuenta menos de un valor X dado

- Las tablas de hashing no son eficientes para las busquedas por clave o por rango
- Es mas eficiente utilizar arboles ordenados por saldo, 
- Las tablas tienen un inconveniente y es si varias personas tienen el mismo saldo
- En cambio los arboles de busqueda, tienen una lista de factoreo con referencias a los clientes que tienen x salgo
- dado que saldo menor que x,  el arbol, toma los nodos con la clave menor que x y obtiene el nombre y apellido correspondiente
- Índice ABB por saldo
  - 50  -> lista de referencias a cliente con saldo 50
  - 120 -> lista de referencias a cliente con saldo 120
  - 300 -> lista de referencias a cliente con saldo 300

c. Dado un código postal, listar todos los clientes que provengan de esa ciudad.
Proponga y describa qué estructuras de datos utilizaría para responder eficientemente a los
servicios pedidos. Muestre gráficamente cómo se relacionan.

- Tabla de hashing
- Clave la CP
- La CP es inmutable
- Dado que multiples clientes pueden compartir una misma CP
- El valor no es un unico elemento sino una lista con referencias a los clientes que tienen ese CP
- Al consultar por un CP se accede a la posicion, y se obtiene la tabla asociada sin recorrer toda la estructura
- Hash por CP
  - 7000 -> [Cliente1] -> [Cliente2] -> [Cliente3]
  - 1000 -> [Cliente4] -> [Cliente5]
  - 7600 -> [Cliente6]