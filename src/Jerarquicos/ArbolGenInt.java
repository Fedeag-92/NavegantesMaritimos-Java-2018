
package Jerarquicos;

import Nodos.NodoArbolGenInt;

import Lineales_Dinamicas.ListaInt;
import Lineales_Dinamicas.ColaNodoGenerico;
import Lineales_Dinamicas.Lista;

public class ArbolGenInt {

    private NodoArbolGenInt raiz;

    public ArbolGenInt() {
        this.raiz = null;
    }

    public boolean insertar(int elemN, int elemPadre) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoArbolGenInt(elemN);
        } else {
            NodoArbolGenInt nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (nodoPadre.getHijoIzquierdo() == null) {
                    nodoPadre.setHijoIzquierdo(new NodoArbolGenInt(elemN));
                } else {
                    NodoArbolGenInt hijo = nodoPadre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoArbolGenInt(elemN));
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbolGenInt obtenerNodo(NodoArbolGenInt n, int buscado) //se utiliza para saber el nodo padre
    {
        NodoArbolGenInt resultado = null;
        if (n != null) {
            if (n.getElem() == buscado) {
                resultado = n;
            } else {   //Si n no es = a buscado, busca primero en H.I
                resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
                if (resultado == null)//si es igual a null, es porque en el izquierdo no lo encontro
                {
                    resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
                }
            }
        }

        return resultado;
    }

    public boolean pertenece(int elem) {
        boolean seEncuentra = false;

        if (this.raiz != null) {
            seEncuentra = perteneceAux(this.raiz, elem, seEncuentra);
        }

        return seEncuentra;
    }

    private boolean perteneceAux(NodoArbolGenInt n, int elem, boolean esta) {
        if (n != null) {
            if (n.getElem() == elem) {
                esta = true;
            } else {
                esta = perteneceAux(n.getHermanoDerecho(), elem, esta);

                esta = perteneceAux(n.getHijoIzquierdo(), elem, esta);
            }
        }

        return esta;
    }

    public ListaInt ancestros(int elem) {
        ListaInt listaAncestros = new ListaInt();

        ancestrosAux(this.raiz, listaAncestros, elem);

        return listaAncestros;
    }

    private boolean ancestrosAux(NodoArbolGenInt n, ListaInt l, int elem) {

        boolean encontrado = false;

        if (n != null) {
            if (n.getElem() == elem) {
                l.insertar(n.getElem(), l.longitud() + 1);
                encontrado = true;
            } else {

                encontrado = ancestrosAux(n.getHijoIzquierdo(), l, elem);

                if (encontrado) {
                    l.insertar(n.getElem(), 1);
                } else {
                    NodoArbolGenInt aux = n.getHermanoDerecho();

                    while (aux != null && !encontrado) {
                        encontrado = ancestrosAux(n.getHermanoDerecho(), l, elem);
                        aux = aux.getHermanoDerecho();
                    }
                }
            }
        }
        return encontrado;
    }

    public int padre(int elem) {
        int sale = -1;

        if (this.raiz != null) {
            if (elem != this.raiz.getElem()) {
                sale = padreAux(elem, this.raiz, this.raiz, sale);
            }
        }

        return sale;
    }

    private int padreAux(int elem, NodoArbolGenInt nodoAux, NodoArbolGenInt padre, int exit) {

        if (elem == nodoAux.getElem()) {
            exit = padre.getElem();
        } else {
            if (nodoAux.getHermanoDerecho() != null) {
                exit = padreAux(elem, nodoAux.getHermanoDerecho(), padre, exit);
            }
            if (nodoAux.getHijoIzquierdo() != null) {
                exit = padreAux(elem, nodoAux.getHijoIzquierdo(), nodoAux, exit);
            }
        }

        return exit;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public void vaciar() {
        this.raiz = null;
    }

    public int altura() {
        int alt = - 1;
        if (this.raiz != null) {
            NodoArbolGenInt hijoIzq = this.raiz.getHijoIzquierdo(), hermanoDer = hijoIzq;
            int contNivel = 0, mayor = 0;

            while (hermanoDer != null) {
                hijoIzq = hermanoDer;
                while (hijoIzq != null) {
                    hijoIzq = hijoIzq.getHijoIzquierdo();
                    contNivel++;
                }
                if (mayor < contNivel) {
                    mayor = contNivel;
                }
                contNivel = 0;
                hermanoDer = hermanoDer.getHermanoDerecho();
            }
            alt = mayor;
        }

        return alt;

    }

    public int nivel(int elemento) {
        int valor = -1;
        if (this.raiz != null) {
            valor = nivel(this.raiz, elemento, 0, -1);
        }

        return valor;
    }

    private int nivel(NodoArbolGenInt n, int elem, int cont, int tot) { //busca el elemento, si no esta devuelve -1

        if (n.getElem() == elem) {
            return cont;
        }

        if (n.getHermanoDerecho() != null) {
            tot = nivel(n.getHermanoDerecho(), elem, cont, tot);
        }

        if (n.getHijoIzquierdo() != null) {
            cont++;
            tot = nivel(n.getHijoIzquierdo(), elem, cont, tot);
        }

        return tot;
    }

    public ListaInt listarPosOrden() {
        ListaInt salida = new ListaInt();

        if (this.raiz != null) {
            listarPosOrdenAux(this.raiz, salida);
        }

        return salida;
    }

    private void listarPosOrdenAux(NodoArbolGenInt n, ListaInt l) {

        if (n != null) {
            NodoArbolGenInt hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPosOrdenAux(hijo, l);
                hijo = hijo.getHermanoDerecho();
            }
            l.insertar(n.getElem(), l.longitud() + 1);
        }
    }

    public ListaInt listarPreOrden() {
        ListaInt salida = new ListaInt();

        if (this.raiz != null) {
            listarPreOrdenAux(this.raiz, salida);
        }

        return salida;
    }

    private void listarPreOrdenAux(NodoArbolGenInt n, ListaInt l) {

        if (n != null) {
            l.insertar(n.getElem(), l.longitud() + 1);

            NodoArbolGenInt hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPreOrdenAux(hijo, l);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public ListaInt listarInOrden() {
        ListaInt salida = new ListaInt();

        if (this.raiz != null) {
            listarInOrdenAux(this.raiz, salida);
        }

        return salida;
    }

    private void listarInOrdenAux(NodoArbolGenInt n, ListaInt l) {
        NodoArbolGenInt h;

        if (n != null) {
            if (n.getHijoIzquierdo() == null) {
                l.insertar(n.getElem(), l.longitud() + 1);
            } else {
                listarInOrdenAux(n.getHijoIzquierdo(), l);
                l.insertar(n.getElem(), l.longitud() + 1);
                h = n.getHijoIzquierdo().getHermanoDerecho();
                while (h != null) {
                    listarInOrdenAux(h, l);
                    h = h.getHermanoDerecho();
                }
            }
        }
    }

    public ListaInt listarPorNivel() {
        ListaInt l = new ListaInt();

        if (this.raiz != null) {
            ColaNodoGenerico cola = new ColaNodoGenerico();

            cola.poner(this.raiz);
            NodoArbolGenInt nodo;

            while (!cola.esVacia()) {
                nodo = cola.obtenerFrente();
                cola.sacar();
                l.insertar(nodo.getElem(), l.longitud() + 1);

                NodoArbolGenInt hijo = nodo.getHijoIzquierdo();

                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }

        return l;
    }

    public Lista listaQueJustificaAltura() {
        Lista lMasLarga = new Lista();

        if (this.raiz != null) {
            Lista recorrido = new Lista();
            lMasLarga = listaQueJustificaAlturaAux(this.raiz, lMasLarga, recorrido);
        }

        return lMasLarga;
    }

    private Lista listaQueJustificaAlturaAux(NodoArbolGenInt n, Lista mLarga, Lista l) {
        if (n != null) {
            l.insertar(n.getElem(), l.longitud() + 1);
            if (n.getHijoIzquierdo() == null) {
                if (l.longitud() > mLarga.longitud()) {
                    mLarga = l.clonar();
                }
            }
            mLarga = listaQueJustificaAlturaAux(n.getHijoIzquierdo(), mLarga, l);
            l.eliminar(l.longitud());
            mLarga = listaQueJustificaAlturaAux(n.getHermanoDerecho(), mLarga, l);

        }
        return mLarga;
    }
    
    public int descendienteMasLejano(int d){
        int niv = -1;
        
        if(this.raiz != null){
            niv = descendienteMasLejanoAux(this.raiz, d, 0, -1);
        }
        return niv;
    }

    private int descendienteMasLejanoAux(NodoArbolGenInt n, int d, int niv, int masLejano){
        if(n != null){
            if(n.getElem() == d && masLejano < niv){
                masLejano = niv;
            }
            niv++;
            masLejano = descendienteMasLejanoAux(n.getHijoIzquierdo(), d, niv, masLejano);
            niv--;
            masLejano = descendienteMasLejanoAux(n.getHermanoDerecho(), d, niv, masLejano);
        }
        return masLejano;
    }
    public ArbolGenInt clonar() {
        ArbolGenInt clon = new ArbolGenInt();

        if (this.raiz != null) {
            clon.raiz = clonarRecursivo(this.raiz);
        }

        return clon;
    }

    private NodoArbolGenInt clonarRecursivo(NodoArbolGenInt n) {
        NodoArbolGenInt nodo = new NodoArbolGenInt(n.getElem());
        if (n.getHijoIzquierdo() != null) {
            nodo.setHijoIzquierdo(clonarRecursivo(n.getHijoIzquierdo()));
        }
        if (n.getHermanoDerecho() != null) {
            nodo.setHermanoDerecho(clonarRecursivo(n.getHermanoDerecho()));
        }

        return nodo;
    }

    public String aString() {
        return aStringAux(this.raiz);
    }

    private String aStringAux(NodoArbolGenInt n) {
        String s = "";

        if (n != null) {
            s += n.getElem() + " -> ";

            NodoArbolGenInt hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            s = s.substring(0, s.length() - 2);

            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + aStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}
