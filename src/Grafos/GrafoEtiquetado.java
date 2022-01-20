package Grafos;

import Lineales_Dinamicas.Cola;
import Lineales_Dinamicas.Lista;

//GRAFO HECHO POR LISTA DE ADYACENCIA
public class GrafoEtiquetado {

    private NodoVert inicio = null;
    private int orden = 0;

    public GrafoEtiquetado() {
    }

    public GrafoEtiquetado(NodoVert inicio) {
        this.inicio = inicio;
    }

//    METODO INSERTAR
    public boolean insertar(Object elem) {

        boolean estado = true;
        if (this.inicio == null) {
            this.inicio = new NodoVert(elem);
        } else {
            if (!existeVerticeAux(this.inicio.getSigVertice(), elem)) {
                estado = insertarAux(elem, this.inicio);
            } else {
                estado = false;
            }
        }
        if (estado) {
            orden++;
        }
        return estado;
    }

//    METODO INSERTAR AUXILIAR
    private boolean insertarAux(Object elem, NodoVert aux) {
        boolean estado = true;
        if (aux != null) {
            if (aux.equals(elem)) {
                estado = false;
            } else {
                if (aux.getSigVertice() != null) {
                    estado = insertarAux(elem, aux.getSigVertice());
                } else {
                    aux.setSigVertice(new NodoVert(elem));
                }
            }
        }
        return estado;
    }

//    METODO ELIMINAR
    public boolean eliminarVertice(Object elem) {
        boolean estado = false;
        if (this.inicio != null) {
            if (this.inicio.equals(elem)) {
                if (this.inicio.getSigVertice() == null) {
                    this.inicio = null;
                } else {
                    NodoAdy ady = this.inicio.getPrimerAdy();
                    eliminarAdyacentes(ady, elem);
                    this.inicio = this.inicio.getSigVertice();
                    estado = true;
                }
            } else {
                estado = eliminarAux(elem, this.inicio, this.inicio.getSigVertice());
            }
        }
        if (estado) {
            orden--;
        }
        return estado;
    }

//    METODO ELIMINAR AUXILIAR
    private boolean eliminarAux(Object buscado, NodoVert anterior, NodoVert nodo) {
        boolean exito = false;
        NodoAdy ady;
        if (nodo != null) {
            while (nodo != null && !(exito)) {
                //SI ES UN NODO SIGUIENTE A LA RAIZ EL ELEMENTO QUE BUSCO
                if (nodo.equals(buscado)) {
                    //POR CADA ADYACENTE RECUPERO EL VERTICE Y ELIMINO DE SUS ADYACENTES AL VERTICE QUE ELIMINE
                    ady = nodo.getPrimerAdy();
                    eliminarAdyacentes(ady, buscado);
                    anterior.setSigVertice(nodo.getSigVertice());//UNA VEZ QUE ELIMINA LOS ARCOS ENLAZO EL SIGUIENTE
                    exito = true;
                } else {
                    nodo = nodo.getSigVertice();
                    anterior = anterior.getSigVertice();
                }
            }
        }
        return exito;
    }

//    METODO ELIMINAR ADYACENTES
    private void eliminarAdyacentes(NodoAdy ady, Object buscado) {
        while (ady != null) {
            boolean estado = false;
            NodoVert vAdy = ady.getVertice();//Vertice del adyacente de mi vertice a eliminar
            NodoAdy adyAux = vAdy.getPrimerAdy();// Primer Adyacente del Vertice anterior
            if (adyAux.getVertice().equals(buscado)) {
                vAdy.setPrimerAdy(adyAux.getSigAdyacente());
            } else {
                while (adyAux != null && !(estado)) {
                    if (adyAux.getSigAdyacente() != null) {
                        if (adyAux.getSigAdyacente().getVertice().equals(buscado)) {
                            adyAux.setSigAdyacente(adyAux.getSigAdyacente().getSigAdyacente());
                            estado = true;
                        }
                    }
                    adyAux = adyAux.getSigAdyacente();
                }
            }
            estado = false;
            ady = ady.getSigAdyacente();
        }
    }

//    METODO INSERTAR ARCO
    public boolean insertarArco(Object origen, Object destino, int km) {
        boolean estado = false;
        NodoVert nodoInicio = recuperarVerticeAux(this.inicio, origen, null);//Obtengo el nodo inicio del arco
        NodoVert nodoFin = recuperarVerticeAux(this.inicio, destino, null);//Obtengo el nodo fin del arco
        if (nodoInicio != null && nodoFin != null) {
            if (!verificarAdy(nodoInicio, destino)) { //verifico que el nodo destino no este en los adyacentes del nodo inicio
                if (nodoInicio.getPrimerAdy() == null) {  // Si el nodo inicio no tiene adyacentes, le seteo el primer adyacente
                    nodoInicio.setPrimerAdy(new NodoAdy(nodoFin, km));
                } else {
                    NodoAdy aux = nodoInicio.getPrimerAdy(); // Se recorre todos los adyacentes hasta llegar a null y poder insertarlo
                    while (aux.getSigAdyacente() != null) {
                        aux = aux.getSigAdyacente();
                    }
                    aux.setSigAdyacente(new NodoAdy(nodoFin, km));
                }
                //Se agrega el nodo inicio entre los adyacentes del nodo fin
                if (nodoFin.getPrimerAdy() == null) {
                    nodoFin.setPrimerAdy(new NodoAdy(nodoInicio, km));
                } else {
                    NodoAdy aux = nodoFin.getPrimerAdy();
                    while (aux.getSigAdyacente() != null) {
                        aux = aux.getSigAdyacente();
                    }
                    aux.setSigAdyacente(new NodoAdy(nodoInicio, km));
                }
                estado = true;
            }
        } else {
            estado = false;
        }

        return estado;
    }

//    METODO RECUPERAR VERTICE
    private NodoVert recuperarVerticeAux(NodoVert ini, Object buscado, NodoVert v) {
        if (ini.getElem().equals(buscado)) {
            v = ini;
        } else {
            if (ini.getSigVertice() != null && v == null) {
                v = recuperarVerticeAux(ini.getSigVertice(), buscado, v);
            }
        }
        return v;
    }

//    METODO ELIMINAR ARCO
    public boolean eliminarArco(Object origen, Object destino) {
        boolean estado = false;
        if (!esVacio()) {
            NodoVert o = recuperarVerticeAux(this.inicio, origen, null);
            NodoVert d = recuperarVerticeAux(this.inicio, destino, null);
            if (o != null) {
                if (o.getPrimerAdy() != null) {
                    NodoAdy primerAdy = o.getPrimerAdy();
                    //CASO BASE: SI EL PRIMER ADYACENTE ES IGUAL AL QUE BUSCO
                    if (primerAdy.getVertice().equals(destino)) {
                        if (primerAdy.getSigAdyacente() == null) {
                            o.setPrimerAdy(null);
                            estado = true;
                        } else {
                            o.setPrimerAdy(primerAdy.getSigAdyacente());
                            estado = true;
                        }//FIN CASO BASE
                    } else {//SI NO ES EL PRIMER ADYACENTE
                        if (primerAdy.getSigAdyacente() != null) {
                            estado = eliminarArcoAux(primerAdy, primerAdy.getSigAdyacente(), destino);
                        }
                    }
                }
                //SI SE ELIMINO EL ARCO DE ORIGEN A DESTINO, ME ENCARGO DE ELIMINAR EL ARCO DE DESTINO A ORIGEN
                if (estado) {
                    if (d.getPrimerAdy() != null) {
                        NodoAdy primerAdy = d.getPrimerAdy();
                        if (primerAdy.getVertice().equals(origen)) {
                            if (primerAdy.getSigAdyacente() == null) {
                                d.setPrimerAdy(null);
                            } else {
                                d.setPrimerAdy(primerAdy.getSigAdyacente());
                            }
                        } else {
                            if (primerAdy.getSigAdyacente() != null) {
                                estado = eliminarArcoAux(primerAdy, primerAdy.getSigAdyacente(), origen);
                            }
                        }
                    }
                }
            }
        }
        return estado;
    }

//    ELIMINAR ARCO AUX
    private boolean eliminarArcoAux(NodoAdy adyAnt, NodoAdy ady, Object buscado) {
        boolean estado = false;
        if (ady.getVertice().equals(buscado)) {
            if (ady.getSigAdyacente() != null) {//SI ady NO ES EL ULTIMO
                adyAnt.setSigAdyacente(ady.getSigAdyacente());
                estado = true;
            } else {//SI ady ES EL ULTIMO
                adyAnt.setSigAdyacente(null);
                estado = true;
            }
        } else {
            if (ady.getSigAdyacente() != null) {
                estado = eliminarArcoAux(adyAnt.getSigAdyacente(), ady.getSigAdyacente(), buscado);
            }
        }
        return estado;
    }

//    METODO EXISTE VERTICE
    public boolean existeVertice(Object e) {
        boolean encontrado = false;
        if (!esVacio()) {
            if (this.inicio.getElem().equals(e)) {
                encontrado = true;
            } else {
                if (this.inicio.getSigVertice() != null) {
                    encontrado = existeVerticeAux(this.inicio.getSigVertice(), e);
                }
            }
        }
        return encontrado;
    }

//    METODO EXISTE VERTICE AUXILIAR
    private boolean existeVerticeAux(NodoVert aux, Object e) {
        boolean encontrado = false;
        if (aux != null) {
            if (aux.getElem().equals(e)) {
                encontrado = true;
            } else {
                if (aux.getSigVertice() != null) {
                    encontrado = existeVerticeAux(aux.getSigVertice(), e);
                }
            }
        }

        return encontrado;
    }

//    METODO EXISTE ARCO
    public boolean existeArco(Object origen, Object destino) {
        boolean existe = false;
        NodoVert vertice = recuperarVerticeAux(this.inicio, origen, null);
        if (vertice != null) {
            NodoAdy ady = vertice.getPrimerAdy();
            while (ady != null && !(existe)) {
                if (ady.getVertice().equals(destino)) {
                    existe = true;
                } else {
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return existe;
    }

//    METODO LISTAR EN PROFUNDIDAD
    public Lista listarEnProfundidad() {
        Lista listEnProf = new Lista();
        //define vertice para comenzar a recorrer
        NodoVert aux = inicio;
        while (aux != null) {
            if (listEnProf.localizar(aux.getElem()) < 0) {
                //si el vertice no fue visitado avanza en profundidad
                listarEnProfundidadAux(aux, listEnProf);
            }
            aux = aux.getSigVertice();
        }
        return listEnProf;
    }

//    METODO LISTAR EN PROFUNDIDAD AUXILIAR
    private Lista listarEnProfundidadAux(NodoVert nodo, Lista listEnProf) {
        if (nodo != null) {
            //marca al vertice n como visitado
            listEnProf.insertar(nodo.getElem(), listEnProf.longitud() + 1);
            NodoAdy ady = nodo.getPrimerAdy();
            while (ady != null) {
                //visita en profundidad los adyacentes del nodo
                if (listEnProf.localizar(ady.getVertice().getElem()) < 0) {
                    listarEnProfundidadAux(ady.getVertice(), listEnProf);
                }
                ady = ady.getSigAdyacente();
            }
        }
        return listEnProf;
    }

//    METODO LISTAR EN ANCHURA  
    public Lista listarEnAnchura() {
        Lista listEnAnch = new Lista();
        NodoVert nodo = this.inicio;
        while (nodo != null) {
            if (listEnAnch.localizar(nodo.getElem()) < 0) {
                listarEnAnchuraAux(nodo, listEnAnch);
            }
            nodo = nodo.getSigVertice();
        }
        return listEnAnch;
    }

//    METODO LISTAR EN ANCHURA AUXILIAR
    private Lista listarEnAnchuraAux(NodoVert nodo, Lista listEnAnch) {
        ColaVert aVisitar = new ColaVert();
        aVisitar.poner(nodo);
        while (!aVisitar.esVacia()) {
            nodo = aVisitar.extraerFrente();
            listEnAnch.insertar(nodo.getElem(), listEnAnch.longitud() + 1);
            NodoAdy ady = nodo.getPrimerAdy();
            while (ady != null) {
                if (listEnAnch.localizar(ady.getVertice().getElem()) < 0) {
                    if (!(aVisitar.estaEnCola(ady.getVertice()))) {
                        aVisitar.poner(ady.getVertice());
                    }
                }
                ady = ady.getSigAdyacente();
            }
        }
        return listEnAnch;
    }

//    MÉTODO EXISTE CAMINO
    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        Lista visitados = new Lista();
        //VERIFICO SI LOS VERTICES EXISTEN
        NodoVert aux = this.inicio;
        NodoVert o = null;
        NodoVert d = null;

        while (aux != null && (o == null || d == null)) {
            if (aux.getElem().equals(origen)) {
                o = aux;
            }
            if (aux.getElem().equals(destino)) {
                d = aux;
            }
            aux = aux.getSigVertice();
        }

        if (o != null && d != null) {
            exito = existeCaminoAux(o, destino, visitados);
        }
        return exito;
    }

//    METODO EXISTE CAMINO AUXILIAR
    private boolean existeCaminoAux(NodoVert n, Object destino, Lista vis) {
        boolean exito = false;
        if (n != null) {
            //SI VERTICE n ES EL DESTINO "Hay camino"
            if (n.getElem().equals(destino)) {
                vis.insertar(n.getElem(), vis.longitud() + 1);
                exito = true;
            } else {
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null && !exito) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0) {
                        exito = existeCaminoAux(ady.getVertice(), destino, vis);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }

//    METODO EXISTE CAMINO MENOR QUE (CANTIDAD)
    public boolean existeCaminoMenorKm(Object origen, Object destino, int km) {
        boolean exito = false;
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        NodoVert o = null;
        NodoVert d = null;

        while (aux != null && (o == null || d == null)) {
            if (aux.getElem().equals(origen)) {
                o = aux;
            }
            if (aux.getElem().equals(destino)) {
                d = aux;
            }
            aux = aux.getSigVertice();
        }

        if (o != null && d != null) {
            exito = existeCaminoMenorKmAux(exito, o, destino, visitados, km, 0);
        }

        return exito;
    }

//    METODO EXISTE CAMINO MENOR QUE (CANTIDAD) AUXILIAR
    private boolean existeCaminoMenorKmAux(boolean exito, NodoVert n, Object destino, Lista vis, int km, int suma) {
        if (n != null) {
            //SI VERTICE n ES EL DESTINO "Hay camino"
            if (n.getElem().equals(destino)) {
                vis.insertar(n.getElem(), 1);
                exito = true;
            } else {
                vis.insertar(n.getElem(), 1);
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null && !exito) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0 && suma + ady.getEtiqueta() <= km) {
                        exito = existeCaminoMenorKmAux(exito, ady.getVertice(), destino, vis, km, (suma + ady.getEtiqueta()));
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            vis.eliminar(1);
        }
        return exito;
    }

//    METODO EXISTE CAMINO SIN ELEMENTO
    public Lista caminoSinElemento(Object inicio, Object fin, Object exc) {

        NodoVert aux = this.inicio;
        NodoVert o = null;
        NodoVert d = null;
        NodoVert e = null;

        while (aux != null && (o == null || d == null || e == null)) {
            if (aux.getElem().equals(inicio)) {
                o = aux;
            }
            if (aux.getElem().equals(fin)) {
                d = aux;
            }
            if (aux.getElem().equals(exc)) {
                e = aux;
            }
            aux = aux.getSigVertice();
        }

        Lista l = new Lista();
        if (o != null && d != null && e != null) {
            this.caminoSinElementoAux(o, fin, exc, l, false);
        }
        return l;
    }

//    EXISTE CAMINO SIN ELEMENTO
    private boolean caminoSinElementoAux(NodoVert visitado, Object destino, Object excep, Lista camino, boolean llego) {
        if (visitado != null) {
            camino.insertar(visitado.getElem(), camino.longitud() + 1);
            if (visitado.getElem().equals(destino)) {
                llego = true;
            } else {
                NodoAdy ady = visitado.getPrimerAdy();
                while (ady != null && !llego) {
                    if (camino.localizar(ady.getVertice().getElem()) < 0 && !ady.getVertice().getElem().equals(excep)) {
                        llego = caminoSinElementoAux(ady.getVertice(), destino, excep, camino, llego);
                    }
                    ady = ady.getSigAdyacente();
                }

            }
            if (!llego) {
                camino.eliminar(camino.longitud());
            }

        }
        return llego;
    }

    public Lista caminodeLongitudMenorA(String origen, String destino, int longMax) {
        Lista recorrido = new Lista();

        if (this.inicio != null) {
            NodoVert aux = this.inicio;
            NodoVert o = null;
            NodoVert d = null;

            while (aux != null && (o == null || d == null)) {
                if (aux.getElem().equals(origen)) {
                    o = aux;
                }
                if (aux.getElem().equals(destino)) {
                    d = aux;
                }
                aux = aux.getSigVertice();
            }
            if (o != null && d != null) {
                caminoDeLongitudMenorAAux(longMax, o, destino, recorrido, false);
            }
        }
        return recorrido;
    }

    private boolean caminoDeLongitudMenorAAux(int longM, NodoVert n, String fin, Lista r, boolean llego) {
        if (n != null) {
            r.insertar(n.getElem(), r.longitud() + 1);
            if (n.getElem().equals(fin)) {
                llego = true;
            } else {
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null && !llego) {
                    if (r.localizar(ady.getVertice().getElem()) < 0 && r.longitud() + 1 <= longM) {
                        llego = caminoDeLongitudMenorAAux(longM, ady.getVertice(), fin, r, llego);
                    }
                    ady = ady.getSigAdyacente();
                }

            }
            if (!llego) {
                r.eliminar(r.longitud());
            }
        }
        return llego;
    }

//    METODO CAMINO MAS CORTO
    public Lista caminoMasCorto(Object origen, Object destino) {
        Lista camino = new Lista();
        Lista masCorto = new Lista();
        NodoVert aux = this.inicio;
        NodoVert o = null;
        NodoVert d = null;

        while (aux != null && (o == null || d == null)) {
            if (aux.getElem().equals(origen)) {
                o = aux;
            }
            if (aux.getElem().equals(destino)) {
                d = aux;
            }
            aux = aux.getSigVertice();
        }

        if (o != null && d != null) {
            masCorto = caminoMasCortoAux(o, destino, camino, masCorto);
        }
        return masCorto;
    }

//    METODO CAMINO MAS CORTO AUXILIAR
    private Lista caminoMasCortoAux(NodoVert n, Object dest, Lista camino, Lista masCorto) {
        if (n != null) {
            camino.insertar(n.getElem(), camino.longitud() + 1);
            if (n.getElem().equals(dest)) {
                masCorto = camino.clonar();
            } else {
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null) {
                    if (camino.localizar(ady.getVertice().getElem()) < 0) {
                        if (masCorto.longitud() == 0 || (camino.longitud() + 1) < masCorto.longitud()) {
                            masCorto = caminoMasCortoAux(ady.getVertice(), dest, camino, masCorto);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            camino.eliminar(camino.longitud());
        }
        return masCorto;
    }

//    METODO CAMINO KILOMETROS MINIMOS
    public int caminoKilometrosMinimos(Object origen, Object destino) {
        Lista camino = new Lista();
        int masCorto = Integer.MAX_VALUE;
        NodoVert aux = this.inicio;
        NodoVert o = null;
        NodoVert d = null;

        while (aux != null && (o == null || d == null)) {
            if (aux.getElem().equals(origen)) {
                o = aux;
            }
            if (aux.getElem().equals(destino)) {
                d = aux;
            }
            aux = aux.getSigVertice();
        }

        if (o != null && d != null) {
            masCorto = caminoKilometrosMinimosAux(o, destino, camino, 0, masCorto);
        }
        return masCorto;
    }

//    METODO CAMINO KILOMETROS MINIMOS AUXILIAR
    private int caminoKilometrosMinimosAux(NodoVert visitado, Object destino, Lista camino, int suma, int masCorto) {
        if (visitado != null) {
            camino.insertar(visitado.getElem(), camino.longitud() + 1);
            if (visitado.getElem().equals(destino)) {
                masCorto = suma;
            } else {
                NodoAdy ady = visitado.getPrimerAdy();
                while (ady != null) {
                    if (camino.localizar(ady.getVertice().getElem()) < 0) {
                        if (suma + ady.getEtiqueta() < masCorto) {
                            masCorto = caminoKilometrosMinimosAux(ady.getVertice(), destino, camino, (suma + ady.getEtiqueta()), masCorto);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            camino.eliminar(camino.longitud());
        }
        return masCorto;
    }

    public Cola caminosConMenorPeso(String origen, String destino, int pesoMax) {
        Cola caminosPosibles = new Cola();
        if (this.inicio != null) {
            Lista camino = new Lista();
            NodoVert aux = this.inicio;
            NodoVert o = null;
            NodoVert d = null;

            while (aux != null && (o == null || d == null)) {
                if (aux.getElem().equals(origen)) {
                    o = aux;
                }
                if (aux.getElem().equals(destino)) {
                    d = aux;
                }
                aux = aux.getSigVertice();
            }

            if (o != null && d != null) {
                caminosConMenorPesoAux(o, destino, 0, pesoMax, camino, caminosPosibles);
            }
        }
        return caminosPosibles;
    }
    
    private void caminosConMenorPesoAux(NodoVert n, String destino, int suma, int max, Lista l, Cola c){
        if(n != null){
            l.insertar(n.getElem(), l.longitud() + 1);
            if(n.getElem().equals(destino))
                c.poner(l.clonar());
            else{
                NodoAdy ady = n.getPrimerAdy();
                while(ady != null){
                    if(l.localizar(ady.getVertice().getElem()) < 0 && ady.getEtiqueta() + suma < max)
                        caminosConMenorPesoAux(ady.getVertice(), destino, ady.getEtiqueta() + suma, max, l, c);
                    ady = ady.getSigAdyacente();
                }
            }
            l.eliminar(l.longitud());
        }
    }

//    METODO CLONAR
    public GrafoEtiquetado clonar() {
        GrafoEtiquetado clon = new GrafoEtiquetado();
        if (!esVacio()) {
            NodoVert vertice = clon.inicio;
            NodoVert aux = this.inicio;
            while (aux != null) {
                vertice.setPrimerAdy(aux.getPrimerAdy());
                NodoAdy adyClon = vertice.getPrimerAdy();
                if (aux.getPrimerAdy().getSigAdyacente() != null) {
                    NodoAdy auxAdy = aux.getPrimerAdy().getSigAdyacente();
                    while (auxAdy != null) {
                        adyClon.setSigAdyacente(auxAdy);
                        adyClon = adyClon.getSigAdyacente();
                        auxAdy = auxAdy.getSigAdyacente();
                    }
                }
                aux = aux.getSigVertice();
                vertice.setSigVertice(aux);
                vertice = vertice.getSigVertice();
            }
        }
        return clon;
    }

//    METODO TO STRING
    @Override
    public String toString() {
        String miGrafo = "";
        miGrafo = toStringAux(miGrafo) + "\n orden: " + this.orden;
        return miGrafo;
    }

    private String toStringAux(String miGrafo) {
        if (!(this.esVacio())) {
            NodoVert vertice = this.inicio;
            while (vertice != null) {
                miGrafo += "[ " + vertice.getElem() + " ]" + ": ";
                NodoAdy adyacente = vertice.getPrimerAdy();
                miGrafo += "[ ";
                while (adyacente != null) {
                    miGrafo += adyacente.getVertice().getElem();
                    if (adyacente.getSigAdyacente() != null) {
                        miGrafo += ", ";
                    }
                    adyacente = adyacente.getSigAdyacente();
                }
                miGrafo += " ]";
                vertice = vertice.getSigVertice();
                miGrafo += "\n";
            }
        }
        return miGrafo;
    }

//    METODO ES VACIO
    public boolean esVacio() {
        return this.inicio == null;
    }

//    MÉTODO VERIFICAR ADYACENTE
    private boolean verificarAdy(NodoVert n, Object buscado) {
        boolean estado = false;
        NodoAdy aux = n.getPrimerAdy();

        while (!estado && aux != null) {
            if (aux.getVertice().getElem().equals(buscado)) {
                estado = true;
            } else {
                aux = aux.getSigAdyacente();
            }
        }

        return estado;
    }

//    METODO GET ORDEN
    public int getOrden() {
        return orden;
    }

}
