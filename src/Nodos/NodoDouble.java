package Nodos;

public class NodoDouble {
    private double elem;
    private NodoDouble enlace;

    public NodoDouble(double elem, NodoDouble enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    public NodoDouble(double elemN){
        this.elem = elemN;
        this.enlace = null;
    }

    public double getElem(){
        return elem;
    }

    public void setElem(double elem){
        this.elem = elem;
    }

    public NodoDouble getEnlace(){
        return enlace;
    }

    public void setEnlace(NodoDouble enlace){
        this.enlace = enlace;
    }

}
