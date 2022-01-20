package Test_Lineales;

import Lineales_Estaticas.ColaInt;

import utiles.TecladoIn;

public class TestColaInt {
    
    public static void main(String[] arg){
        
        ColaInt c1 = new ColaInt();
        int x;
        System.out.println("Es vacia: "+c1.esVacia());
        System.out.println();
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("Es vacia: "+c1.esVacia());
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("La cola es: "+c1.aString());
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("La cola es: "+c1.aString());
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +": " + c1.poner(x));
        System.out.println("La cola es: "+c1.aString());
        System.out.println("El frente es: "+c1.obtenerFrente());
        System.out.println("Saca un elemento: "+c1.sacar());
        System.out.println("La cola es: "+c1.aString());
        System.out.println("Saca un elemento: "+c1.sacar());
        System.out.println("La cola es: "+c1.aString());
        ColaInt c2 = c1.clonar();
        System.out.println("Realiza clon, es: "+c2.aString());
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +" en la cola original: " + c1.poner(x));
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +" en la cola original: " + c1.poner(x));
        System.out.println("La cola original es: "+c1.aString());
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +" en la cola original: " + c1.poner(x));
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +" en la cola original: " + c1.poner(x));
        System.out.println("Ingrese elemento a poner: ");
        x = TecladoIn.readInt();
        System.out.println("Apila "+ x +" en la cola original: " + c1.poner(x));
        System.out.println("Cola original es: "+c1.aString());
        c1.vaciar();
        System.out.println("La cola original se vacio, es: "+c1.aString());
        System.out.println("Saca un elemento de cola original: "+c1.sacar());
        System.out.println("Saca un elemento de clon: "+c2.sacar());
        System.out.println("La cola clon es: "+c2.aString());
        System.out.println("El frente de clon es: "+c2.obtenerFrente());
       

    }
    
    
}
