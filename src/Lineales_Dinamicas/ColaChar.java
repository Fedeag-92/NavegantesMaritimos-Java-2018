package Lineales_Dinamicas;
import Nodos.NodoChar;

public class ColaChar
{

    private NodoChar frente;
    private NodoChar fin;

    public ColaChar()
    {
        frente = null;
        fin = null;
    }

    public boolean poner(char elem)
    {

        boolean exito = true;
        NodoChar nuevoNodo = new NodoChar(elem);

        if (esVacia())
        {
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
        }
        else
        { // tiene elementos

            this.fin.setEnlace(nuevoNodo);// agrega un enlace para que se almacene el nuevoNodo
            this.fin = nuevoNodo;// el nuevo nudo es el final de la cola
        }
        return exito;
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

    public char obtenerFrente()
    {
        char sale = ' ';
        if(!this.esVacia()){
            sale = this.frente.getElem();
        }
       return sale; 
        
    }

    public ColaChar clonar()
    {

        ColaChar clon = new ColaChar();
        NodoChar aux = this.frente;

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
        NodoChar aux = this.frente;

        while (aux != null)
        {
            cadena += aux.getElem();
            aux = aux.getEnlace();
        }
        return cadena;
    }
        
    }
