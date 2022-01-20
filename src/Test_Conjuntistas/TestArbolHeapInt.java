package Test_Conjuntistas;

import Conjuntistas.ArbolHeapMinimoInt;

public class TestArbolHeapInt
{

    public static void main(String[] args)
    {
        ArbolHeapMinimoInt arbol = new ArbolHeapMinimoInt(10);
        System.out.println("El arbol es: "+arbol.aString());
        System.out.println("La cima es: "+arbol.recuperarCima());
        System.out.println("Insertar 14: " + arbol.insertar(14));
        System.out.println("Insertar 16: " + arbol.insertar(16));
        System.out.println("Insertar 9: " + arbol.insertar(9));
        System.out.println("Insertar 7: " + arbol.insertar(7));
        System.out.println("Insertar 8: " + arbol.insertar(8));
        System.out.println("Insertar 10: " + arbol.insertar(10));
        System.out.println("Insertar 1: " + arbol.insertar(1));
        System.out.println("Insertar 3: " + arbol.insertar(3));
        System.out.println("Insertar 2: " + arbol.insertar(2));
        System.out.println("Insertar 4: " + arbol.insertar(4));
        System.out.println("La cima es: "+arbol.recuperarCima());

        System.out.println("El arbol es: " + arbol.aString());
        System.out.println("Eliminar cima: " + arbol.eliminarCima());
        System.out.println("El arbol es: " + arbol.aString());
        System.out.println("La cima es: "+arbol.recuperarCima());
        ArbolHeapMinimoInt c = arbol.clonar();
        System.out.println("El clon es: "+c.aString());
        System.out.println("Eliminar cima del clon: "+c.eliminarCima());
        System.out.println("El clon es: "+c.aString());
        arbol.vaciar();
        System.out.println("Se vacio el arbol.");
        System.out.println("El arbol es: "+arbol.aString());
        c = arbol.clonar();
        System.out.println("El clon es: "+c.aString());

    }
}
