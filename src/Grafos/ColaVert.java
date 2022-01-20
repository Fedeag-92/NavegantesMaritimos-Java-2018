package Grafos;

public class ColaVert {

    private NodoColaVert fin;
    private NodoColaVert frente;

    public ColaVert() {
    }

    public void poner(NodoVert elem) {

        NodoColaVert nuevo = new NodoColaVert(elem, null);
        if (esVacia()) {
            this.frente = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
    }

    public NodoVert extraerFrente() {

        NodoVert nodo = null;
        if (!esVacia()) {
            nodo = this.frente.getElem();
            this.frente = this.frente.getEnlace();
        }
        return nodo;
    }

    public boolean estaEnCola(NodoVert v) {
        boolean esta = false;
        NodoColaVert aux = this.frente;
        while (aux != null && !(esta)) {
            if (aux.getElem().equals(v.getElem())) {
                esta = true;
            } else {
                aux = aux.getEnlace();
            }
        }
        return esta;
    }

    public boolean esVacia() {
        return this.frente == null;
    }
}
