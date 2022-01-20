package Nodos;

import NavegantesMaritimos.Puerto;

public class NodoAVLPuerto implements Comparable {
    private Puerto elemento;
    private NodoAVLPuerto hijoIzq;
    private NodoAVLPuerto hijoDer;
    private int altura;

    public NodoAVLPuerto() {
        this.elemento=null;
        this.hijoDer=null;
        this.hijoIzq=null;
        this.altura=-1;
    }

    public NodoAVLPuerto(Puerto elemento,int alt) {
        this.elemento = elemento;
        this.altura = alt;
    }

    public NodoAVLPuerto(Puerto elemento) {
        this.elemento = elemento;
        this.altura = 0;
    }
    
    public Puerto getElemento() {
        return elemento;
    }

    public void setElemento(Puerto elemento) {
        this.elemento = elemento;
    }

    public NodoAVLPuerto getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAVLPuerto hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAVLPuerto getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAVLPuerto hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int compareTo(Object otro){
        Puerto n = (Puerto) otro;
        return this.elemento.getNombre().compareTo(n.getNombre());
    }
}
