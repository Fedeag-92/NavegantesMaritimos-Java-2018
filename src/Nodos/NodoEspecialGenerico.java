package Nodos;

public class NodoEspecialGenerico { //Nodo epecial usado por ColaNodo.
    private NodoArbolGenInt elem; //Guarda como elemento nodos de un arbol binario.
    private NodoEspecialGenerico enlace; //El enlace es de tipo NodoEspecial.    
    
    public NodoEspecialGenerico(NodoArbolGenInt elem, NodoEspecialGenerico enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    public NodoEspecialGenerico(NodoArbolGenInt elemN){
        this.elem = elemN;
        this.enlace = null;
    }

    public NodoArbolGenInt getElem(){
        return elem;
    }

    public void setElem(NodoArbolGenInt elem){
        this.elem = elem;
    }

    public NodoEspecialGenerico getEnlace(){
        return enlace;
    }

    public void setEnlace(NodoEspecialGenerico enlace){
        this.enlace = enlace;
    }

}
