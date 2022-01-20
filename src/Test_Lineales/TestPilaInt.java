package Test_Lineales;

import Lineales_Dinamicas.PilaInt;
import utiles.TecladoIn;

public class TestPilaInt {
    
        public static void main(String[] arg){
            System.out.println("PRUEBA PILA ESTÁTICA (MÁXIMO: 10 ELEMENTOS)");
            System.out.println();
            
            PilaInt p1 = new PilaInt();
            int x;
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Recupera tope: " + p1.obtenerTope());
        
            System.out.println("Desapila: " + p1.desapilar());
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Desapila: " + p1.desapilar());
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+": " + p1.apilar(x));
            System.out.println("La pila es: "+p1.aString());
            System.out.println("Recupera tope: " + p1.obtenerTope());
        
            PilaInt p2 = p1.clonar();
            System.out.println("Clon: " + p2.aString());

            while (!p1.esVacia()){
                System.out.println("Desapila pila original: " + p1.desapilar());
                System.out.println("La pila es original es: "+p1.aString());
            }
            System.out.println("Se vacio la pila original.");
            System.out.println("Desapila pila original vacia: " + p1.desapilar());
        
        
            System.out.println("Verifica clon: " + p2.aString());
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+" en el clon: " + p2.apilar(x));
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+" en el clon: " + p2.apilar(x));
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apila "+x+" en el clon: " + p2.apilar(x));
            System.out.println("Verifica clon modificado: " + p2.aString());

            System.out.println("Desapila en el clon: " + p2.desapilar());
            System.out.println("El clon es: "+p2.aString());
            System.out.println("Desapila: " + p2.desapilar());
            System.out.println("El clon es: "+p2.aString());
            System.out.println("Desapila: " + p2.desapilar());
            System.out.println("El clon es: "+p2.aString());
            System.out.println("Desapila: " + p2.desapilar());
            System.out.println("El clon es: "+p2.aString());
            System.out.println("Verifica clon modificado: " + p2.aString());
            p2.vaciar();
            System.out.println("Vacia clon, ahora es: " + p2.aString());
            System.out.println("Apila 10 elementos al azar: ");
            int i = 0;
            while (i < 10){
                p2.apilar((int) (Math.random()*50));
                i++;
            }
            System.out.println("La pila clon se lleno.");
            System.out.println("Clon es: "+p2.aString());
            System.out.println("Ingrese numero a apilar: ");
            x = TecladoIn.readLineInt();
            System.out.println("Apilar "+ x +": "+p2.apilar(x));
            System.out.println("FIN PRUEBA");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯");
            
    }
}
