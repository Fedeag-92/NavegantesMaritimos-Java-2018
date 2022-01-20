package Test_Lineales;

import Lineales_Dinamicas.*;
import utiles.TecladoIn;

public class TestTP1
{

    public static void main(String[] args)
    {
        ColaInt cola = new ColaInt();
        int opcion, i = 0, longitud = -1;
        boolean vCadena = false, cadenaIngresada = false;
        /*La variable verificaCadena la utilizo para verificar si la cadena ingresada es valida
        cualquier caracter que sea distinto de 0,1,2,3,4,5,6,7,8,9 va a provocar error.
        La variable cadenaIngresada la utilizo para poder entrar al case 2 y case 3 del switch(opcion)
        ya que si no fue ingresada la cadena no se permite operar en ninguno de los dos casos.*/

        System.out.println("                       TEST TP 1");
        System.out.println("                       ¯¯¯¯¯¯¯¯¯");
        String cadena = "";

        do
        {
            menuOpciones(cadena, vCadena, cadenaIngresada);
            System.out.println("Ingrese una opcion: ");
            opcion = TecladoIn.readLineInt();
            
                switch (opcion)
                {
                    case 1:
                        vCadena = false;
                        System.out.println("Ingrese una cadena: ");
                        cadena = TecladoIn.readLine();

                        vCadena = verificaCadena(cadena, i, vCadena);

                        cadenaIngresada = verificaCondicionesCadena(cadena, vCadena, cadenaIngresada);

                        break;

                    case 2:
                        longitud = ingresaLongitud(cadena, cadenaIngresada, longitud);

                        break;
                        
                    case 3:
                        cola = creaCola(cola, cadena, longitud, cadenaIngresada);

                        break;
                        
                    case 4:
                        mostrarCola(cola); 
                        
                        break;
                        
                    case 0: System.out.println("FIN DEL TEST.");
                    
                        break;
                    default: System.out.println("Error, opcion incorrecta.");
                }
        }
        while (opcion != 0);
    }

    public static void menuOpciones(String c, boolean b, boolean v)
    {
        //Las alternativas son para mostrar diferentes carteles nomas.
        System.out.println("█████████████████████████████████");
        if("".equals(c) || v != true)
            System.out.println("(1) Ingresar una cadena solo con digitos(0 al 9).");
        else 
            System.out.println("(1) Ingresar una cadena nueva.");
        if (!"".equals(c) && b != true)
            System.out.println("(2) Ingresar una longitud(menor o igual a " + c.length() + " y mayor o igual a 0).");
        else
            System.out.println("(2) Ingrese una longitud.");
        System.out.println("(3) Generar cola.");
        System.out.println("(4) Mostrar cola.");
        System.out.println("(0) Terminar test.");
        System.out.println("█████████████████████████████████");
    }

    public static boolean verificaCadena(String cadena, int i, boolean verificaCadena)
    {
        int longitudC = cadena.length();
        i = 0;

        while (i < longitudC && !verificaCadena) 
        //Recorre la cadena verificando caracter por caracter si un digito permitido
            
        {
            
            if (cadena.charAt(i) == '0' || cadena.charAt(i) == '1'
                || cadena.charAt(i) == '2' || cadena.charAt(i) == '3'
                || cadena.charAt(i) == '4' || cadena.charAt(i) == '5'
                || cadena.charAt(i) == '6' || cadena.charAt(i) == '7'
                || cadena.charAt(i) == '8' || cadena.charAt(i) == '9')
                
                i++;
           
            else
                verificaCadena = true;
        }
        return verificaCadena;
    }

    public static boolean verificaCondicionesCadena(String cadena, boolean vCadena, boolean cadenaIngresada)
    {
        if ("".equals(cadena)) //Condicion para no aceptar cadenas nulas.
            System.out.println("Error, la cadena ingresada no debe ser nula.");
        

        else if (vCadena != false) //Condicion para aceptar cadenas con digitos del 0 al 9.
            System.out.println("Error, la cadena debe contener solo digitos(0 al 9).");
        

        else
        {
            System.out.println("CADENA CORRECTA.");
            cadenaIngresada = true;
        }
        return cadenaIngresada;
    }

    public static int ingresaLongitud(String cadena, boolean cadenaIngresada, int longitud)
    {
        if (cadenaIngresada == true)/*solo se podra ingresar la longitud una vez creada la cadena, 
                                     en caso contrario no se sabria el limite de la longitud a ingresar.*/
        {
            System.out.println("Ingrese una longitud: ");
            longitud = TecladoIn.readLineInt();

            if (longitud > cadena.length() && longitud != 1) //la longitud debe ser menor a la de la cadena.
                System.out.println("Error, la longitud ingresada es mayor que la longitud de la cadena.");
            else if 
                    (longitud <= 0)System.out.println("Error, la longitud debe ser mayor que 0.");
            else
                System.out.println("LONGITUD CORRECTA.");
        }
        else
            System.out.println("Error, primero debe ingresar una cadena(opcion 1).");
        
        return longitud;
    }

    public static ColaInt creaCola(ColaInt c, String cadena, int longitud, boolean cadenaIngresada) //genera la cola verificando previamente las condiciones.
    {
        if (cadenaIngresada == true) //Es la misma condicion que el case 2.
        {
            if (longitud != -1) /*la longitud inicializa en 0, si ingresa directamente al case 3 da error,
                                  para generar la cadena es necesario de los dos parametros, la cadena y la longitud.*/
            {
                if (longitud > 0)
                {
                    generarColaTP1 gC = new generarColaTP1();
                    
                    c = gC.generarCola(cadena, longitud);
                    System.out.println("Cola generada.");
                }
                else
                    System.out.println("Error, la longitud debe ser mayor que 0");
            }
            else
                System.out.println("Error, primero debe ingresar una longitud(opcion 2).");
        }
        else
            System.out.println("Error, primero debe ingresar una cadena(opcion 1).");
        
        return c;
    }
    
    public static void mostrarCola(ColaInt c){
        if (!c.esVacia())
            System.out.println("La cola generada es: " + c.aString());
        else
            System.out.println("Error, primero debe generar la cola.");          
    }

}
