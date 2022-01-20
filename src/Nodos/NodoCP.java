package Nodos;

import Lineales_Dinamicas.Cola;

public class NodoCP {

    private final int prioridad;
    private Cola cola;

    public NodoCP(int p) {
        this.prioridad = p;
        this.cola = new Cola();
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public Object getElemento() {
        return (cola.obtenerFrente());
    }

    public boolean eliminarFrente() {
        return (cola.sacar());
    }

    public boolean ponerEnCola(Object elemento) {
        return (cola.poner(elemento));
    }

    public boolean esVacio() {
        return (cola.esVacia());
    }

    public String toString() {
        return (cola.toString());
    }
}
