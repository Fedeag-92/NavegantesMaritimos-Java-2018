//package Conjuntistas;
//
//import Lineales_Dinamicas.Lista;
//import Nodos.NodoAVLPuerto;
//import TrabajoFinal.Puerto;
//
//public class ArbolAVLPuerto {
//
//    private NodoAVLPuerto raiz;
//
//    public ArbolAVLPuerto() {
//        this.raiz = null;
//    }
//
//    public boolean insertar(Puerto elem) {
//        boolean estado = true;
//        NodoAVLPuerto n = new NodoAVLPuerto();
//        if (this.raiz == null) {
//            this.raiz = new NodoAVLPuerto(elem);
//            this.raiz.setAltura(0);
//        } else {
//            this.raiz = insertarAux(estado, elem, this.raiz);
//        }
//        if (n.getElemento() == null) {
//            estado = false;
//        }
//        return estado;
//    }
//
//    private NodoAVLPuerto insertarAux(boolean estado, Puerto elem, NodoAVLPuerto aux) {
//
//        NodoAVLPuerto aux2 = new NodoAVLPuerto();
//        if (elem != aux.getElemento()) {
//            if(aux.compareTo(elem) < 0){
//                if (aux.getHijoIzq() != null) {
//                    aux2 = insertarAux(estado, elem, aux.getHijoIzq());
//                    aux.setHijoIzq(aux2);
//                    this.modificarAltura(this.raiz);
//                } else {
//                    aux.setHijoIzq(new NodoAVLPuerto(elem));
//                    this.modificarAltura(this.raiz);
//                }
//            } else {
//                if (aux.getHijoDer() != null) {
//                    aux2 = insertarAux(estado, elem, aux.getHijoDer());
//                    aux.setHijoDer(aux2);
//                    this.modificarAltura(this.raiz);
//                } else {
//                    aux.setHijoDer(new NodoAVLPuerto(elem));
//                    this.modificarAltura(this.raiz);
//                }
//            }
//        }
//        aux = this.balancear(aux);
//        return aux;
//    }
//
//    private NodoAVLPuerto balancear(NodoAVLPuerto aux) {
//        NodoAVLPuerto reemplazado1;
//        NodoAVLPuerto reemplazado2;
//        if (aux != null) {
//
//
//            if (this.balance(aux) == -2) {
//                if (this.balance(aux.getHijoDer()) == 1) {
//
//                    NodoAVLPuerto hijoDer = aux.getHijoDer();
//                    reemplazado2 = this.rotacionSimpleDer(hijoDer);
//                    hijoDer = reemplazado2;
//                    aux.setHijoDer(hijoDer);
//                    aux = this.rotacionSimpleIzq(aux);
//                } else {
//
//                    aux = this.rotacionSimpleIzq(aux);
//                }
//            } else if (this.balance(aux) == 2) {
//                if (this.balance(aux.getHijoIzq()) == -1) {
//                    NodoAVLPuerto hijoIzq = aux.getHijoIzq();
//                    reemplazado2 = this.rotacionSimpleIzq(hijoIzq);
//                    hijoIzq = reemplazado2;
//                    aux.setHijoIzq(hijoIzq);
//                    aux = this.rotacionSimpleDer(aux);
//                } else {
//
//                    reemplazado1 = this.rotacionSimpleDer(aux);
//                    aux = reemplazado1;
//                }
//            }
//        }
//        return aux;
//    }
//
//    //METODO QUE ME DEVUELVE EL BALANCE DEL NODO
//    /*Es largo porque JAVA al no hacer la cuenta 0-(-1)=1 lo redefino*/
//    private int balance(NodoAVLPuerto nodo) {
//        int bal = 0;
//        int AltHI = 0;
//        int AltHD = 0;
//        if (nodo.getHijoIzq() != null) {
//            AltHI = nodo.getHijoIzq().getAltura();
//        } else {
//            AltHI = -1;
//        }
//        if (nodo.getHijoDer() != null) {
//            AltHD = nodo.getHijoDer().getAltura();
//        } else {
//            AltHD = -1;
//        }
//        if (AltHD == -1) {
//            bal = AltHI + 1;
//        } else {
//            bal = AltHI - AltHD;
//        }
//        return bal;
//    }
//
//    //METODO PARA HACER LA ROTACION IZQUIERDA
//    private NodoAVLPuerto rotacionSimpleIzq(NodoAVLPuerto nodo) {
//        NodoAVLPuerto h = nodo.getHijoDer();
//        NodoAVLPuerto temp = h.getHijoIzq();
//        nodo.setHijoDer(null);
//        h.setHijoIzq(nodo);
//        nodo.setHijoDer(temp);
//
//        return h;
//    }
//
//    //METODO PARA HACER LA ROTACION DERECHA
//    private NodoAVLPuerto rotacionSimpleDer(NodoAVLPuerto nodo) {
//        NodoAVLPuerto h = nodo.getHijoIzq();
//        NodoAVLPuerto temp = h.getHijoDer();
//        nodo.setHijoIzq(null);
//        h.setHijoDer(nodo);
//        nodo.setHijoIzq(temp);
//
//        return h;
//    }
//
//    //METODO QUE ME ACTUALIZA LA ALTURA DE CADA NODO LUEGO DE CADA INSERCION
//    private boolean modificarAltura(NodoAVLPuerto aux) {
//        boolean exito = false;
//        if (aux != null) {
//            int alt = Altura(aux, 0, 0);
//            aux.setAltura(alt);
//            exito = true;
//            if (aux.getHijoIzq() != null) {
//                exito = modificarAltura(aux.getHijoIzq());
//            }
//            if (aux.getHijoDer() != null) {
//                exito = modificarAltura(aux.getHijoDer());
//            }
//        }
//        return exito;
//    }
//
//    private int Altura(NodoAVLPuerto aux, int cont, int total) {
//        //int altura = -1;
//        if (aux != null) {
//            if (total < cont) {
//                total = cont;
//            }
//            if (aux.getHijoIzq() != null) {
//                total = Altura(aux.getHijoIzq(), cont + 1, total);
//            }
//            if (aux.getHijoDer() != null) {
//                total = Altura(aux.getHijoDer(), cont + 1, total);
//            }
//        }
//        return total;
//    }
//
//    public boolean pertenece(Puerto elem) {
//
//        return perteneceAux(false, this.raiz, elem);
//    }
//
//    private boolean perteneceAux(boolean estado, NodoAVLPuerto aux, Puerto elem) {
//        if (aux != null) {
//            if (aux.compareTo(elem) == 0) {
//                estado = true;
//            } else {
//                if (aux.getHijoIzq() != null) {
//                    estado = perteneceAux(estado, aux.getHijoIzq(), elem);
//                }
//                if (aux.getHijoDer() != null && !(estado)) {
//                    estado = perteneceAux(estado, aux.getHijoDer(), elem);
//                }
//            }
//        }
//        return estado;
//    }
//
//    //METODO ELIMINAR
//    public void eliminar(Puerto elem) {
//        boolean estado = false;
//        if (perteneceAux(estado, this.raiz, elem)) {
//            if (this.raiz != null) {
//                if (this.raiz.getElemento() == elem && this.raiz.getHijoIzq() == null && this.raiz.getHijoDer() == null) {
//                    this.raiz.setElemento(null);
//                } else {
//                    this.raiz = eliminarAux(elem, this.raiz, estado);
//                }
//                estado = perteneceAux(estado, this.raiz, elem);
//            }
//        }
//    }
//
//    private NodoAVLPuerto eliminarAux(Puerto buscado, NodoAVLPuerto aux, boolean estado) {
//        if (aux != null) {
//            if (aux.getElemento() == buscado) {
//                estado = true;
//                //CASO ES HOJA
//                if (aux.getHijoIzq() == null && aux.getHijoDer() == null) {
//                    aux = null;
//                    this.modificarAltura(this.raiz);
//                } else {
//                    //CASO TIENE UN HIJO SOLO
//                    if ((aux.getHijoIzq() != null && aux.getHijoDer() == null) || (aux.getHijoIzq() == null && aux.getHijoDer() != null)) {
//                        aux = caso_2(aux);
//                        this.modificarAltura(this.raiz);
//                    } else {
//                        //CASO QUE TENGA LOS 2 HIJOS
//                        if (aux.getHijoIzq() != null && aux.getHijoDer() != null) {
//                            aux = caso_3(aux, buscado);
//                            this.modificarAltura(this.raiz);
//                        }
//                    }
//                }
//            } else {
//                if (aux.getHijoIzq() != null) {//elimine los aux de retorno
//                    aux.setHijoIzq(eliminarAux(buscado, aux.getHijoIzq(), estado));
//                }
//                if (aux.getHijoDer() != null) {
//                    aux.setHijoDer(eliminarAux(buscado, aux.getHijoDer(), estado));
//                }
//            }
//        }
//        this.modificarAltura(this.raiz);
//        aux = this.balancear(aux);
//        return aux;
//    }
//
//    //METODO caso_2 SI TIENE UN SOLO HIJO
//    private NodoAVLPuerto caso_2(NodoAVLPuerto aux) {
//        if(aux!=null){
//            if(aux.getHijoIzq()!=null) aux = aux.getHijoIzq();
//            else aux = aux.getHijoDer();
//        }
//       
//        return aux;
//    }
//
//    private NodoAVLPuerto caso_3(NodoAVLPuerto aux, Puerto buscado) {
//        if (aux.getElemento() == buscado) {
//            //YO ELEGI EL ELEMENTO MAXIMO DEL SUBARBOL DERECHO
//            Puerto c2 = candidato2(aux.getHijoDer());
//            eliminarAux(c2, this.raiz, false);
//            aux.setElemento(c2);
//            this.modificarAltura(this.raiz);
//        }
//        return aux;
//    }
//
//    //METODO QUE BUSCA EL PADRE DEL NODO
//    private NodoAVLPuerto buscarPadre(NodoAVLPuerto aux, NodoAVLPuerto padre, Puerto buscado) {
//        if (aux != null) {
//            if (aux.getHijoIzq() != null) {
//                if (aux.getHijoIzq().getElemento() == buscado) {
//                    padre = aux;
//                } else {
//                    padre = buscarPadre(aux.getHijoIzq(), padre, buscado);
//                }
//            }
//            if (padre == null && aux.getHijoDer() != null) {
//                if (aux.getHijoDer().getElemento() == buscado) {
//                    padre = aux;
//                } else {
//                    padre = buscarPadre(aux.getHijoDer(), padre, buscado);
//                }
//            }
//        }
//        return padre;
//    }
//
//    //METODO QUE DEVUELVE EL ELEMENTO MAXIMO DEL SUBARBOL IZQUIERDO
//    private Puerto candidato1(NodoAVLPuerto aux) {
//        while (aux.getHijoDer() != null) {
//            aux = aux.getHijoDer();
//        }
//        return aux.getElemento();
//    }
//
//    //METODO QUE DEVUELVE EL ELEMENTO MINIMO DEL SUBARBOL DERECHO
//    private Puerto candidato2(NodoAVLPuerto aux) {
//        while (aux.getHijoIzq() != null) {
//            aux = aux.getHijoIzq();
//        }
//        return aux.getElemento();
//    }
//
//    public boolean esVacio() {
//        return this.raiz == null;
//    }
//
//    public Lista listar() {
//        Lista l = new Lista();
//
//        return listarAux(l, this.raiz);
//    }
//
//    private Lista listarAux(Lista l, NodoAVLPuerto aux) {
//        if (aux != null) {
//
//            if (aux.getHijoIzq() != null) {
//                l = listarAux(l, aux.getHijoIzq());
//            }
//            l.insertar(aux.getElemento(), l.longitud() + 1);
//            if (aux.getHijoDer() != null) {
//                l = listarAux(l, aux.getHijoDer());
//            }
//        }
//        return l;
//   }
//
//    public Lista listarRango(Object minimo, Object maximo) {
//        Lista l = new Lista();
//        NodoAVLPuerto min = (NodoAVLPuerto) minimo;
//        NodoAVLPuerto max = (NodoAVLPuerto) maximo;
//        if (min.compareTo(max) <= 0) {
//            l = listarRangoAux(l, this.raiz, min, max);
//        }
//
//        return l;
//    }
//
//    private Lista listarRangoAux(Lista l, NodoAVLPuerto aux, Object min, Object max) {
//        if (aux != null) {
//            if (aux.compareTo(max) < 0 && aux.getHijoDer() != null) {
//
//                l = listarRangoAux(l, aux.getHijoDer(), min, max);
//
//            }
//
//            if (aux.compareTo(min) >= 0 && aux.compareTo(max) <= 0) {
//                //Si pongo longitud+1 me lo guarda alrevez, con el 1 los guarda en la primer pos
//                l.insertar(aux.getElemento(), 1);
//            }
//
//            if (aux.compareTo(min) > 0 && aux.getHijoIzq() != null) {
//
//                l = listarRangoAux(l, aux.getHijoIzq(), min, max);
//
//            }
//
//        }
//        return l;
//    }
//
//    public Object minimoElem() {
//        NodoAVLPuerto aux = this.raiz;
//        while (aux.getHijoIzq() != null) {
//            aux = aux.getHijoIzq();
//        }
//        return aux.getElemento();
//    }
//
//    public Object maximoElem() {
//        NodoAVLPuerto aux = this.raiz;
//        while (aux.getHijoDer() != null) {
//            aux = aux.getHijoDer();
//        }
//        return aux.getElemento();
//    }
//
//    public Lista listarALtura() {
//        Lista l = new Lista();
//
//        return listarAltAux(l, this.raiz);
//    }
//
//    private Lista listarAltAux(Lista l, NodoAVLPuerto aux) {
//        if (aux != null) {
//
//            if (aux.getHijoIzq() != null) {
//                l = listarAltAux(l, aux.getHijoIzq());
//            }
//            String s = "la altura de " + aux.getElemento() + " es " + aux.getAltura() + " \n";
//            l.insertar(s, l.longitud() + 1);
//            if (aux.getHijoDer() != null) {
//                l = listarAltAux(l, aux.getHijoDer());
//            }
//        }
//        return l;
//    }
//
//    public String toString() {
//        return toStringAux(this.raiz);
//    }
//
//    private String toStringAux(NodoAVLPuerto n) {
//        String s = "";
//        if (n != null) {
//            s = "(" + n.getAltura() + ") " + n.getElemento();
//            if (n.getHijoIzq() != null) {
//                s += "  izq: " + n.getHijoIzq().getElemento();
//            }
//            if (n.getHijoDer() != null) {
//                s += "  der: " + n.getHijoDer().getElemento();
//            }
//
//            s += "\n";
//            s += toStringAux(n.getHijoIzq());
//            s += toStringAux(n.getHijoDer());
//        }
//        return s;
//    }
//
//}
