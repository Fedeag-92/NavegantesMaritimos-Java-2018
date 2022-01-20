package Lineales_Dinamicas;

import Nodos.Nodo;

public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {

        frente = null;
        fin = null;
    }

    public boolean poner(Object elem) {

        boolean exito = true;
        Nodo nuevoNodo = new Nodo(elem);

        if (esVacia()) {
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
        } else { // tiene elementos
            this.fin.setEnlace(nuevoNodo);// agrega un enlace para que se almacene el nuevoNodo
            this.fin = nuevoNodo;// el nuevo nodo es el final de la cola
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;

        if (this.frente == null) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();

            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public boolean esVacia() {

        return (frente == null);
    }

    public void vaciar() {

        frente = null;
        fin = null;
    }

    public Object obtenerFrente() {
        Object sale = null;
        if (!this.esVacia()) {
            sale = this.frente.getElem();
        }
        return sale;
    }

    public Cola clonar() {

        Cola clon = new Cola();
        Nodo aux = this.frente;

        while (aux != null) {
            clon.poner(aux.getElem());
            aux = aux.getEnlace();
        }
        return clon;
    }

    @Override
    public String toString() {

        String cadena = "";
        Nodo aux = this.frente;

        while (aux != null) {
            cadena += aux.getElem() + " | ";
            aux = aux.getEnlace();
        }
        return cadena;
    }
    
     public String toString2() {

        String cadena = "";
        Nodo aux = this.frente;

        while (aux != null) {
            cadena += aux.getElem().toString() + " | ";
            aux = aux.getEnlace();
        }
        return cadena;
    }

}
