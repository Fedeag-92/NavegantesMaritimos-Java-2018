package Lineales_Dinamicas;
import Nodos.NodoEspecialBinario;
import Nodos.NodoArbolBinInt;

public class ColaNodoBinario //Cola especial usada para la cola del metedo listar por niveles del Arbol Binario.
{

    private NodoEspecialBinario frente;
    private NodoEspecialBinario fin;

    public ColaNodoBinario()
    {

        frente = null;
        fin = null;
    }

    public boolean poner(NodoArbolBinInt n)
    {

        boolean exito = true;
        NodoEspecialBinario nuevoNodo = new NodoEspecialBinario(n);

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

    public NodoArbolBinInt obtenerFrente()
    {

        return this.frente.getElem();
    }

    public ColaNodoBinario clonar()
    {

        ColaNodoBinario clon = new ColaNodoBinario();
        NodoEspecialBinario aux = this.frente;

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
        NodoEspecialBinario aux = this.frente;

        while (aux != null)
        {
            cadena += aux.getElem();
            aux = aux.getEnlace();
        }
        return cadena;
    }
        
    }
