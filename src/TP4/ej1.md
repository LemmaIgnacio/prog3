# Ejercicio 1
Dado el conjunto de elementos: X= {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61,
50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92} Realizar la inserción de los mismos en una estructura
de Hashing com la que se especifica en cada punto, con las siguientes técnicas de
tratamiento de desbordes, muestre gráficamente cómo se va armando la estructura y cómo
queda luego de insertar hasta el último elemento:
a.- Hashing separado (con M=7 y rp=1, rs=1).
b.- Hashing separado con crecimiento (con el comportamiento de HashTable de JAVA) (con
M=7, ρd=0,9).


a) M=7 y rp=1, rs=1, h(x)= x mod 7
     h(68) =68 mod 7 = 5
     h(42) = 42 mod 7 = 0 
     h(47) = 47 mod 7 = 5
     h(5) = 5 mod 7 = 5
     h(76) = 76 mod 7 = 6
     h(95) = 4
     h(23) = 2
     h(88) = 4
     h(90) = 6
     h(85) = 1
     h(31) = 3
     h(71) = 1
     h(60) = 4
     h(10) = 3
     h(46) = 4
     h(61) = 5
     h(50) = 1
     h(92) = 1
     h(74) = 4
     h(6) = 6
     h(97) = 6
     h(66) = 3
     h(1) = 1
     h(56) = 0
     h(27) = 6
     h(7) = 0
     h(14) = 0
     h(92) = 1

- Tabla:
0. -> [42]
    rebalse -> [56] -> [7] -> [14]
1. -> [85]
     rebalse -> [71] -> [50] -> [92] -> [1] -> [92]
2. -> [23]
3. -> [31]
   rebalse -> [10] -> [66]
4. -> [95]
   rebalse -> [88] -> [60] -> [46] -> [74]
5. -> [68]
   rebalse -> [47] -> [5] -> [61]
6. -> [76]
   rebalse -> [90] -> [6] -> [97] -> [27]

b) M=7, ρd=0,9
- limite del creimiento: L = ⌊ M * rp * ρd ⌋ = ⌊ 7 * 1 * 0,9 ⌋ = ⌊ 6,3 ⌋ = 6
- tabla:
  - 0 -> [42]
  - 1 ->
  - 2 ->
  - 3 ->
  - 4 -> [95]
  - 5 -> [68] 
    rebalse -> [47] -> [5] ->
  - 6 -> [76]
  
- Dado que count = 6 y L = 6, count >= L, rehash
  - M = 2M +1 = 2*7 +1 = 14 + 1 = 15
  - L = ⌊ 15 * 1 * 0,9 ⌋ = L 13,5 ⌋ = 13
  - recargar elementos dado que M=15:
    - h(68) = 68 mod 15 = 8
    - h(42) = 42 mod 15 = 12
    - h(47) = 47 mod 15 = 2
    - h(5) = 5 mod 15 = 5
    - h(76) = 76 mod 15 = 1
    - h(95) = 95 mod 15 = 5
  - tabla:
    - 0  -> [90]
        rebalse -> [60]
    - 1  -> [76]
      rebalse -> [31]
    - 2  -> [47]
    - 3  -> []
    - 4  -> []
    - 5  -> [5]
      rebalse -> [95]
    - 6  -> []
    - 7  -> []
    - 8  -> [68]
      rebalse -> [23]
    - 9  -> []
    - 10 -> [85]
    - 11 -> [71]
    - 12 -> [42]
    - 13 -> [88]
    - 14 -> []

- Dado que count = 13 y L = 13, count >= L, rehash
    - M = 2M +1 = 2*15 +1 = 30 + 1 = 31
    - L = ⌊ 31 * 1 * 0,9 ⌋ = ⌊ 27,9 ⌋ = 27
- recargar elementos dado que M=31:
    - h(68) = 68 mod 31 = 6
    - h(42) = 42 mod 31 = 11
    - h(47) = 47 mod 31 = 16
    - h(5) = 5 mod 31 = 5
    - h(76) = 76 mod 31 = 14
    - h(95) = 95 mod 31 = 2
    - h(23) = 23 mod 31 = 23
    - h(88) = 88 mod 31 = 26
    - h(90) = 90 mod 31 = 28
    - h(85) = 85 mod 31 = 23
    - h(31) = 31 mod 31 = 0
    - h(71) = 71 mod 31 = 9
    - h(60) = 60 mod 31 = 29
- tabla:
    - 0  -> [31]
    - 1  -> [1]
    - 2  -> [95]
    - 3  -> []
    - 4  -> [97]
      rebalse -> [66]
    - 5  -> [5]
    - 6  -> [68]
      rebalse -> [6]
    - 7  -> []
    - 8  -> []
    - 9  -> [71]
    - 10 -> [10]
    - 11 -> [42]
    - 12 -> [74]
    - 13 -> []
    - 14 -> [76]
    - 15 -> [46]
    - 16 -> [47]
    - 17 -> []
    - 18 -> []
    - 19 -> [50]
    - 20 -> []
    - 21 -> []
    - 22 -> []
    - 23 -> [23]
      rebalse -> [85]
    - 24 -> []
    - 25 -> [56]
    - 26 -> [88]
    - 27 -> [27]
    - 28 -> [90]
    - 29 -> [60]
    - 30 -> [61]
      rebalse -> [92]
- Dado que count = 13 y L = 13, count >= L, rehash
    - M = 2M +1 = 2*15 +1 = 30 + 1 = 31
    - L = ⌊ 31 * 1 * 0,9 ⌋ = ⌊ 27,9 ⌋ = 27
    - se recargan los elementos con M=31
- tabla final:
    - 0  -> [31]
    - 1  -> [1]
    - 2  -> [95]
    - 3  -> []
    - 4  -> [97]
      rebalse -> [66]
    - 5  -> [5]
    - 6  -> [68]
      rebalse -> [6]
    - 7  -> [7]
    - 8  -> []
    - 9  -> [71]
    - 10 -> [10]
    - 11 -> [42]
    - 12 -> [74]
    - 13 -> []
    - 14 -> [76]
      rebalse -> [14]
    - 15 -> [46]
    - 16 -> [47]
    - 17 -> []
    - 18 -> []
    - 19 -> [50]
    - 20 -> []
    - 21 -> []
    - 22 -> []
    - 23 -> [23]
      rebalse -> [85]
    - 24 -> []
    - 25 -> [56]
    - 26 -> [88]
    - 27 -> [27]
    - 28 -> [90]
    - 29 -> [60]
    - 30 -> [61]
      rebalse -> [92] -> [92]