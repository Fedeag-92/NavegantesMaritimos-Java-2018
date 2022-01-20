package Test_Lineales;

import Lineales_Dinamicas.*;

public class TestListaInt {

    public static void main(String[] args) {

        ListaInt l1 = new ListaInt();
        ListaInt l3 = new ListaInt();
        ListaInt l4 = new ListaInt();

        System.out.println("Insertar 2): " + l1.insertar(2, 1));
        System.out.println("Insertar 5): " + l1.insertar(5, 2));
        System.out.println("Insertar 6): " + l1.insertar(6, 3));
        System.out.println("Insertar 5): " + l1.insertar(5, 4));
        System.out.println("Insertar 10): " + l1.insertar(10, 5));
        System.out.println("Eliminar impares.");
        l1.eliminarImpares();
        System.out.println("longitud: "+l1.longitud());
        System.out.println("Lista: " + l1.aString());
        System.out.println("Elimina segundo: "+l1.eliminar(2));
        System.out.println(l1.aString());
        System.out.println("localiza elemento (6), pos: " + l1.localizar(6));
        System.out.println("recuperar posicion (15), elem: " + l1.recuperar(15));
        System.out.println("localiza 10, pos: "+l1.localizar(10));
        ListaInt l2 = l1.clonar();
        System.out.println("Lista clonada: " + l2.aString());
        System.out.println("Vacia la lista clonada");
        l2.vaciar();
        System.out.println("La lista clon es: "+ l2.aString());
        System.out.println("Insertar 21 en pos 3 de lista 1: " + l1.insertar(21, 3));
        System.out.println("Lista 1: " + l1.aString());
        System.out.println("Elimina pos 3: "+l1.eliminar(3));
        System.out.println("Elimina pos 2: "+l1.eliminar(2));
        System.out.println("Elimina pos 1: "+l1.eliminar(1));
        System.out.println("Elimina pos 2: "+l1.eliminar(2));
        System.out.println(l1.aString());
        System.out.println("");
        /*System.out.println("recupera primer posicion lista 1: " + l1.recuperar(1));
        System.out.println("recupera segunnda posicion lista 1: " + l1.recuperar(2));
        System.out.println("recupera tercera posicion lista 1: " + l1.recuperar(3));
        System.out.println("recupera cuarta posicion lista 1: " + l1.recuperar(4));
        System.out.println("Localiza elemeto (21), pos: "+l1.localizar(21));
        System.out.println("Elimina: "+l1.eliminar(3));
        System.out.println("Elimina: "+l1.eliminar(2));
        System.out.println(l1.toString());*/
        System.out.println("Localiza elemento (22), pos: "+l1.localizar(22));
        System.out.println("Inserta elemento (19) en pos 2: "+l1.insertar(19, 2));
        System.out.println("Inserta elemento (10) en pos 3: "+l1.insertar(10, 3));
        System.out.println("Inserta elemento (10) en pos 4: "+l1.insertar(19, 4));
        System.out.println("Lista 1: " + l1.aString());
        System.out.println("Localiza elemento (19), pos: "+l1.localizar(19));
        System.out.println("");
        
        
        
        /*
        System.out.println("ADICIONALES:");
        System.out.println("Lista 3: " + creaLista3(l3).toString());
        System.out.println("Lista 4: " + creaLista4(l4).toString());
        System.out.println("Lista concatenada: " + concatenar(l3, l4).toString());
        System.out.println("Lista 4 invertida: " + invertir(l4).toString());
        //System.out.println("Lista intercalada: "+intercalar(l3,l4).toString());
        System.out.println("Elemento repetido: " + contarIterativo(concatenar(l3, l4)));
        System.out.println("Verifica capicua lista 3: " + esCapicua(l3));

    }

    public static ListaInt creaLista3(ListaInt l3) {

        l3.insertar(4, 1);
        l3.insertar(9, 2);
        l3.insertar(4, 3);
        return l3;
    }

    public static ListaInt creaLista4(ListaInt l4) {

        l4.insertar(10, 1);
        l4.insertar(11, 2);
        l4.insertar(4, 3);
        l4.insertar(14, 4);
        return l4;
    }

    public static ListaInt concatenar(ListaInt l3, ListaInt l4) {

        ListaInt lConcatenada = l3.clonar();
        for (int i = 1; i < l4.longitud() + 1; i++) {
            lConcatenada.insertar(l4.recuperar(i), lConcatenada.longitud() + 1);
        }
        return lConcatenada;
    }

    public static ListaInt invertir(ListaInt l4) { // anda, igual consultarlo 

        PilaInt aux = new PilaInt();
        ListaInt invertida = new ListaInt();
        for (int i = 1; i < l4.longitud() + 1; i++) {
            aux.apilar(l4.recuperar(i));
        }
        for (int j = 1; j < l4.longitud() + 1; j++) {
            invertida.insertar(aux.obtenerTope().getElem(), j);
            aux.desapilar();
        }
        return invertida;

    }

    public static ListaInt intercalar(ListaInt l3, ListaInt l4) { // VERLO

        int elem, k = 1;
        ListaInt aux = concatenar(l3, l4);
        ListaInt intercalar = new ListaInt();
        for (int i = 1; i < aux.longitud() + 1; i++) {

            if (aux.recuperar(i) > aux.recuperar(i + 1)) {
                elem = aux.recuperar(i);
                //aux.recuperar(i)=aux.recuperar(i+1);
                //aux.recuperar(i+1)=elem;
            }
            intercalar.insertar(aux.recuperar(i), k);
            k++;
        }
        return intercalar;
    }

    public static int contarIterativo(ListaInt lConcatenada) {

        int cont = 0, i = 1;
        int elem = lConcatenada.recuperar(1);
        boolean repite = false;
        while (i < lConcatenada.longitud() + 1 && !repite) {
            if (elem == lConcatenada.recuperar(i)) {
                cont++;
                repite = true;
            } else {
                i++;
            }
        }
        return cont;
    }

    public static boolean esCapicua(ListaInt l3) { //VERLO 

        boolean capicua= true;
        PilaInt aux = new PilaInt();
        for (int k = 1; k < l3.longitud()+1; k++) { 
            aux.apilar(l3.recuperar(k)); //Apila toda la estructura
        }
        for (int i = 1; i < l3.longitud()+1; i++) { //Recorre lista
            while (!capicua) { //Recorre mientras capicua sea verdadero
                if (l3.recuperar(i) == aux.obtenerTope().getElem()) { //Compara con el tope de Pila (ultimo de la lista)
                    aux.desapilar();                    
                } else {
                    capicua = false;
                }
            }
        }
        return capicua;
        }
        
    }
                */
    }
}


