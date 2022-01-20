package Jerarquicos;

import Lineales_Dinamicas.ListaChar;
import Nodos.NodoArbolBinChar;

public class ArbolBinChar
{

    private NodoArbolBinChar raiz;

    public ArbolBinChar()
    {
        this.raiz = null;
    }

    public boolean insertar(char elemNuevo, char elemPadre, char lugar)
    {

        boolean exito = true;

        if (this.raiz == null)
        {
            this.raiz = new NodoArbolBinChar(elemNuevo); //Crea un nuevo nodo en la raiz si esta vacia
        }
        else
        { // si no esta vacio busca al nodo padre
            NodoArbolBinChar nodoPadre = obtenerNodo(this.raiz, elemPadre);

            if (nodoPadre != null)
            {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null)//si el padre exite y no tiene H.I se lo agrega
                {
                    nodoPadre.setIzquierdo(new NodoArbolBinChar(elemNuevo));
                }
                else
                {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null)
                    {
                        nodoPadre.setDerecho(new NodoArbolBinChar(elemNuevo)); //idem Izquierdo
                    }
                    else
                    {
                        exito = false; // si el padre ya tiene hijo en el lugar elegido, da error
                    }
                }
            }
            else
            {
                exito = false; // si padre es = a null, da error
            }
        }

        return exito;
    }

    private NodoArbolBinChar obtenerNodo(NodoArbolBinChar n, char buscado) //se utiliza para saber el nodo padre
    {
        NodoArbolBinChar resultado = null;
        if (n != null)
        {
            if (n.getElem() == buscado)
            {
                resultado = n;
            }
            else
            {   //Si n no es = a buscado, busca primero en H.I
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null)//si es igual a null, es porque en el izquierdo no lo encontro
                {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }

        return resultado;
    }

    public boolean esVacio()
    {
        return (raiz == null);
    }

    public int altura()
    {
        int alt = - 1;
        if (!esVacio())
        {
            alt = altura(this.raiz) - 1;
        }

        return alt;

    }

    private int altura(NodoArbolBinChar nodo)
    {
        if (nodo == null)
        {
            return 0;
        }

        int caminoIzquierdo = altura(nodo.getIzquierdo());
        int caminoDerecho = altura(nodo.getDerecho());

        if (caminoIzquierdo > caminoDerecho)
        {
            return caminoIzquierdo + 1;
        }
        return caminoDerecho + 1;
    }

    public int nivel(char elemento)
    {
        int valor = -1;
        if (!esVacio())
        {
            valor = nivel(this.raiz, elemento, 0, -1);
        }

        return valor;
    }

    private int nivel(NodoArbolBinChar nodoAux, char elem, int cont, int tot)
    { //busca el elemento, si no esta devuelve -1

        if (nodoAux.getElem() == elem)
        {
            return cont;
        }
        else
        {
            if (nodoAux.getIzquierdo() != null)
            {
                cont++;
                tot = nivel(nodoAux.getIzquierdo(), elem, cont, tot);
            }
            if (nodoAux.getDerecho() != null)
            {
                tot = nivel(nodoAux.getDerecho(), elem, cont, tot);
            }

        }

        return tot;
    }

    public char padre(char elem)
    {
        char sale = ' ';

        if (!esVacio())
        {
            if (elem != this.raiz.getElem())
            {
                sale = padreAux(elem, this.raiz, this.raiz, sale);
            }
        }

        return sale;
    }

    private char padreAux(char elem, NodoArbolBinChar nodoAux, NodoArbolBinChar padre, char exit)
    {

        if (elem == nodoAux.getElem())
        {
            exit = padre.getElem();
        }
        else
        {
            if (nodoAux.getIzquierdo() != null)
            {
                exit = padreAux(elem, nodoAux.getIzquierdo(), nodoAux, exit);
            }
            if (exit == -1 && nodoAux.getDerecho() != null)
            {
                exit = padreAux(elem, nodoAux.getDerecho(), nodoAux, exit);
            }
        }

        return exit;
    }

    public ListaChar listarPreorden()
    {
        ListaChar l = new ListaChar();
        listarPreordenAux(this.raiz, l);
        return l;
    }

    private void listarPreordenAux(NodoArbolBinChar nodo, ListaChar l)
    {

        if (nodo != null)
        {
            l.insertar(nodo.getElem(), l.longitud() + 1);
            listarPreordenAux(nodo.getIzquierdo(), l);
            listarPreordenAux(nodo.getDerecho(), l);
        }
    }

    public ListaChar listarInorden()
    {
        ListaChar l = new ListaChar();
        listarInordenAux(this.raiz, l);
        return l;
    }

    private void listarInordenAux(NodoArbolBinChar nodo, ListaChar l)
    {
        if (nodo != null)
        {
            listarInordenAux(nodo.getIzquierdo(), l);
            l.insertar(nodo.getElem(), l.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), l);
        }
    }

    public ListaChar listarPosorden()
    {
        ListaChar l = new ListaChar();
        listarPosordenAux(this.raiz, l);
        return l;
    }

    private void listarPosordenAux(NodoArbolBinChar nodo, ListaChar l)
    {
        if (nodo != null)
        {
            listarPosordenAux(nodo.getIzquierdo(), l);
            listarPosordenAux(nodo.getDerecho(), l);
            l.insertar(nodo.getElem(), l.longitud() + 1);
        }
    }

    /*public ListaChar listarPorNivel()
    {
        ListaChar l = new ListaChar();

        if (!esVacio())
        {
            ColaNodoChar cola = new ColaNodoChar();

            cola.poner(this.raiz);
            l.insertar(this.raiz.getElem(), l.longitud() + 1);
            NodoArbolBinChar nodo;

            while (!cola.esVacia())
            {
                nodo = cola.obtenerFrente();
                cola.sacar();

                if (nodo.getIzquierdo() != null)

                {
                    l.insertar(nodo.getIzquierdo().getElem(), l.longitud() + 1);
                    cola.poner(nodo.getIzquierdo());

                }

                if (nodo.getDerecho() != null)

                {
                    l.insertar(nodo.getDerecho().getElem(), l.longitud() + 1);
                    cola.poner(nodo.getDerecho());
                }

            }
        }

        return l;
    }*/

    public ArbolBinChar clonar()
    {
        ArbolBinChar clon = new ArbolBinChar();

        if (!esVacio())
        {
            NodoArbolBinChar aux = this.raiz;
            clon.raiz = aux;

            clon = clonar(aux, clon);
        }

        return clon;
    }

    private ArbolBinChar clonar(NodoArbolBinChar n, ArbolBinChar c)
    {
        if (n.getIzquierdo() != null)
        {
            c.insertar(n.getIzquierdo().getElem(), n.getElem(), 'I');
            c = clonar(n.getIzquierdo(), c);
        }
        if (n.getDerecho() != null)
        {
            c.insertar(n.getDerecho().getElem(), n.getElem(), 'D');
            c = clonar(n.getDerecho(), c);
        }

        return c;
    }

}
