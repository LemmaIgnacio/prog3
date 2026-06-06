package TP6.EJ1;

import java.util.ArrayList;
import java.util.List;

public class ej1 {

    public void back(Sala salaActual, List<Sala> solActual, List<Sala> mejorSolucion){
        if(salaActual.getNombre().equals("salida")){
            //Operar sobre la solucion:
            if(solActual.size() > mejorSolucion.size()){
                mejorSolucion.clear();
                mejorSolucion.addAll(solActual);
            }
        }else{
            List<Sala> hijos = obtenerSalasAdyacentes(salaActual);
            int nrohijo = 1;
            Sala siguiente;

            while(nrohijo < hijos.size()){
                siguiente = hijos.get(nrohijo);
                if(!nodoVisitado(siguiente, solActual)){
                    AgregarASolucionActual(siguiente, solActual); //agrega siguiente al camino actual
                    back(siguiente, solActual, mejorSolucion);
                    QuitarDeSolucionActual(siguiente, solActual); // elimina la última sala agregada para volver al estado anterior
                }
                nrohijo++;
            }

        }

    }

}
/*
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
 */

