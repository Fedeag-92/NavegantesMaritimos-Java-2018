package Nodos;

import NavegantesMaritimos.Puerto;

public class NodoAVL {

    private Comparable clave;
    private Object elemento;
    private NodoAVL hijoIzq;
    private NodoAVL hijoDer;
    private int altura;

    public NodoAVL(Comparable c, Object elemento) {
        this.clave = c;
        this.elemento = elemento;
        this.altura = 0;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public void setClave(Comparable clave){
        this.clave = clave;
    }

    public NodoAVL getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAVL hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAVL getHijoDer() {
        return hijoDer;
    }

    public Comparable getClave() {
        return clave;
    }

    public void setHijoDer(NodoAVL hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int compareTo(Comparable otro) {
        return (this.clave.compareTo(otro));
    }

    public int calcularAltura() {

        int alt = 0;

        if (this.hijoIzq != null && this.hijoDer != null) {
            alt = Math.max(this.hijoDer.getAltura(), this.hijoIzq.getAltura()) + 1;
        } else if (this.hijoIzq != null && this.hijoDer == null) {
            alt = this.hijoIzq.getAltura() + 1;
        } else if (this.hijoDer != null && this.hijoIzq == null) {
            alt = this.hijoDer.getAltura() + 1;
        }

        return alt;
    }
}
