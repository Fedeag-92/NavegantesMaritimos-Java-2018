package Nodos;

public class NodoEspecialBinario { //Nodo epecial usado por ColaNodo.
    private NodoArbolBinInt elem; //Guarda como elemento nodos de un arbol binario.
    private NodoEspecialBinario enlace; //El enlace es de tipo NodoEspecial.

    public NodoEspecialBinario(NodoArbolBinInt elem, NodoEspecialBinario enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    public NodoEspecialBinario(NodoArbolBinInt elemN){
        this.elem = elemN;
        this.enlace = null;
    }

    public NodoArbolBinInt getElem(){
        return elem;
    }

    public void setElem(NodoArbolBinInt elem){
        this.elem = elem;
    }

    public NodoEspecialBinario getEnlace(){
        return enlace;
    }

    public void setEnlace(NodoEspecialBinario enlace){
        this.enlace = enlace;
    }

}
