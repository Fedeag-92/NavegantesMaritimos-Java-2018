package Lineales_Dinamicas;

public class generarColaTP1
{
    public ColaInt generarCola(String s, int x) //Metodo generar cola pedido en TP1.
    {
        PilaInt p = new PilaInt();
        ColaInt colaSale = new ColaInt();
        int longitudCadena = s.length();
        
        int i = 0, k = 0;

        while (k < longitudCadena)
        {
            if(k >= longitudCadena - x) x = longitudCadena - k;
            
            while (i < x)
            {
                p.apilar(s.charAt(k) - 48);
                    i++;
                    k++;
            }
            
            i = 0;
            
            while (i < x)
                {
                    colaSale.poner(p.obtenerTope());
                    p.desapilar();
                    i++;
                }
                i = 0;

            }
         while(k < longitudCadena)
            {
                colaSale.poner(s.charAt(k) - 48);
                k++;
            }

         return colaSale;
        }

        
}
