package Conjuntistas;

import Lineales_Dinamicas.Lista;
import Nodos.NodoAVL;

public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertar(Comparable key, Object elemento) {
        boolean estado = false;

        if (!pertenece(key)) {
            if (this.raiz == null) { //En caso de que el arbol este vacio el nodo a insertar sera el nodo raiz.
                this.raiz = new NodoAVL(key, elemento);
                estado = true;
            } else { //En caso contrario, se creara el nodo y se utilizara un metodo privado recursivo el cual se encargara de insertar el nodo de manera balanceada.
                NodoAVL temp = insertarAux(this.raiz, elemento, key);
                if (temp != null) {
                    this.raiz = temp;
                    estado = true;
                }
            }
        }
        return estado;
    }

    private NodoAVL insertarAux(NodoAVL nodo, Object elemento, Comparable key) {

        NodoAVL aux;

        if (nodo.compareTo(key) != 0) {

            if (nodo.compareTo(key) < 0) { //Verifico en que rama deberia ir el nuevo nodo, en este caso hacia la derecha
                if (nodo.getHijoDer() == null) { //Si hay lugar en la rama derecha lo inserto como hijo derecho
                    nodo.setHijoDer(new NodoAVL(key, elemento));
                } else { //Si no hay lugar, reposiciono el nodo derecho
                    aux = insertarAux(nodo.getHijoDer(), elemento, key);
                    nodo.setHijoDer(aux);
                }

            } else if (nodo.compareTo(key) > 0) {  //Verifico en que rama deberia ir el nuevo nodo, en este caso hacia la izquierda
                if (nodo.getHijoIzq() == null) { //Si hay lugar en la rama izquierda lo inserto como hijo izquierdo
                    nodo.setHijoIzq(new NodoAVL(key, elemento));
                } else { //Si no hay lugar, reposiciono el nodo izquierdo
                    aux = insertarAux(nodo.getHijoIzq(), elemento, key);
                    nodo.setHijoIzq(aux);
                }
            }

            nodo.setAltura(nodo.calcularAltura());
            if (this.balance(nodo) > 1 || this.balance(nodo) < -1) { //Comprobamos el balance del arbol una vez insertado el nodo 
                nodo = balancear(nodo);                          // y lo balanceamos en caso de ser necesario
            }
        }
        return nodo;
    }

    private NodoAVL balancear(NodoAVL aux) {
        NodoAVL reemplazado1;
        NodoAVL reemplazado2;

        if (aux != null) {
            if (this.balance(aux) == -2) {
                if (this.balance(aux.getHijoDer()) == 1) {//Rotacion doble derecha izquierda
                    NodoAVL hijoDer = aux.getHijoDer();
                    reemplazado1 = this.rotacionSimpleDer(hijoDer);
                    hijoDer = reemplazado1;
                    aux.setHijoDer(hijoDer);
                    aux = this.rotacionSimpleIzq(aux);
                } else {//Rotacion simple izquierda
                    aux = this.rotacionSimpleIzq(aux);

                }
            } else if (this.balance(aux) == 2) {
                if (this.balance(aux.getHijoIzq()) == -1) {//Rotacion doble izquierda derecha
                    NodoAVL hijoIzq = aux.getHijoIzq();
                    reemplazado2 = this.rotacionSimpleIzq(hijoIzq);
                    hijoIzq = reemplazado2;
                    aux.setHijoIzq(hijoIzq);
                    aux = this.rotacionSimpleDer(aux);
                } else {//Rotacion simple derecha
                    reemplazado1 = this.rotacionSimpleDer(aux);
                    aux = reemplazado1;
                }
            }
        }
        return aux;
    }

    //METODO QUE ME DEVUELVE EL BALANCE DEL NODO
    /*Es largo porque JAVA al no hacer la cuenta 0-(-1)=1 lo redefino*/
    private int balance(NodoAVL nodo) {

        int alt1 = -1, alt2 = -1, bal = 0;
        if (nodo.getHijoIzq() != null || nodo.getHijoDer() != null) {
            if (nodo.getHijoIzq() != null) {
                alt1 = nodo.getHijoIzq().getAltura();
            }
            if (nodo.getHijoDer() != null) {
                alt2 = nodo.getHijoDer().getAltura();
            }
            bal = alt1 - alt2;
        }
        return bal;
    }

    //METODO PARA HACER LA ROTACION IZQUIERDA
    private NodoAVL rotacionSimpleIzq(NodoAVL nodo) {
        NodoAVL h = nodo.getHijoDer();
        NodoAVL temp = h.getHijoIzq();
        h.setHijoIzq(nodo);
        nodo.setHijoDer(temp);
        nodo.setAltura(nodo.calcularAltura());
        h.setAltura(h.calcularAltura());
        return h;
    }

    //METODO PARA HACER LA ROTACION DERECHA
    private NodoAVL rotacionSimpleDer(NodoAVL nodo) {
//      Rotacion Simple Der
        NodoAVL h = nodo.getHijoIzq();
        NodoAVL temp = h.getHijoDer();
        h.setHijoDer(nodo);
        nodo.setHijoIzq(temp);
        nodo.setAltura(nodo.calcularAltura());
        h.setAltura(h.calcularAltura());
        return h;
    }

    public boolean pertenece(Comparable key) {

        return perteneceAux(false, this.raiz, key);
    }

    private boolean perteneceAux(boolean estado, NodoAVL aux, Comparable key) {
        if (aux != null) {
            if (aux.compareTo(key) == 0) {
                estado = true;
            } else {
                if (aux.getHijoIzq() != null && !estado) {
                    estado = perteneceAux(estado, aux.getHijoIzq(), key);
                }
                if (aux.getHijoDer() != null && !estado) {
                    estado = perteneceAux(estado, aux.getHijoDer(), key);
                }

            }

        }
        return estado;
    }

    public Object recuperarElemento(Comparable key) {
        Object sale = recuperarElementoAux(this.raiz, key).getElemento();

        return sale;
    }

    private NodoAVL recuperarElementoAux(NodoAVL aux, Comparable key) {
        NodoAVL sale = null;
        if (aux != null) {
            if (aux.compareTo(key) == 0) {
                sale = aux;
            } else {
                if (aux.getHijoIzq() != null && sale == null) {
                    sale = recuperarElementoAux(aux.getHijoIzq(), key);
                }
                if (aux.getHijoDer() != null && sale == null) {
                    sale = recuperarElementoAux(aux.getHijoDer(), key);
                }
            }
        }
        return sale;
    }

    //MÉTODO ELIMINAR, SIRVE PARA ELIMINAR UN PUERTO
    public boolean eliminar(Comparable key) { //Méotodo utilizado para eliminar un nodo(Puerto) del árbol 

        boolean estado = false;

        if (perteneceAux(estado, this.raiz, key)) {

            if (this.raiz != null) {
                if ((this.raiz.compareTo(key) == 0) && (this.raiz.getHijoIzq() == null) && (this.raiz.getHijoDer() == null)) {
                    this.raiz = null;
                } else {
                    this.raiz = eliminarAux(key, this.raiz, estado);
                }

                estado = perteneceAux(estado, this.raiz, key);
            }
        }
        return estado;
    }

    private NodoAVL eliminarAux(Comparable key, NodoAVL nodo, boolean estado) {
        if (nodo != null) {
            if (nodo.compareTo(key) == 0) {
                estado = true;
                //CASO ES HOJA
                if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
                    nodo = null;
                } else {
                    //CASO TIENE UN HIJO SOLO
                    if ((nodo.getHijoIzq() != null && nodo.getHijoDer() == null) || (nodo.getHijoIzq() == null && nodo.getHijoDer() != null)) {
                        nodo = caso_2(nodo);
                    } else {
                        //CASO QUE TENGA LOS 2 HIJOS
                        if (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
                            nodo = caso_3(nodo, key);
                        }
                    }
                }
            } else {
                if (nodo.getHijoIzq() != null) {
                    nodo.setHijoIzq(eliminarAux(key, nodo.getHijoIzq(), estado));
                }
                if (nodo.getHijoDer() != null) {
                    nodo.setHijoDer(eliminarAux(key, nodo.getHijoDer(), estado));
                }
            }
        }

        if (nodo != null) {
            if (this.balance(nodo) > 1 || this.balance(nodo) < -1) {
                nodo = balancear(nodo);
            }
        }

        return nodo;
    }

    //MÉTODO caso_2 SI TIENE UN SOLO HIJO
    private NodoAVL caso_2(NodoAVL aux) {
        if (aux != null) {
            if (aux.getHijoIzq() != null) {
                aux = aux.getHijoIzq();
            } else {
                aux = aux.getHijoDer();
            }
        }
        return aux;
    }

    //MÉTODO caso_3 SI TIENE AMBOS HIJOS
    private NodoAVL caso_3(NodoAVL aux, Comparable key) {

        if (aux.compareTo(key) == 0) {
            NodoAVL c2 = candidato1(aux.getHijoIzq());
            eliminarAux(c2.getClave(), this.raiz, false);
            aux.setElemento(c2.getElemento());
            aux.setClave(c2.getClave());
        }
        return aux;
    }

    //METODO QUE DEVUELVE EL ELEMENTO MAXIMO DEL SUBARBOL IZQUIERDO
    private NodoAVL candidato1(NodoAVL aux) {
        while (aux.getHijoDer() != null) {
            aux = aux.getHijoDer();
        }
        return aux;
    }

    //METODO QUE DEVUELVE EL ELEMENTO MINIMO DEL SUBARBOL DERECHO
    private NodoAVL candidato2(NodoAVL aux) {
        while (aux.getHijoIzq() != null) {
            aux = aux.getHijoIzq();
        }
        return aux;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listar() {
        Lista l = new Lista();

        return listarAux(l, this.raiz);
    }

    private Lista listarAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getHijoIzq() != null) {
                l = listarAux(l, aux.getHijoIzq());
            }
            l.insertar(aux.getElemento(), l.longitud() + 1);
            if (aux.getHijoDer() != null) {
                l = listarAux(l, aux.getHijoDer());
            }
        }
        return l;
    }

    public Lista listarConCola() {
        Lista l = new Lista();

        return listarConColaAux(l, this.raiz);
    }

    private Lista listarConColaAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getHijoIzq() != null) {
                l = listarConColaAux(l, aux.getHijoIzq());
            }

            l.insertar(aux.getElemento(), l.longitud() + 1);
            if (aux.getHijoDer() != null) {
                l = listarConColaAux(l, aux.getHijoDer());
            }
        }
        return l;
    }

    public Lista listarRango(Comparable minimo, Comparable maximo) {
        Lista l = new Lista();
        if (minimo.compareTo(maximo) <= 0) {
            l = listarRangoAux(l, this.raiz, minimo, maximo);
        }
        return l;
    }

    private Lista listarRangoAux(Lista l, NodoAVL aux, Comparable min, Comparable max) {
        if (aux != null) {
            if (aux.compareTo(max) < 0 && aux.getHijoDer() != null) {
                l = listarRangoAux(l, aux.getHijoDer(), min, max);
            }
            if (aux.compareTo(min) >= 0 && aux.compareTo(max) <= 0) {
                //Si pongo longitud+1 me lo guarda alrevez, con el 1 los guarda en la primer pos
                l.insertar(aux.getElemento(), 1);
            }
            if (aux.compareTo(min) > 0 && aux.getHijoIzq() != null) {

                l = listarRangoAux(l, aux.getHijoIzq(), min, max);
            }
        }
        return l;
    }

    public Object minimoElem() {
        NodoAVL aux = this.raiz;
        while (aux.getHijoIzq() != null) {
            aux = aux.getHijoIzq();
        }
        return aux.getElemento();
    }

    public Object maximoElem() {
        NodoAVL aux = this.raiz;
        while (aux.getHijoDer() != null) {
            aux = aux.getHijoDer();
        }
        return aux.getElemento();
    }

    public Lista listarALtura() {
        Lista l = new Lista();

        return listarAltAux(l, this.raiz);
    }

    private Lista listarAltAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getHijoIzq() != null) {
                l = listarAltAux(l, aux.getHijoIzq());
            }
            String s = "la altura de " + aux.getElemento() + " es " + aux.getAltura() + " \n";
            l.insertar(s, l.longitud() + 1);
            if (aux.getHijoDer() != null) {
                l = listarAltAux(l, aux.getHijoDer());
            }
        }
        return l;
    }

    @Override
    public String toString() {
        return ("Formato: (altura) padre - hijo izquierdo: - hijo derecho: \n\n" + toStringAux(this.raiz));
    }

    private String toStringAux(NodoAVL n) {
        String s = "";
        if (n != null) {
            s = "(" + n.getAltura() + ") " + n.getClave() + " -";
            if (n.getHijoIzq() != null) {
                s += " H.izquierdo: " + n.getHijoIzq().getClave() + " -";
            }
            if (n.getHijoDer() != null) {
                s += " H.derecho: " + n.getHijoDer().getClave();
            }

            s += "\n";
            s += toStringAux(n.getHijoIzq());
            s += toStringAux(n.getHijoDer());
        }
        return s;
    }

    public Lista listarInorden() {
        Lista l = new Lista();
        listarInordenRecursivo(this.raiz, l);
        return l;
    }

    private void listarInordenRecursivo(NodoAVL nodo, Lista l) {
        if (nodo != null) {
            listarInordenRecursivo(nodo.getHijoIzq(), l);
            l.insertar(nodo.getElemento(), l.longitud() + 1);
            listarInordenRecursivo(nodo.getHijoDer(), l);
        }
    }
}
