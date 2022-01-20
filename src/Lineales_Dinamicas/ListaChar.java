package Lineales_Dinamicas;
import Nodos.NodoChar;

public class ListaChar {

    private NodoChar cabecera;
    private int largo;

    public ListaChar() {
        cabecera = null;
        largo = 0;
    }

    public boolean insertar(char elem, int pos) {

        boolean exito = true;

        if (pos < 1 || pos > largo + 1) 
            exito = false;
        else
        {
            if (pos == 1){
                this.cabecera = new NodoChar(elem, this.cabecera);
            largo++;
            }
                
             //crea un nuevo nodo y lo enlaza a la cabecera
            else
            {
                NodoChar aux = this.cabecera; //avanza hasta el elemento en posicion pos-1
                int i = 1;
                while (i < pos - 1)
                {
                    aux = aux.getEnlace();
                    i++;
                }
                NodoChar nuevo = new NodoChar(elem, aux.getEnlace()); //crea el nodo y lo enlaza
                aux.setEnlace(nuevo);
                largo++;
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) { //dudas, pero elimina bien :|
        boolean exito;

        if (esVacia()) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
                largo--;
            } else {
                NodoChar aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace(); //avanza hasta el nodo de la pos-1 y corta
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace()); //enlaza el nodo 2 posiciones mas
                largo--;
            }
            exito = true;
        }
        return exito;
    }

    public char recuperar(int pos)
    {
        char sale = ' ';
        
        NodoChar aux = this.cabecera;
        
        if(pos <= largo){
            int i = 1;
            while(i < pos){
                aux = aux.getEnlace();
                i++;
            }
            sale = aux.getElem();
        }
        return sale;
    }
    

    public int localizar(char elem) { //DUDAS, igual anda

        int pos = 1;
        boolean encuentra = false;
        NodoChar aux2 = this.cabecera;
        while (aux2 != null && encuentra != true) { //ver esta condicion 
            if (aux2.getElem() == elem) {
                encuentra = true;
            } else {
                aux2 = aux2.getEnlace();
                pos++;
            }
        }
        if (encuentra == false) {
            pos = -1;
        }
        return pos;
    }
    
    
    public void vaciar() {

        this.cabecera = null;
        this.largo = 0;
    }

    public boolean esVacia() {

        return (cabecera == null);
    }

    public ListaChar clonar() {

        ListaChar ListaClonada = new ListaChar();
        NodoChar aux = this.cabecera;
        int pos = 1;
        while (aux != null) {
            ListaClonada.insertar(aux.getElem(), pos);
            aux = aux.getEnlace();
            pos++;
        }
        return ListaClonada;
    }
    
    public int longitud() {
        return largo;
    }

    public String aString() {

        String cadena = "";
        NodoChar aux = this.cabecera;

        while (aux != null) {
            cadena += "[ " + aux.getElem() + " ]";
            aux = aux.getEnlace();
        }
        return cadena;
    }
    
    
}
