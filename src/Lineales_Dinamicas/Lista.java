package Lineales_Dinamicas;

import Nodos.Nodo;

public class Lista {

    private Nodo cabecera;
//CONSTRUCTOR

    public Lista() {
        this.cabecera = null;
    }
//MODIFICADORAS

    public int longitud() {
        int cont = 0;
        Nodo aux = this.cabecera;
        while (aux != null) {
            aux = aux.getEnlace();
            cont++;
        }
        return cont;
    }

    public boolean insertar(Object elemento, int pos) {
        boolean exito = true;
        if (pos < 1 || this.longitud() + 1 < pos) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (this.cabecera == null || (pos < 1 || pos > this.longitud() + 1)) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                //es pos-1 ya que me paro en el nodo anterior para poder enlazar con el otro 
                //borrando el del medio
                while (i < (pos - 1) && aux != null) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public Object recuperElem(int pos) {
        Object elem = null;
        Nodo aux = this.cabecera;
        if (this.cabecera != null && !(pos < 1 || pos > this.longitud() + 1)) {
            if (pos == 1) {
                elem = this.cabecera.getElem();
            } else {
                int cont = 0;
                while (aux != null && cont < (pos - 1)) {
                    aux = aux.getEnlace();
                    cont++;
                }
                elem = aux.getElem();
            }
        }
        return elem;
    }

    public int localizar(Object elemento) {
        int pos = 1;
        boolean estado = false;
        Nodo aux = this.cabecera;
        int longitud = this.longitud();
        while (aux != null && !(estado)) {
            if (elemento == aux.getElem()) {
                estado = true;
            } else {
                pos++;
                aux = aux.getEnlace();
            }
        }
        if (!(estado)) {
            pos = -1;
        }
        return pos;
    }

    public void vaciar() {
        if (!(esVacia())) {
            while (this.cabecera != null) {
                this.cabecera = this.cabecera.getEnlace();
            }
        }
    }

    public Lista clonar() {

        //CLONAR RECURSIVO CON SU METODO PRIVADO clonAux
        Lista clon = new Lista();
        Nodo aux = this.cabecera;

        return clonAux(clon, aux);
    }

    private Lista clonAux(Lista l, Nodo aux) {
        if (aux.getEnlace() != null) {
            l = clonAux(l, aux.getEnlace());
        }
        if (aux.getEnlace() == null) {
            l.cabecera = new Nodo(aux.getElem(), null);
        } else {
            l.cabecera = new Nodo(aux.getElem(), l.cabecera);
        }
        return l;
    }

    @Override
    public String toString() {
        String cadena = "";
        Nodo aux = this.cabecera;
        while (aux != null) {
            cadena += aux.getElem() + " ";
            aux = aux.getEnlace();
        }
        return cadena;
    }
}
