package Test_Conjuntistas;
import Conjuntistas.ArbolBBInt;

public class TestArbolBBInt
{
    public static void main(String[]args){
        ArbolBBInt a = new ArbolBBInt();
        System.out.println("Insertar 32 como raiz: "+a.insertar(32));
        System.out.println("Insertar 56: "+a.insertar(56));
        System.out.println("Insertar 9: "+a.insertar(9));
        System.out.println("Insertar 5: "+a.insertar(5));
        System.out.println("Insertar 43: "+a.insertar(43));
        System.out.println("Insertar 19: "+a.insertar(19));
        System.out.println("Insertar 72: "+a.insertar(72));
        System.out.println("Insertar 17: "+a.insertar(17));
        System.out.println("Insertar 8: "+a.insertar(8));
        System.out.println("Insertar 41: "+a.insertar(41));
        System.out.println("Insertar 53: "+a.insertar(53));
        System.out.println("Insertar 23: "+a.insertar(23));
        System.out.println("Insertar 69: "+a.insertar(69));
        System.out.println("Insertar 80: "+a.insertar(80));
        System.out.println("Insertar 1: "+a.insertar(1));
        
        ArbolBBInt c = a.clonar();
        System.out.println("El clon es: "+c.aString());
        
        System.out.println("El elemento 69 pertenece al arbol? "+a.pertenece(69));
        System.out.println("El elemento 100 pertenece al arbol? "+a.pertenece(100));
        
        System.out.println("Listar el arbol: "+a.listar().aString());
        System.out.println("El elemento minimo es: "+a.minimoElem());
        System.out.println("El elemento maximo es: "+a.maximoElem());
        System.out.println("Listar rango (8 - 44): "+a.listarRango(8, 44).aString());
        System.out.println("El arbol es: "+a.aString());
        
        System.out.println("Eliminar 1: "+a.eliminar(1));
        System.out.println("Listar el arbol: "+a.listar().aString());
        System.out.println("El arbol ahora es: "+a.aString());
        System.out.println("Eliminar 5: "+a.eliminar(5));
        System.out.println("Listar el arbol: "+a.listar().aString());
        System.out.println("Eliminar 56: "+a.eliminar(56));
        System.out.println("Listar el arbol: "+a.listar().aString());
        
        
        
    }
}
