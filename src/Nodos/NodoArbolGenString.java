package Nodos;

public class NodoArbolGenString
{
    private String elem;
    private NodoArbolGenString hijoIzquierdo;
    private NodoArbolGenString hermanoDerecho;
    
    public NodoArbolGenString(String elemNuevo){
        elem = elemNuevo;
    }
    
    public String getElem(){
        return elem;
    }
    
    public NodoArbolGenString getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    
    public NodoArbolGenString getHermanoDerecho(){
        return hermanoDerecho;
    }
    
    public void setElem (String elemN){
        elem = elemN;
    }
    
    public void setHijoIzquierdo(NodoArbolGenString hijoIzqN){
        hijoIzquierdo = hijoIzqN;
    }
    
    public void setHermanoDerecho(NodoArbolGenString hermanoDerN){
        hermanoDerecho = hermanoDerN;
    }
    
}
