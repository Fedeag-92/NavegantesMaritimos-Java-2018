package Test_Jerarquico;
import Jerarquicos.ArbolGenInt;

public class TestArbolGenInt
{
    public static void main(String[]args){
        ArbolGenInt arbol = new ArbolGenInt();
        
        System.out.println("Insertar 1 como raiz: "+arbol.insertar(1, 1));
        System.out.println("Insertar 2 como hijo izquierdo de 1: "+arbol.insertar(2, 1));
        System.out.println("Insertar 3 como hermano derecho de 2: "+arbol.insertar(3, 1));
        System.out.println("Insertar 4 como hermano derecho de 3: "+arbol.insertar(4, 1));
        System.out.println("Insertar 5 como hijo izquierdo de 2: "+arbol.insertar(5, 2));
        System.out.println("Insertar 6 como hijo unico de 5: "+arbol.insertar(6, 5));
        System.out.println("Insertar 7 como hijo unico de 3: "+arbol.insertar(7, 3));
        System.out.println("Insertar 8 como hijo unico de 4: "+arbol.insertar(8, 4));
        System.out.println("Insertar 9 como hijo izquierdo de 8: "+arbol.insertar(9, 8));
        System.out.println("Insertar 10 como hermano derecho de 9: "+arbol.insertar(10, 8));
        System.out.println("Insertar 11 como hermano derecho de 10: "+arbol.insertar(11, 8));
        System.out.println("Insertar 12 como hijo unico de 9: "+arbol.insertar(12, 9));
        System.out.println("Insertar 5 como hijo unico de 12: "+arbol.insertar(5, 12));
        
        System.out.println("El nivel del elemento 5 es: "+arbol.nivel(5));
        System.out.println("El nivel del elemento 3 es: "+arbol.nivel(3));
        System.out.println("El nivel del elemento 10 es: "+arbol.nivel(10));
        
        System.out.println("El padre de 4 es: "+arbol.padre(4));
        System.out.println("El padre de 5 es: "+arbol.padre(5));
        System.out.println("El padre de 8 es: "+arbol.padre(8));
        System.out.println("El padre de 3 es: "+arbol.padre(3));
        
        System.out.println("La altura del arbol es: "+arbol.altura());
        
        System.out.println("La lista con los ancestros de 9 es: "+arbol.ancestros(9).aString());
        System.out.println("La lista con los ancestros de 5 es: "+arbol.ancestros(5).aString());
        System.out.println("La lista con los ancestros de 7 es: "+arbol.ancestros(7).aString());
        System.out.println("La lista con los ancestros de 15 es: "+arbol.ancestros(15).aString());
        
        System.out.println("Listar pos orden es: "+arbol.listarPosOrden().aString());
        System.out.println("Listar pre orden es: "+arbol.listarPreOrden().aString());
        System.out.println("Listar in orden es: "+arbol.listarInOrden().aString());
        System.out.println("Listar por niveles es: "+arbol.listarPorNivel().aString());
        
        
        System.out.println("El arbol es: \n"+arbol.aString());
        System.out.println("");
        ArbolGenInt clon = arbol.clonar();
        System.out.println("El clon es: \n"+clon.aString());
        
        System.out.println("El elemento 3 pertenece al arbol? "+arbol.pertenece(3));
        System.out.println("El elemento 1 pertenece al arbol? "+arbol.pertenece(1));
        System.out.println("El elemento 9 pertenece al arbol? "+arbol.pertenece(9));
        System.out.println("El elemento 12 pertenece al arbol? "+arbol.pertenece(12));
        System.out.println("El elemento 19 pertenece al arbol? "+arbol.pertenece(19));
        System.out.println("La rama mas larga del arbol es: "+arbol.listaQueJustificaAltura().toString());
        System.out.println("El nivel del descendiente mas lejano de 5 es: "+arbol.descendienteMasLejano(5));
        System.out.println("El nivel del descendiente mas lejano de 7 es: "+arbol.descendienteMasLejano(7));
    }
}
