package NavegantesMaritimos;

import utiles.TecladoIn;
import Conjuntistas.ArbolAVL;
import Grafos.GrafoEtiquetado;
import Lineales_Dinamicas.Lista;
import java.util.HashMap;
import java.util.Iterator;

public class NavegantesMaritimos {

    public static final String RESET = "\u001B[0m";
    public static final String VERIFICACION_ERROR = "\u001B[31m";
    public static final String VERIFICACION_VALIDA = "\u001B[32m";
    public static final String FONDO_NUMEROS_MENU = "\u001B[46m";
    public static final String FONDO_RESULTADO = "\u001B[43m";

//MENU PRINCIPAL, donde se crean el arbol AVL, el grafo y la tabla hash a usar, ademas de escribir el menu de opciones
    public static void main(String[] args) {
        int opc;
        ArbolAVL puertos = new ArbolAVL();
        GrafoEtiquetado rutas = new GrafoEtiquetado();
        HashMap tablaBarcos = new HashMap();
        boolean cargaHecha = false;

        do {
            System.out.println("███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
            System.out.println("MENU DE OPCIONES");
            System.out.println("███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
            System.out.println(""
                    + FONDO_NUMEROS_MENU + "║1 ║" + RESET + " Alta y baja de un puerto.\n"
                    + FONDO_NUMEROS_MENU + "║2 ║" + RESET + " Alta y baja de una ruta marítima.\n"
                    + FONDO_NUMEROS_MENU + "║3 ║" + RESET + " Alta de barcos en una Tabla Hash.\n"
                    + FONDO_NUMEROS_MENU + "║4 ║" + RESET + " Dados 2 nombres de puertos P1 y P2, mostrar todos los puertos cuyo nombre se encuentren alfabéticamente en dicho rango.\n"
                    + FONDO_NUMEROS_MENU + "║5 ║" + RESET + " Dado un barco B y 2 puertos O y D, de origen y destino respectivamente, verificar si B está en alguna dársena de O y hacer que B viaje hasta D.\n"
                    + FONDO_NUMEROS_MENU + "║6 ║" + RESET + " Dados 2 puertos, O y D, y una cantidad de millas marítimas M, verificar si existe algún camino para ir desde O hasta D y que no supere M millas en total.\n"
                    + FONDO_NUMEROS_MENU + "║7 ║" + RESET + " Dados 2 puertos O y D, devolver el camino que pasa por menos puertos desde O hasta D. El camino que debe devolver será una lista de puertos.\n"
                    + FONDO_NUMEROS_MENU + "║8 ║" + RESET + " Mostrar todos los puertos ordenados alfabéticamente.\n"
                    + FONDO_NUMEROS_MENU + "║9 ║" + RESET + " Dado un puerto P, actualizar el ingreso de barcos a las dársenas, es decir, si hay alguna dársena libre, hacer ingresar al barco que esté primero en orden de prioridad, hasta completar todas las dársenas.\n"
                    + FONDO_NUMEROS_MENU + "║10║" + RESET + " Dado un barco B, mostrar todos sus datos.\n"
                    + FONDO_NUMEROS_MENU + "║11║" + RESET + " Dado un puerto P, mostrar los barcos en espera a ingresar según la prioridad definida por el tipo de barco.\n"
                    + FONDO_NUMEROS_MENU + "║12║" + RESET + " Dados 3 puertos O, D y N, devolver un camino que pase por O y D, pero no pase por N. El camino que debe devolver es una lista de puertos.\n"
                    + FONDO_NUMEROS_MENU + "║13║" + RESET + " Dados 2 puertos O y D, devolver la menor cantidad de millas marítimas a realizar para llegar desde O hasta D.\n"
                    + FONDO_NUMEROS_MENU + "║14║" + RESET + " Listar todos los puertos que tienen barcos en espera.\n"
                    + FONDO_NUMEROS_MENU + "║15║" + RESET + " Ejecutar un “script de carga”.\n"
                    + FONDO_NUMEROS_MENU + "║16║" + RESET + " Mostrar puertos.\n"
                    + FONDO_NUMEROS_MENU + "║17║" + RESET + " Mostrar rutas.\n"
                    + FONDO_NUMEROS_MENU + "║18║" + RESET + " Mostrar barcos.\n"
                    + FONDO_NUMEROS_MENU + "║0 ║" + RESET + " SALIR.");
            System.out.println("███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
            System.out.println("INGRESE UNA OPCION: ");

            opc = TecladoIn.readLineInt();

            switch (opc) {
                case 0:
                    System.out.println(VERIFICACION_VALIDA + "SALIDA CON EXITO ✔" + RESET);
                    break;
                case 1:
                    altaObajaPuerto(rutas, puertos);
                    break;
                case 2:
                    altaObajaRuta(rutas, puertos);
                    break;
                case 3:
                    altaBarco(tablaBarcos);
                    break;
                case 4:
                    mostrarRango(puertos);
                    break;
                case 5:
                    viajarBarco(puertos, rutas, tablaBarcos);
                    break;
                case 6:
                    existeCaminoNoSupere(rutas, puertos);
                    break;
                case 7:
                    caminoMasCorto(rutas, puertos);
                    break;
                case 8:
                    mostrarPuertosAlfabeticamente(puertos);
                    break;
                case 9:
                    actualizarDarsenasPuerto(puertos, tablaBarcos);
                    break;
                case 10:
                    mostrarBarcoSeleccionado(tablaBarcos);
                    break;
                case 11:
                    mostrarColaPrioridad(puertos);
                    break;
                case 12:
                    caminoSinPuerto(rutas, puertos);
                    break;
                case 13:
                    kilometrosMinimos(rutas, puertos);
                    break;
                case 14:
                    mostrarPuertosConEspera(puertos);
                    break;
                case 15:
                    if (!cargaHecha) {
                        cargarDatos(puertos, rutas, tablaBarcos);
                        cargaHecha = true;
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, el script de carga ya se ha realizado." + RESET);
                    }
                    break;
                case 16:
                    mostrarPuertos(puertos);
                    break;
                case 17:
                    mostrarRutas(rutas);
                    break;
                case 18:
                    mostrarBarcos(tablaBarcos);
                    break;
                default:
                    System.out.println(VERIFICACION_ERROR + "✘ Error, opcion incorrecta(no esta en el menu)." + RESET);
                    break;
            }
        } while (opc != 0);
    }

    //OPCION 1 DEL MENU:
    public static void altaObajaPuerto(GrafoEtiquetado rutas, ArbolAVL puertos) {
        //Menu de opciones para indicar si es alta o baja lo solicitado.
        System.out.println("1) Dar alta de un puerto.");
        System.out.println("2) Dar baja de un puerto.");
        System.out.print("Ingrese una opcion: ");
        String nombre;
        int opc = TecladoIn.readLineInt();
        switch (opc) {
            case 1:
                System.out.print("Ingresar nombre del puerto: ");
                nombre = TecladoIn.readLine().toUpperCase();
                if (puertos.pertenece(nombre)) { //Comprobar si ya existe el puerto ingresado en el arbol AVL
                    System.out.println(VERIFICACION_ERROR + "✘ Error, ya existe un puerto con el nombre " + nombre + "." + RESET);
                } else {
                    System.out.println(VERIFICACION_VALIDA + "Puerto inexistente, se puede cargar ✔" + RESET);
                    System.out.println("Ingrese pais del puerto: ");
                    String pais = TecladoIn.readLine();
                    System.out.println("Ingrese cantdidad de darsenas disponibles: ");
                    int cantD = TecladoIn.readLineInt();
                    if (cantD >= 0) { //Comprobar si la cantidad de darsenas ingresadas es valida(positiva o 0)
                        Puerto n = new Puerto(nombre, pais, cantD);
                        puertos.insertar(nombre, n);
                        rutas.insertar(n); //Insertar puerto tanto en el arbol AVL como en el grafo
                        System.out.println(FONDO_RESULTADO + "Puerto cargado con exito." + RESET);
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, la cantidad de darsenas disponibles no puede ser negativa." + RESET);
                    }

                }
                break;
            case 2:
                if (!puertos.esVacio()) { //Comprobar si existe por lo menos un puerto en el arbol(es lo mismo que si lo compruebo con el metodo "esVacio()" del grafo)
                    System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
                    System.out.print("Ingrese el nombre del puerto a eliminar: ");
                    nombre = TecladoIn.readLine().toUpperCase();
                    if (puertos.pertenece(nombre)) { //Comprobar si existe el puerto ingresado en el arbol AVL
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        puertos.eliminar(nombre);
                        rutas.eliminarVertice(nombre); //Eliminar puerto tanto en el arbol AVL como en el grafo
                        System.out.println(FONDO_RESULTADO + "El puerto " + nombre + " se elimino con exito." + RESET);
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + nombre + "." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, no hay ningun puerto cargado, no se puede dar de baja a ninguno." + RESET);
                }
                break;
            default:
                System.out.println(VERIFICACION_ERROR + "✘ Error, opcion incorrecta." + RESET);
                break;
        }
    }

    //OPCION 2 DEL MENU:
    public static void altaObajaRuta(GrafoEtiquetado rutas, ArbolAVL puertos) {
        //Menu de opciones para indicar si es alta o baja lo solicitado.
        System.out.println("1) Dar alta de una ruta.");
        System.out.println("2) Dar baja de una ruta.");
        System.out.println("Ingrese una opcion: ");
        int opc = TecladoIn.readLineInt();
        String origen;
        String destino;

        switch (opc) {
            case 1:
                if (rutas.getOrden() > 1) { //Comprobar si existen por lo menos 2 vertices para poder crear un arco, teniendo en cuenta que no se puede crear un arco con origen y destino iguales.
                    System.out.println(VERIFICACION_VALIDA + "Existen, al menos 2, puertos ✔" + RESET);
                    System.out.print("Ingrese puerto origen: ");
                    origen = TecladoIn.readLine().toUpperCase();
                    if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        System.out.print("Ingrese puerto destino: ");
                        destino = TecladoIn.readLine().toUpperCase();
                        if (puertos.pertenece(destino)) { //Comprobar si existe el puerto ingresado en el grafo
                            System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                            if (!rutas.existeArco(origen, destino)) { //Comprobar si ya existe el arco con origen y destino ingresado
                                System.out.println(VERIFICACION_VALIDA + "Camino inexistente entre puertos, se puede cargar ✔" + RESET);
                                System.out.print("Ingrese los kilometros de la ruta: ");
                                int km = TecladoIn.readLineInt();
                                if (km >= 0) { //Comprobar si el valor de kilometros ingresado es valido(positivo)
                                    rutas.insertarArco(origen, destino, km);
                                    System.out.println(FONDO_RESULTADO + "Ruta creada exitosamente desde " + origen + " hasta " + destino + " con una distancia de " + km + "Km." + RESET);
                                } else {
                                    System.out.println(VERIFICACION_ERROR + "✘ Error, el valor de kilometros ingresado no puede ser negativo." + RESET);
                                }
                            } else {
                                System.out.println(VERIFICACION_ERROR + "✘ Error, ya existe una ruta entre " + origen + " y " + destino + RESET);
                            }
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto de destino " + destino + " no existe." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto de origen " + origen + " no existe." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, deben existir al menos 2 puertos cargados." + RESET);
                }
                break;
            case 2:
                System.out.println(VERIFICACION_VALIDA + "Existen arcos ✔" + RESET);
                System.out.print("Ingrese puerto origen: ");
                origen = TecladoIn.readLine().toUpperCase();
                if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado en el grafo
                    System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                    System.out.print("Ingrese puerto destino: ");
                    destino = TecladoIn.readLine().toUpperCase();
                    if (puertos.pertenece(destino)) { //Comprobar si existe el puerto ingresado en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (rutas.existeArco(origen, destino)) { //Comprobar si existe arco entre origen y destino
                            System.out.println(VERIFICACION_VALIDA + "Existe arco entre puertos, se puede borrar ✔" + RESET);
                            rutas.eliminarArco(origen, destino);
                            System.out.println(FONDO_RESULTADO + "La ruta entre " + origen + " y " + destino + " ha sido eliminada con exito." + RESET);
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un arco entre " + origen + " y " + destino + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto de destino " + destino + " no existe." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto de origen " + origen + " no existe." + RESET);
                }
                break;
            default:
                System.out.println(VERIFICACION_ERROR + "✘ Error, opcion incorrecta." + RESET);
                break;
        }
    }

    //OPCION 3 DEL MENU:
    public static void altaBarco(HashMap barcos) {
        System.out.print("Ingrese codigo del barco: ");
        int cod = TecladoIn.readLineInt();
        if (!barcos.containsKey(cod)) { //Comprobar si ya existe un barco con el codigo ingresado
            System.out.println(VERIFICACION_VALIDA + "Barco inexistente, se puede agregar ✔" + RESET);
            System.out.print("Ingrese el tipo de barco(0: pesquero, 1: pasajeros, 2: carga): ");
            int tipo = TecladoIn.readLineInt();
            if (tipo >= 0 && tipo <= 2) { //Comprobar si el tipo ingresado es valido, es decir, deberia ser 0, 1 o 2
                System.out.println(VERIFICACION_VALIDA + "Tipo de barco valido ✔" + RESET);
                System.out.print("Ingrese el pais del barco: ");
                String bandera = TecladoIn.readLine();
                barcos.put(cod, new Barco(cod, tipo, bandera)); //Insertar barco en la tabla Hash
                System.out.println(FONDO_RESULTADO + "Barco cargado con exito." + RESET);
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, el tipo debe ser 0, 1 o 2." + RESET);
            }

        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, el barco con el codigo " + cod + " ya existe." + RESET);
        }
    }

    //OPCION 4 DEL MENU:
    public static void mostrarRango(ArbolAVL puertos) {
        if (!puertos.esVacio()) { //Comprobar si existe por lo menos 1 puerto en el arbol AVL
            System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
            System.out.print("Ingresar el primer puerto: ");
            String p1 = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(p1)) { //Comprobar si existe el puerto ingresado en el arbol AVL
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                System.out.print("Ingrese el segundo puerto: ");
                String p2 = TecladoIn.readLine().toUpperCase();
                if (!p1.equals(p2)) {
                    if (puertos.pertenece(p2)) { //Comprobar si existe el puerto ingresado en el arbol AVL
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (p2.compareTo(p1) < 0) { //En caso de ingresar los puertos al reves se intercambian, sino la lista devuelta es vacia
                            String aux = p2;
                            p2 = p1;
                            p1 = aux;
                        }
                        //En el caso de que los puertos origen y destino sean iguales, entonces solo se imprime 1 solo puerto(origen o destino, es lo mismo)
                        System.out.println(FONDO_RESULTADO + "Los puertos que existen entre " + p1 + " y " + p2 + " ordenados alfabeticamente son: " + RESET + puertos.listarRango(p1, p2).toString());
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto " + p2 + " no existe." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + p1 + "." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto " + p1 + " no existe." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no hay ningun puerto cargado." + RESET);
        }

    }

    //OPCION 5 DEL MENU:
    public static void viajarBarco(ArbolAVL puertos, GrafoEtiquetado rutas, HashMap barcos) {
        if (rutas.getOrden() > 1) { //Comprobar si existe por lo menos 2 puertos en el grafo, dado que se necesitan 2 puertos distintos
            System.out.println(VERIFICACION_VALIDA + "Existen, al menos, 2 puertos ✔" + RESET);
            System.out.println(VERIFICACION_VALIDA + "Existe, al menos, 1 ruta ✔" + RESET);
            if (!barcos.isEmpty()) { //Comprobar si la tabla de barcos no esta vacia
                System.out.println(VERIFICACION_VALIDA + "Existen barcos cargados ✔" + RESET);
                System.out.print("Ingrese codigo del barco: ");
                int cod = TecladoIn.readInt();
                if (barcos.containsKey(cod)) { //Comprobar si existe el barco ingresado
                    System.out.println(VERIFICACION_VALIDA + "Existe barco ✔" + RESET);
                    Barco b = (Barco) barcos.get(cod);
                    System.out.print("Ingrese puerto de origen: ");
                    String origen = TecladoIn.readLine().toUpperCase();
                    if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        Puerto p1 = (Puerto) puertos.recuperarElemento(origen);
                        if (p1.existeBarco(b)) { //Comprobar si el barco ingresado anteriormente se encuentra en el puerto ingresado
                            System.out.println(VERIFICACION_VALIDA + "El barco se encuentra en el puerto ✔" + RESET);
                            System.out.print("Ingrese puerto de destino: ");
                            String destino = TecladoIn.readLine().toUpperCase();
                            if (!origen.equals(destino)) { //Comprobar si los puertos ingresados son distintos
                                if (puertos.pertenece(destino)) { //Comprobar si existe el puerto ingresado en el grafo
                                    System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                                    if (rutas.existeCamino(origen, destino)) { //Comprobar si existe un camino entre los puertos ingresados
                                        System.out.println(VERIFICACION_VALIDA + "Existe camino entre puertos ✔" + RESET);
                                        Puerto p2 = (Puerto) puertos.recuperarElemento(destino);
                                        p1.sacarBarco(b); //Primero el barco deja el puerto origen
                                        p2.ingresarBarco(b); //luego viaja hasta el puerto destino, ingresandose en la cola de prioridades
                                        System.out.println(FONDO_RESULTADO + "El barco [" + b.toString() + "] ha viajado con exito desde " + origen + " hasta " + destino + "." + RESET);
                                    } else {
                                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un camino desde " + origen + " hasta " + destino + "." + RESET);
                                    }
                                } else {
                                    System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + destino + "." + RESET);
                                }
                            } else {
                                System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + origen + "." + RESET);
                            }

                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, el barco " + cod + " no se encuentra en el puerto " + origen + "." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + origen + "." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el barco " + cod + "." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existen barcos cargados." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no hay ningun puerto cargado." + RESET);
        }
    }

    //OPCION 6 DEL MENU:
    public static void existeCaminoNoSupere(GrafoEtiquetado rutas, ArbolAVL puertos) {
        if (rutas.getOrden() > 1) { //Comprobar si existe por lo menos 2 puertos en el grafo, dado que se necesitan 2 puertos distintos
            System.out.println(VERIFICACION_VALIDA + "Existen, al menos, 2 puertos ✔" + RESET);
            System.out.println(VERIFICACION_VALIDA + "Existe, al menos, 1 ruta ✔" + RESET);
            System.out.print("Ingrese puerto origen: ");
            String origen = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado en el grafo
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                System.out.print("Ingrese puerto destino: ");
                String destino = TecladoIn.readLine().toUpperCase();
                if (!origen.equals(destino)) { //Comprobar si los puertos ingresados son distintos
                    if (puertos.pertenece(destino)) { //Comprobar si existe el puerto en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (rutas.existeCamino(origen, destino)) { //Comprobar si existe camino entre los puertos ingresados
                            System.out.println(VERIFICACION_VALIDA + "Existe camino entre puertos ✔" + RESET);
                            System.out.print("Ingrese distancia maxima en kilometros: ");
                            int km = TecladoIn.readInt();
                            if (km >= 0) { //Comprobar si los kilometros ingresados son validos(positivo)
                                if (rutas.existeCaminoMenorKm(origen, destino, km)) {
                                    System.out.println(FONDO_RESULTADO + "SI Existe un camino desde " + origen + " hasta " + destino + " que no supere los " + km + "Km." + RESET);
                                } else {
                                    System.out.println(FONDO_RESULTADO + "NO Existe un camino desde " + origen + " hasta " + destino + " que no supere los " + km + "Km." + RESET);
                                }
                            } else {
                                System.out.println(VERIFICACION_ERROR + "✘ Error, el valor de kilometros ingresado no puede ser negativo." + RESET);
                            }
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un camino desde " + origen + " hasta " + destino + "." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + destino + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + origen + "." + RESET);
                }

            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + origen + "." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 7 DEL MENU:
    public static void caminoMasCorto(GrafoEtiquetado rutas, ArbolAVL puertos) {
        if (rutas.getOrden() > 1) { //Comprobar si existe por lo menos 2 puertos en el grafo, dado que se necesitan 2 puertos distintos
            System.out.println(VERIFICACION_VALIDA + "Existen, al menos, 2 puertos ✔" + RESET);
            System.out.println(VERIFICACION_VALIDA + "Existe, al menos, 1 ruta ✔" + RESET);
            System.out.print("Ingrese puerto origen: ");
            String origen = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(origen)) { //Comprobar si existe el puerto en el grafo
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                System.out.print("Ingrese puerto destino: ");
                String destino = TecladoIn.readLine().toUpperCase();
                if (!origen.equals(destino)) { //Comprobar si los puertos ingresados son distintos
                    if (puertos.pertenece(destino)) { //Comprobar si existe el puerto en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (rutas.existeCamino(origen, destino)) { //Comprobar si existe camino entre origen y destino
                            System.out.println(VERIFICACION_VALIDA + "Existe camino entre puertos ✔" + RESET);
                            System.out.println(FONDO_RESULTADO + "El camino mas corto desde " + origen + " hasta " + destino + " es: " + RESET + rutas.caminoMasCorto(origen, destino).toString());
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un camino desde " + origen + " hasta " + destino + "." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + destino + "." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + origen + "." + RESET);
                }

            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + origen + "." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 8 DEL MENU:
    public static void mostrarPuertosAlfabeticamente(ArbolAVL puertos) {
        if (!puertos.esVacio()) { //Comprobar que exista por lo menos 1 puerto en el arbol AVL
            System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
            System.out.println(FONDO_RESULTADO + "Los puertos alfabeticamente son: " + RESET + puertos.listarInorden().toString());
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 9 DEL MENU:
    public static void actualizarDarsenasPuerto(ArbolAVL puertos, HashMap barcos) {
        if (!puertos.esVacio()) { //Comprobar que exista por lo menos 1 puerto en el arbol AVL
            System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
            if (!barcos.isEmpty()) { //Comprobar que existan barcos cargados
                System.out.println(VERIFICACION_VALIDA + "Existen barcos cargados ✔" + RESET);
                System.out.print("Ingresar puerto: ");
                String nombre = TecladoIn.readLine().toUpperCase();
                if (puertos.pertenece(nombre)) { //Comprobar si existe el puerto ingresado en el arbol AVL
                    System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                    Puerto p = (Puerto) puertos.recuperarElemento(nombre);
                    if (!p.colaVacia()) { //Comprobar si hay cola de barcos para ingresar al puerto
                        System.out.println(VERIFICACION_VALIDA + "Existe cola de barcos en puerto ✔" + RESET);
                        p.actualizarDarsenas();
                        System.out.print(FONDO_RESULTADO + "Las darsenas de " + nombre + " fueron actualizadas" + RESET);
                        if (!p.colaVacia()) {
                            System.out.println(FONDO_RESULTADO + ". Pero quedaron barcos en cola, darsenas todas ocupadas." + RESET);
                        } else {
                            System.out.println(FONDO_RESULTADO + ". Sin barcos en cola de prioridad." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no es necesario actualizar las darsenas del puerto " + nombre + ", no hay ningun barco en cola para entrar." + RESET);
                    }

                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + nombre + "." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existen barcos cargados." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 10 DEL MENU:
    public static void mostrarBarcoSeleccionado(HashMap barcos) {
        if (!barcos.isEmpty()) { //Comprobar que existan barcos cargados
            System.out.println(VERIFICACION_VALIDA + "Existen barcos cargados ✔" + RESET);
            System.out.print("Ingresar codigo del barco: ");
            int cod = TecladoIn.readLineInt();
            if (barcos.containsKey(cod)) { //Comprobar si existe el barco ingresado
                System.out.println(VERIFICACION_VALIDA + "Existe barco ✔" + RESET);
                System.out.println(FONDO_RESULTADO + "Los datos del barco son: " + RESET);
                System.out.println(barcos.get(cod).toString());
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un barco con el código " + cod + "." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen barcos cargados." + RESET);
        }
    }

    //OPCION 11 DEL MENU:
    public static void mostrarColaPrioridad(ArbolAVL puertos) {
        if (!puertos.esVacio()) { //Comprobar que exista por lo menos 1 puerto en el arbol AVL
            System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
            System.out.print("Ingresar puerto: ");
            String nombre = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(nombre)) { //Comprobar si existe el puerto en el arbol AVL
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                Puerto p = (Puerto) puertos.recuperarElemento(nombre);
                if (!p.colaVacia()) { //Comprobar si la cola esta vacia
                    System.out.println(FONDO_RESULTADO + "La cola de prioridades del puerto " + nombre + " es: " + RESET);
                    System.out.println(p.colaToString());
                } else {
                    System.out.println(FONDO_RESULTADO + "La cola de prioridades del puerto " + nombre + " esta vacia." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto " + nombre + " no existe." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 12 DEL MENU:
    public static void caminoSinPuerto(GrafoEtiquetado rutas, ArbolAVL puertos) {
        if (rutas.getOrden() > 2) { //Comprobar si existen por lo menos 3 puertos, ya que son necesarios 3 distintos
            System.out.println(VERIFICACION_VALIDA + "Existen, al menos, 3 puertos ✔" + RESET);
            System.out.println(VERIFICACION_VALIDA + "Existe, al menos, 1 ruta ✔" + RESET);
            System.out.print("Ingrese puerto origen: ");
            String origen = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                System.out.print("Ingrese puerto destino: ");
                String destino = TecladoIn.readLine().toUpperCase();
                if (!origen.equals(destino)) { //Comprobar si los puertos ingresados son distintos
                    if (puertos.pertenece(destino)) { //Comprobar si existe el puerto ingresado
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (rutas.existeCamino(origen, destino)) { //Comprobar si existe camino entre los puertos ingresados
                            System.out.print("Ingrese puerto por el que NO debe pasar: ");
                            String excepcion = TecladoIn.readLine().toUpperCase();
                            if (!excepcion.equals(origen) && !excepcion.equals(destino)) { //Comprobar si los 3 puertos ingresados son distintos
                                if (puertos.pertenece(excepcion)) { //Comprobar si existe el puerto ingresado
                                    System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                                    String l = rutas.caminoSinElemento(origen, destino, excepcion).toString();
                                    if (l.equals("")) {
                                        System.out.println(FONDO_RESULTADO + "No existe camino desde " + origen + " hasta " + destino + " sin que pase por " + excepcion + "." + RESET);
                                    } else {
                                        System.out.println(FONDO_RESULTADO + "El camino desde " + origen + " hasta " + destino + " sin que pase por " + excepcion + " es: " + RESET + l);
                                    }
                                } else {
                                    System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + excepcion + "." + RESET);
                                }
                            } else {
                                System.out.println(VERIFICACION_ERROR + "✘ Error, el puerto exceptuado deber ser distinto a los puertos de origen y destino, ambos." + RESET);
                            }
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un camino desde " + origen + " hasta " + destino + "." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + destino + "." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + origen + "." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + origen + "." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 13 DEL MENU:
    public static void kilometrosMinimos(GrafoEtiquetado rutas, ArbolAVL puertos) {
        if (!rutas.esVacio()) { //Comprobar si existe por lo menos 1 puerto en el grafo
            System.out.println(VERIFICACION_VALIDA + "Existen puertos cargados ✔" + RESET);
            System.out.println(VERIFICACION_VALIDA + "Existe, al menos, 1 arco ✔" + RESET);
            System.out.print("Ingresar puerto origen: ");
            String origen = TecladoIn.readLine().toUpperCase();
            if (puertos.pertenece(origen)) { //Comprobar si existe el puerto ingresado en el grafo
                System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                System.out.print("Ingresar puerto destino: ");
                String destino = TecladoIn.readLine().toUpperCase();
                if (!origen.equals(destino)) { //Comprobar si los puertos ingresados son distintos
                    if (puertos.pertenece(destino)) { //Comprobar si existe puerto ingresado en el grafo
                        System.out.println(VERIFICACION_VALIDA + "Existe puerto ✔" + RESET);
                        if (rutas.existeCamino(origen, destino)) { //Comprobar si existe camino entre puertos
                            System.out.println(FONDO_RESULTADO + "La cantidad de kilometros minimos que deben hacerse desde " + origen + " hasta " + destino + " es de " + rutas.caminoKilometrosMinimos(origen, destino) + "km." + RESET);
                        } else {
                            System.out.println(VERIFICACION_ERROR + "✘ Error, no existe un camino desde " + origen + " hasta " + destino + "." + RESET);
                        }
                    } else {
                        System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + destino + "." + RESET);
                    }
                } else {
                    System.out.println(VERIFICACION_ERROR + "✘ Error, los puertos origen y destino deben ser distintos. Los ingresados son ambos: " + origen + "." + RESET);
                }
            } else {
                System.out.println(VERIFICACION_ERROR + "✘ Error, no existe el puerto " + origen + "." + RESET);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }

    }

    //OPCION 14 DEL MENU:
    public static void mostrarPuertosConEspera(ArbolAVL puertos) {
        if (!puertos.esVacio()) { //Comprobar si existe por lo menos 1 puerto en el arbol AVL
            int i = 1;
            String cadena = "";
            Lista l = puertos.listar();
            while (i < l.longitud()) {
                Puerto g = (Puerto) l.recuperElem(i);
                if (!g.colaVacia()) {
                    cadena = cadena + g.getNombre() + ", ";
                }
                i++;
            }
            if (cadena.equals("")) {
                System.out.println(FONDO_RESULTADO + "No hay puertos con cola de espera." + RESET);
            } else {
                System.out.println(FONDO_RESULTADO + "Los puertos con cola de espera son: " + RESET + cadena);
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Error, no existen puertos cargados." + RESET);
        }
    }

    //OPCION 15 DEL MENU
    public static void cargarDatos(ArbolAVL puertos, GrafoEtiquetado rutas, HashMap barcos) {
        System.out.println("COMENZANDO SCRIPT DE CARGA...");
        System.out.println();
        //Creacion de puertos
        Puerto p1 = new Puerto("MADRYN", "Argentina", 10);
        System.out.println("Puerto creado: " + p1.toString());
        Puerto p2 = new Puerto("SANTOS", "Brasil", 13);
        System.out.println("Puerto creado: " + p2.toString());
        Puerto p3 = new Puerto("BARRANQUERAS", "Argentina", 1);
        System.out.println("Puerto creado: " + p3.toString());
        Puerto p4 = new Puerto("CARTAGENA", "Colombia", 7);
        System.out.println("Puerto creado: " + p4.toString());
        Puerto p5 = new Puerto("MANZANILLO", "Mexico", 19);
        System.out.println("Puerto creado: " + p5.toString());
        Puerto p6 = new Puerto("CALLAO", "Peru", 7);
        System.out.println("Puerto creado: " + p6.toString());
        Puerto p7 = new Puerto("GUAYAQUIL", "Ecuador", 10);
        System.out.println("Puerto creado: " + p7.toString());
        Puerto p8 = new Puerto("KINGSTON", "Jamaica", 5);
        System.out.println("Puerto creado: " + p8.toString());
        Puerto p9 = new Puerto("BUENOS AIRES", "Argentina", 10);
        System.out.println("Puerto creado: " + p9.toString());
        Puerto p10 = new Puerto("FREEPORT", "Bahamas", 10);
        System.out.println("Puerto creado: " + p10.toString());
        Puerto p11 = new Puerto("BUSAN", "Corea", 11);
        System.out.println("Puerto creado: " + p11.toString());
        Puerto p12 = new Puerto("RASHID", "Dubai", 4);
        System.out.println("Puerto creado: " + p12.toString());
        Puerto p13 = new Puerto("TIANJIN", "Pekín ", 3);
        System.out.println("Puerto creado: " + p13.toString());
        Puerto p14 = new Puerto("HONG KONG", "Hong Kong", 8);
        System.out.println("Puerto creado: " + p14.toString());
        Puerto p15 = new Puerto("SHENZHEN", "China", 12);
        System.out.println("Puerto creado: " + p15.toString());
        System.out.println(VERIFICACION_VALIDA + "Puertos creados ✔" + RESET);
        System.out.println();

        //Puertos insertados en el arbol AVL de puertos
        System.out.println("Insertar puerto " + p1.getNombre() + " en arbol AVL: " + puertos.insertar("MADRYN", p1));
        System.out.println("Insertar puerto " + p2.getNombre() + " en arbol AVL: " + puertos.insertar("SANTOS", p2));
        System.out.println("Insertar puerto " + p3.getNombre() + " en arbol AVL: " + puertos.insertar("BARRANQUERAS", p3));
        System.out.println("Insertar puerto " + p4.getNombre() + " en arbol AVL: " + puertos.insertar("CARTAGENA", p4));
        System.out.println("Insertar puerto " + p5.getNombre() + " en arbol AVL: " + puertos.insertar("MANZANILLO", p5));
        System.out.println("Insertar puerto " + p6.getNombre() + " en arbol AVL: " + puertos.insertar("CALLAO", p6));
        System.out.println("Insertar puerto " + p7.getNombre() + " en arbol AVL: " + puertos.insertar("GUAYAQUIL", p7));
        System.out.println("Insertar puerto " + p8.getNombre() + " en arbol AVL: " + puertos.insertar("KINGSTON", p8));
        System.out.println("Insertar puerto " + p9.getNombre() + " en arbol AVL: " + puertos.insertar("BUENOS AIRES", p9));
        System.out.println("Insertar puerto " + p10.getNombre() + " en arbol AVL: " + puertos.insertar("FREEPORT", p10));
        System.out.println("Insertar puerto " + p11.getNombre() + " en arbol AVL: " + puertos.insertar("BUSAN", p11));
        System.out.println("Insertar puerto " + p12.getNombre() + " en arbol AVL: " + puertos.insertar("RASHID", p12));
        System.out.println("Insertar puerto " + p13.getNombre() + " en arbol AVL: " + puertos.insertar("TIANJIN", p13));
        System.out.println("Insertar puerto " + p14.getNombre() + " en arbol AVL: " + puertos.insertar("HONG KONG", p14));
        System.out.println("Insertar puerto " + p15.getNombre() + " en arbol AVL: " + puertos.insertar("SHENZHEN", p15));
        System.out.println("Insertar puerto " + p15.getNombre() + " en arbol AVL: " + puertos.insertar("SHENZHEN", p15));
        System.out.println(VERIFICACION_VALIDA + "Puertos insertados en arbol AVL ✔" + RESET);
        System.out.println();

        //Puertos insertados en el grafo de rutas
        System.out.println("Insertar puerto " + p1.getNombre() + " en grafo: " + rutas.insertar(p1));
        System.out.println("Insertar puerto " + p2.getNombre() + " en grafo: " + rutas.insertar(p2));
        System.out.println("Insertar puerto " + p3.getNombre() + " en grafo: " + rutas.insertar(p3));
        System.out.println("Insertar puerto " + p4.getNombre() + " en grafo: " + rutas.insertar(p4));
        System.out.println("Insertar puerto " + p5.getNombre() + " en grafo: " + rutas.insertar(p5));
        System.out.println("Insertar puerto " + p6.getNombre() + " en grafo: " + rutas.insertar(p6));
        System.out.println("Insertar puerto " + p7.getNombre() + " en grafo: " + rutas.insertar(p7));
        System.out.println("Insertar puerto " + p8.getNombre() + " en grafo: " + rutas.insertar(p8));
        System.out.println("Insertar puerto " + p9.getNombre() + " en grafo: " + rutas.insertar(p9));
        System.out.println("Insertar puerto " + p10.getNombre() + " en grafo: " + rutas.insertar(p10));
        System.out.println("Insertar puerto " + p11.getNombre() + " en grafo: " + rutas.insertar(p11));
        System.out.println("Insertar puerto " + p12.getNombre() + " en grafo: " + rutas.insertar(p12));
        System.out.println("Insertar puerto " + p13.getNombre() + " en grafo: " + rutas.insertar(p13));
        System.out.println("Insertar puerto " + p14.getNombre() + " en grafo: " + rutas.insertar(p14));
        System.out.println("Insertar puerto " + p15.getNombre() + " en grafo: " + rutas.insertar(p15));
        System.out.println("Insertar puerto " + p15.getNombre() + " en grafo: " + rutas.insertar(p15));
        System.out.println(VERIFICACION_VALIDA + "Puertos insertados en grafo ✔" + RESET);
        System.out.println();

        //Creacion de rutas entre puertos del grafo
        System.out.println("Insertar ruta en grafo entre " + p1.getNombre() + " y " + p2.getNombre() + " con " + 2798 + " Km: " + rutas.insertarArco(p1, p2, 2798));
        System.out.println("Insertar ruta en grafo entre " + p1.getNombre() + " y " + p3.getNombre() + " con " + 1772 + " Km: " + rutas.insertarArco(p1, p3, 1772));
        System.out.println("Insertar ruta en grafo entre " + p1.getNombre() + " y " + p9.getNombre() + " con " + 1439 + " Km: " + rutas.insertarArco(p1, p9, 1439));
        System.out.println("Insertar ruta en grafo entre " + p2.getNombre() + " y " + p3.getNombre() + " con " + 2181 + " Km: " + rutas.insertarArco(p2, p3, 2181));
        System.out.println("Insertar ruta en grafo entre " + p2.getNombre() + " y " + p4.getNombre() + " con " + 7798 + " Km: " + rutas.insertarArco(p2, p4, 7798));
        System.out.println("Insertar ruta en grafo entre " + p2.getNombre() + " y " + p9.getNombre() + " con " + 1851 + " Km: " + rutas.insertarArco(p2, p9, 1851));
        System.out.println("Insertar ruta en grafo entre " + p2.getNombre() + " y " + p12.getNombre() + " con " + 15138 + " Km: " + rutas.insertarArco(p2, p12, 15138));
        System.out.println("Insertar ruta en grafo entre " + p3.getNombre() + " y " + p6.getNombre() + " con " + 8348 + " Km: " + rutas.insertarArco(p3, p6, 8348));
        System.out.println("Insertar ruta en grafo entre " + p3.getNombre() + " y " + p9.getNombre() + " con " + 358 + " Km: " + rutas.insertarArco(p3, p9, 358));
        System.out.println("Insertar ruta en grafo entre " + p4.getNombre() + " y " + p5.getNombre() + " con " + 3810 + " Km: " + rutas.insertarArco(p4, p5, 3810));
        System.out.println("Insertar ruta en grafo entre " + p4.getNombre() + " y " + p6.getNombre() + " con " + 3102 + " Km: " + rutas.insertarArco(p4, p6, 3102));
        System.out.println("Insertar ruta en grafo entre " + p4.getNombre() + " y " + p7.getNombre() + " con " + 2086 + " Km: " + rutas.insertarArco(p4, p7, 2086));
        System.out.println("Insertar ruta en grafo entre " + p4.getNombre() + " y " + p8.getNombre() + " con " + 940 + " Km: " + rutas.insertarArco(p4, p8, 940));
        System.out.println("Insertar ruta en grafo entre " + p5.getNombre() + " y " + p7.getNombre() + " con " + 3785 + " Km: " + rutas.insertarArco(p5, p7, 3785));
        System.out.println("Insertar ruta en grafo entre " + p5.getNombre() + " y " + p8.getNombre() + " con " + 4314 + " Km: " + rutas.insertarArco(p5, p8, 4314));
        System.out.println("Insertar ruta en grafo entre " + p6.getNombre() + " y " + p9.getNombre() + " con " + 8014 + " Km: " + rutas.insertarArco(p6, p9, 8014));
        System.out.println("Insertar ruta en grafo entre " + p6.getNombre() + " y " + p11.getNombre() + " con " + 16425 + " Km: " + rutas.insertarArco(p6, p11, 16425));
        System.out.println("Insertar ruta en grafo entre " + p7.getNombre() + " y " + p11.getNombre() + " con " + 15508 + " Km: " + rutas.insertarArco(p7, p11, 15508));
        System.out.println("Insertar ruta en grafo entre " + p8.getNombre() + " y " + p10.getNombre() + " con " + 1345 + " Km: " + rutas.insertarArco(p8, p10, 1345));
        System.out.println("Insertar ruta en grafo entre " + p11.getNombre() + " y " + p13.getNombre() + " con " + 1254 + " Km: " + rutas.insertarArco(p11, p13, 1254));
        System.out.println("Insertar ruta en grafo entre " + p11.getNombre() + " y " + p14.getNombre() + " con " + 2119 + " Km: " + rutas.insertarArco(p11, p14, 2119));
        System.out.println("Insertar ruta en grafo entre " + p11.getNombre() + " y " + p15.getNombre() + " con " + 2177 + " Km: " + rutas.insertarArco(p11, p15, 2177));
        System.out.println("Insertar ruta en grafo entre " + p11.getNombre() + " y " + p12.getNombre() + " con " + 11005 + " Km: " + rutas.insertarArco(p11, p12, 11005));
        System.out.println("Insertar ruta en grafo entre " + p13.getNombre() + " y " + p14.getNombre() + " con " + 2612 + " Km: " + rutas.insertarArco(p13, p14, 2612));
        System.out.println("Insertar ruta en grafo entre " + p13.getNombre() + " y " + p15.getNombre() + " con " + 2671 + " Km: " + rutas.insertarArco(p13, p15, 2671));
        System.out.println("Insertar ruta en grafo entre " + p14.getNombre() + " y " + p15.getNombre() + " con " + 55 + " Km: " + rutas.insertarArco(p14, p15, 55));
        System.out.println("Insertar ruta en grafo entre " + p14.getNombre() + " y " + p15.getNombre() + " con " + 5000 + " Km: " + rutas.insertarArco(p14, p15, 5000));
        System.out.println("Insertar ruta en grafo entre " + p15.getNombre() + " y " + p13.getNombre() + " con " + 200 + " Km: " + rutas.insertarArco(p15, p13, 200));
        System.out.println(VERIFICACION_VALIDA + "Rutas insertadas en grafo ✔" + RESET);
        System.out.println();

        //Creacion de barcos...tipos 0(pesqueros), 1(pasajeros), 2(carga)
        Barco b1 = new Barco(100, 1, "Argentina");
        System.out.println("Barco creado: " + b1.toString());
        Barco b2 = new Barco(120, 0, "Brasil");
        System.out.println("Barco creado: " + b2.toString());
        Barco b3 = new Barco(135, 2, "China");
        System.out.println("Barco creado: " + b3.toString());
        Barco b4 = new Barco(192, 2, "Argentina");
        System.out.println("Barco creado: " + b4.toString());
        Barco b5 = new Barco(193, 1, "Mexico");
        System.out.println("Barco creado: " + b5.toString());
        Barco b6 = new Barco(50, 1, "Italia");
        System.out.println("Barco creado: " + b6.toString());
        Barco b7 = new Barco(210, 0, "China");
        System.out.println("Barco creado: " + b7.toString());
        Barco b8 = new Barco(360, 2, "España");
        System.out.println("Barco creado: " + b8.toString());
        Barco b9 = new Barco(99, 1, "USA");
        System.out.println("Barco creado: " + b9.toString());
        Barco b10 = new Barco(25, 1, "Colombia");
        System.out.println("Barco creado: " + b10.toString());
        System.out.println(VERIFICACION_VALIDA + "Barcos creados ✔" + RESET);
        System.out.println();

        //Barcos insertados en la tabla Hash
        barcos.put(100, b1);
        barcos.put(120, b2);
        barcos.put(135, b3);
        barcos.put(192, b4);
        barcos.put(193, b5);
        barcos.put(50, b6);
        barcos.put(210, b7);
        barcos.put(360, b8);
        barcos.put(99, b9);
        barcos.put(25, b10);
        System.out.println(VERIFICACION_VALIDA + "Barcos insertados en tabla hash ✔" + RESET);
        System.out.println();

        //Los siguientes son datos precargados para poder testear ciertos metodos:
        p3.ingresarBarco(b2);
        p3.ingresarBarco(b3);
        p5.ingresarBarco(b4);
        p5.ingresarBarco(b5);
        p5.ingresarBarco(b6);
        p6.ingresarBarco(b7);
        p7.ingresarBarco(b8);
        p7.ingresarBarco(b9);
        p3.actualizarDarsenas();
        p6.actualizarDarsenas();

        /*       
        p3 = Barranqueras, tiene a barco b2(codigo 120) y b3(codigo 135) en darsenas
        p5 = Manzanillo, tiene en cola a barcos b4(codigo 192), b5(codigo 193), b6(codigo 50)
        p6 = Callao, tiene a barco b7(codigo 210) en darsenas
        p7 = Guayaquil, tiene en cola a barcos b8(codigo 360) y b9(codigo 99)
        puertos p1, p2, p8, p9, p10, p11, p12, p13, p14, p15 no tienen barcos en darsenas ni en cola
        barco b1(codigo 100) y b10(codigo 25) no estan en ningun puerto */
        System.out.println("DATOS PRECARGADOS PARA EL TEST: ");
        System.out.println("Puerto BARRANQUERAS tiene a barco 120 en darsena y a barco 135 en cola.");
        System.out.println("Puerto MANZANILLO tiene en cola a los barcos 192, 193 y 50.");
        System.out.println("Puerto CALLAO tiene a barco 210 en darsenas.");
        System.out.println("Puerto GUAYAQUIL tiene en cola a los barcos 360 y 99.");
        System.out.println("Todos los demas puertos no tienen barcos ni en darsenas ni en cola.");
        System.out.println("Barcos 100 y 25 no estan en ningun puerto.");
        System.out.println();

        System.out.println(VERIFICACION_VALIDA + "EL SCRIPT DE CARGA SE HA COMPLETADO ✔" + RESET);
        
        System.out.println("El camino entre Callao y Rashid que no supere los 3 puertos es: "+rutas.caminodeLongitudMenorA("CALLAO", "RASHID", 3));
        System.out.println("Los caminos desde Santos a Callao que no superen los 30000Km. son: "+rutas.caminosConMenorPeso("SANTOS", "CALLAO", 30000).toString2());
    }

    //OPCION 16 DEL MENU:
    public static void mostrarPuertos(ArbolAVL puertos) {
        if (!puertos.esVacio()) {
            System.out.println(FONDO_RESULTADO + "Los puertos son: " + RESET);
            System.out.println(puertos.toString());
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ No hay puertos cargados." + RESET);
        }
    }

    //OPCION 17 DEL MENU:
    public static void mostrarRutas(GrafoEtiquetado rutas) {
        if (!rutas.esVacio()) {
            System.out.println(FONDO_RESULTADO + "Las rutas son: " + RESET);
            System.out.println(rutas.toString());
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ No hay rutas cargadas." + RESET);
        }
    }

    //OPCION 18 DEL MENU:
    public static void mostrarBarcos(HashMap<String, Barco> unaTabla) {
        if (!unaTabla.isEmpty()) {
            System.out.println(FONDO_RESULTADO + "Los " + unaTabla.size() + " barcos son: " + RESET);
            Iterator it = unaTabla.keySet().iterator();
            while (it.hasNext()) {
                int key = (int) it.next();
                Barco unBarco = (Barco) unaTabla.get(key);
                System.out.println(unBarco.toString());
            }
        } else {
            System.out.println(VERIFICACION_ERROR + "✘ Tabla de barcos vacia." + RESET);
        }
    }
}
