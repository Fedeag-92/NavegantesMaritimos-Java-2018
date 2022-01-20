package Jerarquicos;

import Lineales_Dinamicas.*;
import Nodos.NodoArbolBinInt;

public class ArbolBinInt
{

    private NodoArbolBinInt raiz;

    public ArbolBinInt()
    {
        this.raiz = null;
    }

    public boolean insertar(int elemNuevo, int elemPadre, char lugar)
    {
        boolean exito = true;

        if (lugar == 'I' || lugar == 'D')
        {
            if (this.raiz == null)
            {
                this.raiz = new NodoArbolBinInt(elemNuevo); //Crea un nuevo nodo en la raiz si esta vacia
            }
            else
            { // si no esta vacio busca al nodo padre
                NodoArbolBinInt nodoPadre = obtenerNodo(this.raiz, elemPadre);

                if (nodoPadre != null)
                {
                    if (lugar == 'I' && nodoPadre.getIzquierdo() == null)//si el padre exite y no tiene H.I se lo agrega
                    {
                        nodoPadre.setIzquierdo(new NodoArbolBinInt(elemNuevo));
                    }
                    else
                    {
                        if (lugar == 'D' && nodoPadre.getDerecho() == null)
                        {
                            nodoPadre.setDerecho(new NodoArbolBinInt(elemNuevo)); //idem Izquierdo
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
        }
        else exito = false;

        return exito;
    }

    private NodoArbolBinInt obtenerNodo(NodoArbolBinInt n, int buscado) //se utiliza para saber el nodo padre
    {
        NodoArbolBinInt resultado = null;
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

    private int altura(NodoArbolBinInt nodo)
    {
        if (nodo == null)
        {
            return 0;
        }

        int caminoIzquierdo = altura(nodo.getIzquierdo()); //camino mas largo desde la izquierda del nodo actual
        int caminoDerecho = altura(nodo.getDerecho()); //camino mas largo desde la derecha del nodo actual

        if (caminoIzquierdo > caminoDerecho)
        {
            return caminoIzquierdo + 1;
        }
        return caminoDerecho + 1;
    }

    public int nivel(int elemento)
    {
        int valor = -1;
        if (!esVacio())
        {
            valor = nivel(this.raiz, elemento, 0, -1);
        }

        return valor;
    }

    private int nivel(NodoArbolBinInt nodoAux, int elem, int cont, int sale)
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
                sale = nivel(nodoAux.getIzquierdo(), elem, cont, sale);
            }
            if (nodoAux.getDerecho() != null)
            {
                sale = nivel(nodoAux.getDerecho(), elem, cont, sale);
            }

        }

        return sale;
    }

    public int padre(int elem)
    {
        int sale = -1;

        if (!esVacio())
        {
            if (elem != this.raiz.getElem())
            {
                sale = padreRecursivo(elem, this.raiz, this.raiz, sale);
            }
        }

        return sale;
    }

    private int padreRecursivo(int elem, NodoArbolBinInt nodoAux, NodoArbolBinInt padre, int exit)
    {

        if (elem == nodoAux.getElem())
        {
            exit = padre.getElem();
        }
        else
        {
            if (nodoAux.getIzquierdo() != null)
            {
                exit = padreRecursivo(elem, nodoAux.getIzquierdo(), nodoAux, exit);
            }
            if (nodoAux.getDerecho() != null)
            {
                exit = padreRecursivo(elem, nodoAux.getDerecho(), nodoAux, exit);
            }
        }

        return exit;
    }

    public ListaInt listarPreorden()
    {
        ListaInt l = new ListaInt();
        listarPreordenRecursivo(this.raiz, l);
        return l;
    }

    private void listarPreordenRecursivo(NodoArbolBinInt nodo, ListaInt l)
    {
        if (nodo != null)
        {
            l.insertar(nodo.getElem(), l.longitud() + 1);
            listarPreordenRecursivo(nodo.getIzquierdo(), l);
            listarPreordenRecursivo(nodo.getDerecho(), l);
        }
    }

    public ListaInt listarInorden()
    {
        ListaInt l = new ListaInt();
        listarInordenRecursivo(this.raiz, l);
        return l;
    }

    private void listarInordenRecursivo(NodoArbolBinInt nodo, ListaInt l)
    {
        if (nodo != null)
        {
            listarInordenRecursivo(nodo.getIzquierdo(), l);
            l.insertar(nodo.getElem(), l.longitud() + 1);
            listarInordenRecursivo(nodo.getDerecho(), l);
        }
    }

    public ListaInt listarPosorden()
    {
        ListaInt l = new ListaInt();
        listarPosordenRecursivo(this.raiz, l);
        return l;
    }

    private void listarPosordenRecursivo(NodoArbolBinInt nodo, ListaInt l)
    {
        if (nodo != null)
        {
            listarPosordenRecursivo(nodo.getIzquierdo(), l);
            listarPosordenRecursivo(nodo.getDerecho(), l);
            l.insertar(nodo.getElem(), l.longitud() + 1);
        }
    }

    public ListaInt listarPorNivel()
    {
        ListaInt l = new ListaInt();

        if (!esVacio())
        {
            ColaNodoBinario cola = new ColaNodoBinario();

            cola.poner(this.raiz);
            l.insertar(this.raiz.getElem(), l.longitud() + 1);
            NodoArbolBinInt nodo;

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
    }

    public ArbolBinInt clonar()
    {
        ArbolBinInt clon = new ArbolBinInt();

        if (!esVacio())
        {
            NodoArbolBinInt aux = this.raiz;
            clon.raiz = aux;

            clon = clonarRecursivo(aux, clon);
        }

        return clon;
    }

    private ArbolBinInt clonarRecursivo(NodoArbolBinInt n, ArbolBinInt c)
    {
        if (n.getIzquierdo() != null)
        {
            c.insertar(n.getIzquierdo().getElem(), n.getElem(), 'I');
            c = clonarRecursivo(n.getIzquierdo(), c);
        }
        if (n.getDerecho() != null)
        {
            c.insertar(n.getDerecho().getElem(), n.getElem(), 'D');
            c = clonarRecursivo(n.getDerecho(), c);
        }

        return c;
    }
    
    public ListaInt sumaRamas(){
        ListaInt l = new ListaInt();
        
        if(!this.esVacio()){
            sumaRamas(this.raiz, l, 0);
        }
        
        return l;
    }
    
    private void sumaRamas(NodoArbolBinInt n, ListaInt l, int suma){
        
        if(n != null)
            suma = suma + n.getElem();
        if(n.getIzquierdo() != null)
            sumaRamas(n.getIzquierdo(), l, suma);
        if(n.getDerecho() != null)
            sumaRamas(n.getDerecho(), l, suma);
        
        if(n.getIzquierdo() == null && n.getDerecho() == null)
            l.insertar(suma, l.longitud() + 1);
        
        suma = suma - n.getElem();
    }
    
}
