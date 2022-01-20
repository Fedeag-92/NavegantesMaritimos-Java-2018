package Grafos;

public class NodoColaVert {
    private NodoVert elem;
    private NodoColaVert enlace;

    public NodoColaVert(NodoVert nodo, NodoColaVert enlace) {
        this.elem = nodo;
        this.enlace = enlace;
    }
    
    public NodoVert getElem() {
        return elem;
    }

    public void setElem(NodoVert nodo) {
        this.elem = nodo;
    }

    public NodoColaVert getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoColaVert enlace) {
        this.enlace = enlace;
    }
}
