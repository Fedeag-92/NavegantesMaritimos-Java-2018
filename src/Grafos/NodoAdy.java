package Grafos;

public class NodoAdy {

    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int etiqueta;

    public NodoAdy(NodoVert v) {
        this.vertice = v;
    }

    public NodoAdy(NodoVert v, int e) {
        this.vertice = v;
        this.etiqueta = e;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

}
