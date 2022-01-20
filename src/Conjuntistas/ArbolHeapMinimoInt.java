package Conjuntistas;

public class ArbolHeapMinimoInt
{

    private final int TAM;
    private final int[] tabla;
    private int ultimo;

    public ArbolHeapMinimoInt(int tamaño)
    {
        this.TAM = tamaño;
        this.tabla = new int[TAM];
        this.ultimo = 0;
    }

    public boolean insertar(int elemN)
    {
        boolean exito = true;
        if (ultimo < TAM)
        {
            int aux, ultimoAux = ultimo;
            tabla[ultimo] = elemN;
            while (tabla[ultimoAux] < tabla[ultimoAux / 2] && ultimoAux != 0)
            {
                aux = tabla[ultimoAux];
                tabla[ultimoAux] = tabla[ultimoAux / 2];
                tabla[ultimoAux / 2] = aux;
                ultimoAux = ultimoAux / 2;
            }
            ultimo++;
        }

        else
        {
            exito = false;
        }

        return exito;
    }

    public boolean eliminarCima()
    {
        boolean exito;
        if (ultimo == 0)
        {
            exito = false;
        }
        else
        {
            this.ultimo--;
            this.tabla[0] = this.tabla[ultimo];
            this.tabla[ultimo] = 0;
            hacerBajar(0);
            exito = true;
        }
        return exito;
    }
    
    private void hacerBajar(int pos){
        int hijoMenor;
        int temp = this.tabla[pos];
        boolean salir = false;
        
        while(!salir)
        {
            hijoMenor = pos * 2 + 1;
            if(hijoMenor <= this.ultimo)
            {
                if(hijoMenor < this.ultimo)
                {
                    if(this.tabla[hijoMenor + 1] < this.tabla[hijoMenor])
                    {
                        hijoMenor++;
                    }
                }
                if(this.tabla[hijoMenor] != 0 && this.tabla[hijoMenor] < temp)
                {
                    this.tabla[pos] = this.tabla[hijoMenor];
                    pos = hijoMenor;
                }
                else
                {
                    salir = true;
                }
                
            } else
                {
                salir = true;
                }
            
        }
        this.tabla[pos] = temp;
    }

    public boolean esVacio()
    {
        return (this.ultimo == 0);
    }
    
    public void vaciar(){
        this.ultimo = 0;
        for (int i = 0; i < ultimo; i++)
        {
            this.tabla[i] = 0;
        }
    }
    
    public int recuperarCima(){
        int sale = -1;
        if(ultimo != 0) sale = this.tabla[0];
        return sale;
    }

    public String aString()
    {
        String cadena;
        if (ultimo == 0)
        {
            cadena = "El arbol esta vacio.";
        }
        else
        {
            cadena = "\n";
            int i = 0;
            while (i < TAM / 2)
            {
                if (tabla[2 * i + 1] != 0) cadena += tabla[i];
                if ((2 * i) + 1 < TAM && tabla[(2 * i) + 1] != 0)
                {
                    cadena = cadena + " --> " + tabla[(2 * i) + 1];
                }
                if ((2 * i) + 2 < TAM && tabla[(2 * i) + 2] != 0)
                {
                    cadena = cadena + ", " + tabla[(2 * i) + 2];
                }
                cadena += "\n";
                i++;
            }
        }
        return cadena;
    }
    
    public ArbolHeapMinimoInt clonar(){
        ArbolHeapMinimoInt clon = new ArbolHeapMinimoInt(TAM);
        clon.ultimo = this.ultimo;
        
        for (int i = 0; i < TAM; i++)
        {
            clon.tabla[i] = this.tabla[i];
        }
        
        return clon;
    }

}
