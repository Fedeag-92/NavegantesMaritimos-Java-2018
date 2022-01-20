package Proposito_Especificos;

import Lineales_Dinamicas.Cola;

public class ColaPrioridad {

    private final Cola[] lista;

    public ColaPrioridad(int cantPriori) {

        lista = new Cola[cantPriori];
        for (int i = 0; i < lista.length; i++) {
            Cola n = new Cola();
            lista[i] = n;
        }
    }

    public boolean insertar(Object elemento, int prioridad) {
        boolean exito = true;
        if (prioridad < 0 || prioridad > lista.length) {
            exito = false;
        } else {
            lista[prioridad].poner(elemento);
        }
        return exito;
    }

    public boolean esVacia() {
        boolean sale = true;
        int i = 0;

        while (i < lista.length && sale) {
            if (!lista[i].esVacia()) {
                sale = false;
            }
            i++;
        }

        return sale;
    }

    public Object recuperarFrente() {
        int i = 0;
        Object sale = null;

        while (i < lista.length && sale == null) {
            if (!lista[i].esVacia()) {
                sale = lista[i].obtenerFrente();
            }
            i++;
        }
        return sale;
    }

    public boolean eliminarFrente() {
        int i = 0;
        boolean sale = false;

        while (i < lista.length && !sale) {
            if (!lista[i].esVacia()) {
                lista[i].sacar();
                sale = true;
            }
            i++;
        }
        return sale;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < lista.length; i++) {
            if (!lista[i].esVacia()) {
                cadena = cadena + "Prioridad " + i + ": " + lista[i].toString();
            } else {
                cadena = cadena + "Prioridad " + i + ": vacia.";
            }

            cadena = cadena + "\n";

        }
        return cadena;
    }
}
