package Lineales_Dinamicas;
import Nodos.NodoInt;

public class PilaInt {
    private NodoInt tope;
    
    public PilaInt(){
        this.tope = null;
    }
    
    public boolean apilar(int nuevoElem){
        NodoInt nodoNuevo = new NodoInt(nuevoElem, this.tope);
        
        this.tope = nodoNuevo;
        
        return true;
    }
    
    public boolean desapilar(){
        boolean exito;
        if (!esVacia()){
            tope = tope.getEnlace();
            exito = true;
        }
        else exito = false;
        
        return exito;
    }

    public int obtenerTope(){
        int sale = -1;
        
        if(!this.esVacia()){
            sale = this.tope.getElem();
        }
        return sale;
    }

    public boolean esVacia(){
        return (tope.getEnlace() == null);
    }

    public void vaciar(){
        this.tope = null;
    }

    public PilaInt clonar(){
        PilaInt clon = new PilaInt();
        
        if (!esVacia()){
            
            clon.apilar(this.tope.getElem()); //copia el primer elemento
            NodoInt ant = clon.tope;
            
            NodoInt aux = this.tope.getEnlace(); //apunta al enlace siguiente
            
            while (aux != null){
                NodoInt nuevo = new NodoInt(aux.getElem());
                ant.setEnlace(nuevo);
                aux = aux.getEnlace(); //avanza al enlace siguiente
                ant = ant.getEnlace(); //avanza al enlace siguiente
            }
        }
        else clon = null;
        
        return clon;
        
    }

    public String aString(){
        String s;

        if(this.tope == null){
            s = "La Pila esta vacia";
        }
        else{
            s = "]";

            NodoInt aux = this.tope;

            while(aux != null){
                s = aux.getElem() + s;
                aux = aux.getEnlace();
                if(aux != null) s = "," + s;
            }
            s = "[" + s;
        }
        
        
        return s;
    }


}