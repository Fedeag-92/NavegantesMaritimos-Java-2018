package Test_Jerarquico;

import Jerarquicos.ArbolBinInt;

public class TestArbolBinInt {
    public static void main (String[]args){
        ArbolBinInt arbol = new ArbolBinInt();
        System.out.println("Con arbol vacio: ");
        System.out.print("Listar en pre-orden es: ");
        System.out.println(arbol.listarPreorden().aString());
        System.out.println("");
        System.out.print("Listar en in-orden es: ");
        System.out.println(arbol.listarInorden().aString());
        System.out.println("");
        System.out.print("Listar en pos-orden es: ");
        System.out.println(arbol.listarPosorden().aString());
        System.out.println("");
        System.out.print("Litar por nivel es: ");
        System.out.println(arbol.listarPorNivel().aString());
        System.out.println("");
        System.out.println("El padre de 1 es: "+arbol.padre(1));
        System.out.println("");
        System.out.println("La altura del arbol es: "+arbol.altura());
        System.out.println("");
        System.out.println("El nivel del elemento 1 es: "+arbol.nivel(1));
        
        ArbolBinInt arbolClon = arbol.clonar();
        
        System.out.println("El clon listado por niveles es: "+arbolClon.listarPorNivel().aString());
        System.out.println("");
        System.out.println("El arbol es vacio? "+arbol.esVacio());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Con arbol no vacio: ");
        System.out.println("Insertar 1 como raiz: "+arbol.insertar(1, 1, 'I'));
        System.out.println("Insertar 2 como hijo izquierdo de 1: "+arbol.insertar(2, 1, 'I'));
        System.out.println("Insertar 3 como hijo derecho de 1: "+arbol.insertar(3, 1, 'D'));
        System.out.println("Insertar 4 como hijo izquierdo de 2: "+arbol.insertar(4, 2, 'I'));
        System.out.println("Insertar 5 como hijo izquierdo de 3: "+arbol.insertar(5, 3, 'I'));
        System.out.println("Insertar 6 como hijo derecho de 3: "+arbol.insertar(6, 3, 'D'));
        System.out.println("Insertar 7 como hijo izquierdo de 5: "+arbol.insertar(7, 5, 'I'));
        System.out.println("Insertar 8 como hijo derecho de 5: "+arbol.insertar(8, 5, 'D'));
        System.out.println("Insertar 9 como hijo izquierdo de 7: "+arbol.insertar(9, 7, 'I'));
        System.out.println("insertar 10 como hijo izquierdo de 8: "+arbol.insertar(10, 8, 'I'));
        System.out.println("");
        System.out.println("Lista de suma de ramas es: "+arbol.sumaRamas().aString());
        System.out.print("Listar en pre-orden es: ");
        System.out.println(arbol.listarPreorden().aString());
        System.out.println("");
        System.out.print("Listar en in-orden es: ");
        System.out.println(arbol.listarInorden().aString());
        System.out.println("");
        System.out.print("Listar en pos-orden es: ");
        System.out.println(arbol.listarPosorden().aString());
        System.out.println("");
        System.out.print("Litar por nivel es: ");
        System.out.println(arbol.listarPorNivel().aString());
        System.out.println("");
        System.out.println("El padre de 1 es: "+arbol.padre(1));
        System.out.println("El padre de 2 es: "+arbol.padre(2));
        System.out.println("El padre de 3 es: "+arbol.padre(3));
        System.out.println("El padre de 4 es: "+arbol.padre(4));
        System.out.println("El padre de 5 es: "+arbol.padre(5));
        System.out.println("El padre de 6 es: "+arbol.padre(6));
        System.out.println("El padre de 7 es: "+arbol.padre(7));
        System.out.println("El padre de 8 es: "+arbol.padre(8));
        System.out.println("El padre de 9 es: "+arbol.padre(9));
        System.out.println("El padre de 10 es: "+arbol.padre(10));
        System.out.println("El padre de 11 es: "+arbol.padre(11));
        System.out.println("");
        System.out.println("La altura del arbol es: "+arbol.altura());
        System.out.println("");
        System.out.println("El nivel del elemento 1 es: "+arbol.nivel(1));
        System.out.println("El nivel del elemento 2 es: "+arbol.nivel(2));
        System.out.println("El nivel del elemento 3 es: "+arbol.nivel(3));
        System.out.println("El nivel del elemento 4 es: "+arbol.nivel(4));
        System.out.println("El nivel del elemento 5 es: "+arbol.nivel(5));
        System.out.println("El nivel del elemento 6 es: "+arbol.nivel(6));
        System.out.println("El nivel del elemento 7 es: "+arbol.nivel(7));
        System.out.println("El nivel del elemento 8 es: "+arbol.nivel(8));
        System.out.println("El nivel del elemento 9 es: "+arbol.nivel(9));
        System.out.println("El nivel del elemento 10 es: "+arbol.nivel(10));
        System.out.println("El nivel del elemento 11 es: "+arbol.nivel(11));
        System.out.println("");
        System.out.println("La lista con la suma de las ramas es: "+arbol.sumaRamas().aString());
        
        arbolClon = arbol.clonar();
        
        System.out.println("El clon listado por niveles es: "+arbolClon.listarPorNivel().aString());
        System.out.println("");
        System.out.println("El clon listado en in-orden es: "+arbolClon.listarInorden().aString());
        System.out.println("El clon es vacio? "+arbol.esVacio());
        
        
    }
}