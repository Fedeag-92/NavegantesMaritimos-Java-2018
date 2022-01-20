package Lineales_Estaticas;

public class PilaInt {

    private static final int TAM=10;
    private int tope;
    private final int [] pila;

    public PilaInt(){
        pila = new int[TAM];
        tope = -1;
    }
    
    public boolean apilar(int elemento){
        boolean apilado;

        //cuando se llena la pila
        if(tope + 1 >= TAM){
            apilado = false;
                }
        else{
            tope++;
            pila[tope] = elemento;
            apilado = true;
            }

    return apilado;
        }

    public boolean desapilar(){
        boolean desapilado;

        if(tope != -1){
            tope--;
            desapilado = true;
        }
        else desapilado=false;

        return desapilado;
    }

    public int obtenerTope(){
    return pila[tope];
    }

    public boolean esVacia(){
        return (tope == -1);
    }

    public void vaciar(){
        tope=-1;
    }

    public PilaInt clonar(){
        PilaInt clon = new PilaInt();
        clon.tope = this.tope;
        for(int i = 0;i <= this.tope;i++){
            clon.pila[i] = this.pila[i];
        }
        return clon;
    }
    
    public String aString(){
        String cadena;
        
        if(esVacia()) cadena = "La pila esta vacia.";
        else {
            cadena = "[";
            int i = 0;
            while(i <= tope){
                cadena += pila[i];
                i++;
                if (i < tope + 1) cadena += ',';
            }
            cadena += "]";
        }
        
        
        return cadena;
    }
}
