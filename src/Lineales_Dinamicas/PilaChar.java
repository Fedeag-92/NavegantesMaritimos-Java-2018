package Lineales_Dinamicas;
import Nodos.NodoChar;

public class PilaChar {
    private NodoChar tope;
    
    public PilaChar(){
        this.tope = null;
    }
    
    public boolean apilar(char nuevoElem){
        NodoChar nodoNuevo = new NodoChar(nuevoElem, this.tope);
        
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

    public char obtenerTope(){
        return tope.getElem();
    }

    public boolean esVacia(){
        boolean vacia;
        
        vacia = tope.getEnlace() == null;

        return vacia;
    }

    public void vaciar(){
        tope.setEnlace(null);
    }

    public PilaChar clonar(){
        PilaChar clon = new PilaChar();
        
        if (!esVacia()){
            
            clon.apilar(this.tope.getElem()); //copia el primer elemento
            NodoChar ant = clon.tope;
            
            NodoChar aux = this.tope.getEnlace(); //apunta al enlace siguiente
            
            while (aux != null){
                NodoChar nuevo = new NodoChar(aux.getElem());
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

            NodoChar aux = this.tope;

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