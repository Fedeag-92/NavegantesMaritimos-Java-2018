package Nodos;

public class NodoArbolBinInt {

    private int elem;
    private NodoArbolBinInt izquierdo;
    private NodoArbolBinInt derecho;

    public NodoArbolBinInt (int elem, NodoArbolBinInt izquierdo, NodoArbolBinInt derecho){

        this.elem=elem;
        this.izquierdo= izquierdo;
        this.derecho= derecho;
    }

    public NodoArbolBinInt (int ElemN){
        this.elem=ElemN;
    }

    public int getElem (){

        return elem;
    }

    public NodoArbolBinInt getIzquierdo (){

        return izquierdo;
    }

    public NodoArbolBinInt getDerecho (){

        return derecho;
    }

    public void setElem (int elem){

        this.elem=elem;
    }

    public void setIzquierdo (NodoArbolBinInt izquierdo){

        this.izquierdo=izquierdo;
    }

    public void setDerecho (NodoArbolBinInt derecho){

        this.derecho=derecho;
    }
}

