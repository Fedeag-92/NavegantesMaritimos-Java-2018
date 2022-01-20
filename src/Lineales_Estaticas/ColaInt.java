package Lineales_Estaticas;

public class ColaInt {
    private final int TAM = 8;
    private final int [] cola;
    private int frente = 0;
    private int fin = 0;


    public ColaInt(){
        cola = new int [TAM];
    }

    public boolean poner (int elemento){
        boolean exito;

        if (frente == ((fin + 1) % TAM)) exito = false;

        else{
            cola[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAM;
            exito = true;
        }

        return exito;
    }

    public boolean sacar (){
        boolean exito = true;

        if (this.esVacia())
            //la cola esta vacia, reporta error
            exito = false;
        else
            this.frente = (this.frente + 1) % this.TAM;
            //al menos hay un elemento: avanza el frente (de manera circular)

        return exito;
    }

    public int obtenerFrente (){
        return cola[frente];
    }

    public boolean esVacia (){
        return (this.fin == this.frente);
    }

    public void vaciar (){
        frente = 0;
        fin = 0;
    }

    public ColaInt clonar (){

        ColaInt clon = new ColaInt();
        clon.fin = this.fin;
        clon.frente = this.frente;

        for (int i = frente; i < fin; i++){
            clon.cola[i] = cola[i];
        }

        return clon;
    }

    public String aString(){

        String cadena;
        int i = frente;
        
        if (esVacia()) cadena = "La cola esta vacia";
        else{
            cadena = "|";
            while (i != fin){
                cadena += this.cola[i] + "|";
                i = (i + 1) % TAM;    //Para que no se pase del tamaño
            }
        }
        return cadena;
    }

}
