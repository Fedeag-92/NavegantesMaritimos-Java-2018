package Conjuntistas;

import Nodos.NodoArbolBinInt;
import Lineales_Dinamicas.ListaInt;

public class ArbolBBInt {

    private NodoArbolBinInt raiz;

    public ArbolBBInt() {
        this.raiz = null;
    }

    public boolean insertar(int elem) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoArbolBinInt(elem);
        } else {
            exito = insertarAux(this.raiz, elem);
        }

        return exito;
    }

    private boolean insertarAux(NodoArbolBinInt n, int elem) {
        boolean exito = true;

        if ((elem == n.getElem())) {
            exito = false;
        } else if (elem < n.getElem()) {
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elem);
            } else {
                n.setIzquierdo(new NodoArbolBinInt(elem));
            }
        } else if (n.getDerecho() != null) {
            exito = insertarAux(n.getDerecho(), elem);
        } else {
            n.setDerecho(new NodoArbolBinInt(elem));
        }

        return exito;
    }

    public int minimoElem() {
        NodoArbolBinInt nodoAux = this.raiz;
        while (nodoAux.getIzquierdo() != null) {
            nodoAux = nodoAux.getIzquierdo();
        }

        return nodoAux.getElem();
    }

    public int maximoElem() {
        NodoArbolBinInt nodoAux = this.raiz;
        while (nodoAux.getDerecho() != null) {
            nodoAux = nodoAux.getDerecho();
        }

        return nodoAux.getElem();
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean pertenece(int elem) {
        return perteneceAux(this.raiz, elem, false);
    }

    private boolean perteneceAux(NodoArbolBinInt n, int elem, boolean exito) {
        if (n != null) {
            if (n.getElem() == elem) {
                exito = true;
            } else {
                if (elem < n.getElem()) {
                    exito = perteneceAux(n.getIzquierdo(), elem, false);
                } else {
                    exito = perteneceAux(n.getDerecho(), elem, false);
                }
            }
        } else {
            exito = false;
        }

        return exito;
    }

    public boolean eliminar(int elem) {
        boolean exito = eliminarAux(elem, this.raiz, true);

        return exito;
    }

    private boolean eliminarAux(int elem, NodoArbolBinInt n, boolean exito) {

        if (n != null) {
            if (n.getElem() != elem) {
                if (elem > n.getElem()) {
                    exito = eliminarAux(elem, n.getDerecho(), exito);
                } else {
                    exito = eliminarAux(elem, n.getIzquierdo(), exito);
                }

            } else {
                NodoArbolBinInt nodoPadre = obtenerNodo(this.raiz, elem);

                if (n.getIzquierdo() == null && n.getDerecho() == null) {
                    eliminarCaso1(nodoPadre, elem);
                } else if (n.getIzquierdo() != null && n.getDerecho() != null) {
                    eliminarCaso3(n, elem);
                } else {
                    eliminarCaso2(n, nodoPadre);
                }
                exito = true;
            }
        } else {
            exito = false;
        }

        return exito;
    }

    private void eliminarCaso1(NodoArbolBinInt nodoPadre, int elem) {
        if (nodoPadre.getDerecho() != null && nodoPadre.getDerecho().getElem() == elem) {
            nodoPadre.setDerecho(null);
        } else {
            nodoPadre.setIzquierdo(null);
        }
    }

    private void eliminarCaso2(NodoArbolBinInt n, NodoArbolBinInt nodoPadre) {
        if (n.getIzquierdo() != null) {
            if (nodoPadre.getIzquierdo().getElem() == n.getElem()) {
                nodoPadre.setIzquierdo(n.getIzquierdo());
            } else {
                nodoPadre.setDerecho(n.getIzquierdo());
            }
        } else {
            if (nodoPadre.getIzquierdo().getElem() == n.getElem()) {
                nodoPadre.setIzquierdo(n.getDerecho());
            } else {
                nodoPadre.setDerecho(n.getDerecho());
            }
        }
    }

    private void eliminarCaso3(NodoArbolBinInt n, int elem) {
        NodoArbolBinInt a = buscarCandidato(n.getIzquierdo());

        eliminarAux(a.getElem(), this.raiz, true);
        n.setElem(a.getElem());
    }

    private NodoArbolBinInt buscarCandidato(NodoArbolBinInt n) {
        if (n.getDerecho() != null) {
            n = buscarCandidato(n.getDerecho());
        }

        return n;
    }

    private NodoArbolBinInt obtenerNodo(NodoArbolBinInt n, int buscado) //se utiliza para saber el nodo padre
    {
        NodoArbolBinInt resultado = null;
        if (n != null) {
            if (n.getIzquierdo() != null || n.getDerecho() != null) {
                if (n.getIzquierdo().getElem() == buscado || n.getDerecho().getElem() == buscado) {
                    resultado = n;
                } else {   //Si n no es = a buscado, busca primero en H.I
                    resultado = obtenerNodo(n.getIzquierdo(), buscado);
                    if (resultado == null)//si es igual a null, es porque en el izquierdo no lo encontro
                    {
                        resultado = obtenerNodo(n.getDerecho(), buscado);
                    }
                }
            }

        }

        return resultado;
    }

    public ListaInt listar() {
        ListaInt l = new ListaInt();

        if (this.raiz != null) {
            listarAux(this.raiz, l);
        }

        return l;
    }

    private void listarAux(NodoArbolBinInt n, ListaInt l) {
        if (n != null) {
            listarAux(n.getIzquierdo(), l);
            l.insertar(n.getElem(), l.longitud() + 1);
            listarAux(n.getDerecho(), l);

        }
    }

    public ListaInt listarRango(int elemMin, int elemMax) {
        ListaInt l = new ListaInt();

        if (this.raiz != null) {

            listarRangoAux(this.raiz, l, elemMin, elemMax);

        }

        return l;
    }

    private void listarRangoAux(NodoArbolBinInt n, ListaInt l, int min, int max) {
        if (n != null) {
            if (n.getElem() > min) {
                listarRangoAux(n.getIzquierdo(), l, min, max);
            }

            if (n.getElem() >= min && n.getElem() <= max) {
                l.insertar(n.getElem(), l.longitud() + 1);
            }

            if (n.getElem() < max) {
                listarRangoAux(n.getDerecho(), l, min, max);
            }

        }
    }

    public String aString() {
        String cadena = "\n";

        if (this.raiz != null) {
            cadena = toStringAux(this.raiz, cadena);
        }

        return cadena;
    }

    private String toStringAux(NodoArbolBinInt n, String c) {

        if (n != null) {
            c = c + n.getElem();
            if (n.getIzquierdo() != null) {
                c = c + " --> " + n.getIzquierdo().getElem();
            }
            if (n.getDerecho() != null) {
                c = c + ", " + n.getDerecho().getElem();
            }
            c = c + "\n";
            c = toStringAux(n.getIzquierdo(), c);
            c = toStringAux(n.getDerecho(), c);
        }
        return c;
    }

    public ArbolBBInt clonar() {
        ArbolBBInt clon = new ArbolBBInt();
        NodoArbolBinInt a = this.raiz;
        clon.raiz = a;
        if (this.raiz != null) {
            clon.raiz = clonarAux(this.raiz);
        }

        return clon;
    }

    public void eliminarMinimo() {
        if(raiz.getIzquierdo() == null && raiz.getDerecho() == null)
            this.raiz = null;
        else if (raiz.getIzquierdo() == null && raiz.getDerecho() != null) {
            this.raiz = this.raiz.getDerecho();
        } 
        else {
            NodoArbolBinInt aux = this.raiz;
            while (aux.getIzquierdo() != null) {
                aux = aux.getIzquierdo();
            }
            if(aux.getDerecho() != null)
                aux.setIzquierdo(null);
        }

    }

    private NodoArbolBinInt clonarAux(NodoArbolBinInt n) {
        NodoArbolBinInt aux = new NodoArbolBinInt(n.getElem());

        if (n.getIzquierdo() != null) {
            aux.setIzquierdo(clonarAux(n.getIzquierdo()));
        }
        if (n.getDerecho() != null) {
            aux.setDerecho(clonarAux(n.getDerecho()));
        }

        return aux;
    }
}
