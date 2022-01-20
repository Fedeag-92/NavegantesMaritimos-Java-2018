package Nodos;

public class NodoArbolBinChar {

    private char elem;
    private NodoArbolBinChar izquierdo;
    private NodoArbolBinChar derecho;

    public NodoArbolBinChar (char elem, NodoArbolBinChar izquierdo, NodoArbolBinChar derecho){

        this.elem=elem;
        this.izquierdo= izquierdo;
        this.derecho= derecho;
    }

    public NodoArbolBinChar (char ElemN){
        this.elem=ElemN;
    }

    public char getElem (){

        return elem;
    }

    public NodoArbolBinChar getIzquierdo (){

        return izquierdo;
    }

    public NodoArbolBinChar getDerecho (){

        return derecho;
    }

    public void setElem (char elem){

        this.elem=elem;
    }

    public void setIzquierdo (NodoArbolBinChar izquierdo){

        this.izquierdo=izquierdo;
    }

    public void setDerecho (NodoArbolBinChar derecho){

        this.derecho=derecho;
    }
}

