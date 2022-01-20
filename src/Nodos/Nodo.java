package Nodos;

public class Nodo {

    private Object elem;
    private Nodo enlace;

    public Nodo(Object elemento, Nodo enlace) {
        this.elem = elemento;
        this.enlace = enlace;
    }

    public Nodo(Object elemento) {
        this.elem = elemento;
        this.enlace = null;
    }

    public Nodo() {
        this.elem = null;
        this.enlace = null;
    }

    public void setElem(Object elemento) {
        this.elem = elemento;
    }

    public Object getElem() {
        return this.elem;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }

}
