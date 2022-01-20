package Lineales_Dinamicas;
import Nodos.NodoString;

public class ListaString
{

    private NodoString cabecera;
    private int largo;

    public ListaString()
    {
        cabecera = null;
        largo = 0;
    }

    public boolean insertar(String elem, int pos)
    {

        boolean exito = true;

        if (pos < 1 || pos > largo + 1)
        {
            exito = false;
        }
        else
        {
            if (pos == 1)
            {
                this.cabecera = new NodoString(elem, this.cabecera);
            }
            //crea un nuevo nodo y lo enlaza a la cabecera
            else
            {
                NodoString aux = this.cabecera; //avanza hasta el elemento en posicion pos-1
                int i = 1;
                while (i < pos - 1)
                {
                    aux = aux.getEnlace();
                    i++;
                }
                NodoString nuevo = new NodoString(elem, aux.getEnlace()); //crea el nodo y lo enlaza
                aux.setEnlace(nuevo);
            }
            largo++;
        }
        return exito;
    }

    public boolean eliminar(int pos)
    { //dudas, pero elimina bien :|
        boolean exito = false;

        if (!this.esVacia() && pos >= 1 && pos <= largo)
        {
            if (pos == 1)
            {
                this.cabecera = this.cabecera.getEnlace();
            }
            else
            {
                NodoString aux = this.cabecera;
                int i = 1;
                while (i < pos - 1)
                {
                    aux = aux.getEnlace(); //avanza hasta el nodo de la pos-1 y corta
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace()); //enlaza el nodo 2 posiciones mas
            }
            largo--;
            exito = true;
        }
        return exito;
    }

    public String recuperar(int pos)
    {
        String sale = "";

        NodoString aux = this.cabecera;

        if (pos >= 1 && pos <= largo)
        {
            int i = 1;
            while (i < pos)
            {
                aux = aux.getEnlace();
                i++;
            }
            sale = aux.getElem();
        }
        return sale;
    }

    public int localizar(String elem)
    { //DUDAS, igual anda

        int pos = 1;
        boolean encuentra = false;
        NodoString aux = this.cabecera;
        while (aux != null && encuentra != true)
        {
            if (aux.getElem().equals(elem))
            {
                encuentra = true;
            }
            else
            {
                aux = aux.getEnlace();
                pos++;
            }
        }
        if (encuentra == false)
        {
            pos = -1;
        }
        return pos;
    }

    public void vaciar()
    {
        this.cabecera = null;
        this.largo = 0;
    }

    public boolean esVacia()
    {

        return (cabecera == null);
    }

    public ListaString clonar()
    {

        ListaString ListaClonada = new ListaString();
        NodoString aux = this.cabecera;
        int pos = 1;
        while (aux != null)
        {
            ListaClonada.insertar(aux.getElem(), pos);
            aux = aux.getEnlace();
            pos++;
        }
        return ListaClonada;
    }

    public int longitud()
    {
        return largo;
    }

    public String aString()
    {

        String cadena = "";
        NodoString aux = this.cabecera;

        while (aux != null)
        {
            cadena += "[ " + aux.getElem() + " ]";
            aux = aux.getEnlace();
        }
        return cadena;
    }

}
