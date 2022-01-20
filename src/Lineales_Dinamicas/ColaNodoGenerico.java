package Lineales_Dinamicas;
import Nodos.NodoArbolGenInt;
import Nodos.NodoEspecialGenerico;

public class ColaNodoGenerico //Cola especial usada para la cola del metedo listar por niveles del Arbol Binario.
{

    private NodoEspecialGenerico frente;
    private NodoEspecialGenerico fin;

    public ColaNodoGenerico()
    {

        frente = null;
        fin = null;
    }

    public boolean poner(NodoArbolGenInt n)
    {

        boolean exito = true;
        NodoEspecialGenerico nuevoNodo = new NodoEspecialGenerico(n);

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

    public NodoArbolGenInt obtenerFrente()
    {

        return this.frente.getElem();
    }

    public ColaNodoGenerico clonar()
    {

        ColaNodoGenerico clon = new ColaNodoGenerico();
        NodoEspecialGenerico aux = this.frente;

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
        NodoEspecialGenerico aux = this.frente;

        while (aux != null)
        {
            cadena += aux.getElem();
            aux = aux.getEnlace();
        }
        return cadena;
    }
        
    }

