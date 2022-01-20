package Nodos;

public class NodoArbolGenInt
{
    private int elem;
    private NodoArbolGenInt hijoIzquierdo;
    private NodoArbolGenInt hermanoDerecho;
    
    public NodoArbolGenInt(int elemNuevo){
        elem = elemNuevo;
    }
    
    public int getElem(){
        return elem;
    }
    
    public NodoArbolGenInt getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    
    public NodoArbolGenInt getHermanoDerecho(){
        return hermanoDerecho;
    }
    
    public void setElem (int elemN){
        elem = elemN;
    }
    
    public void setHijoIzquierdo(NodoArbolGenInt hijoIzqN){
        hijoIzquierdo = hijoIzqN;
    }
    
    public void setHermanoDerecho(NodoArbolGenInt hermanoDerN){
        hermanoDerecho = hermanoDerN;
    }
    
}
