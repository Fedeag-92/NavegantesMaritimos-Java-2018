package Lineales_Dinamicas;
import Nodos.NodoInt;

public class ColaInt
{

    private NodoInt frente;
    private NodoInt fin;

    public ColaInt()
    {

        frente = null;
        fin = null;
    }

    public boolean poner(int elem)
    {
        NodoInt nuevoNodo = new NodoInt(elem);

        if (esVacia())
        {
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
        }
        else
        { // tiene elementos
            this.fin.setEnlace(nuevoNodo);// agrega un enlace para que se almacene el nuevoNodo
            this.fin = nuevoNodo;// el nuevo nodo es el final de la cola
        }
        return true;
    }

    public boolean sacar()
    {
        boolean exito = true;

        if (this.frente == null)
        {
            exito = false;
        }
        else
        {
            this.frente = this.frente.getEnlace();

            if (this.frente == null)
            {
                this.fin = null;
            }
        }
        return exito;
    }

    public boolean esVacia()
    {

        return (frente == null);
    }

    public void vaciar()
    {

        frente = null;
        fin = null;
    }

    public int obtenerFrente()
    {
        int sale = -1;
        if(!this.esVacia()){
            sale = this.frente.getElem();
        }
        return sale;
    }

    public ColaInt clonar()
    {

        ColaInt clon = new ColaInt();
        NodoInt aux = this.frente;

        while (aux != null)
        {
            clon.poner(aux.getElem());
            aux = aux.getEnlace();
        }
        return clon;
    }

    public String aString()
    {

        String cadena = "";
        NodoInt aux = this.frente;

        while (aux != null)
        {
            cadena += aux.getElem();
            aux = aux.getEnlace();
        }
        return cadena;
    }
        
    }
