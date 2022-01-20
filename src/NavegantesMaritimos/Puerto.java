package NavegantesMaritimos;

import Proposito_Especificos.ColaPrioridad;

public class Puerto {

    private final String nombre;
    private String pais;
    private final Barco[] darsenas;
    private final ColaPrioridad colaPrioridades;

    public Puerto(String nombre, String pais, int cantDarsenas) {
        this.nombre = nombre;
        this.pais = pais;
        this.darsenas = new Barco[cantDarsenas];
        this.colaPrioridades = new ColaPrioridad(3); //Las prioridades son 3 (0: pesquero, 1: pasajeros, 2: carga)
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean ingresarBarco(Barco b) {
        boolean exito = false;

        if (!b.estaEnPuerto()) {
            colaPrioridades.insertar(b, b.getTipo());
            b.setEstaEnPuerto(true);
            exito = true;
        }

        return exito;
    }

    public boolean existeBarco(Barco b) {
        boolean exito = false;
        int i = 0;
        while (i < darsenas.length && !exito) {
            if (darsenas[i] == b) {
                exito = true;
            }
            i++;
        }
        return exito;
    }

    public boolean sacarBarco(Barco b) {
        boolean encontro = false;
        int i = 0;

        while (i < darsenas.length && !encontro) {
            if (darsenas[i] == b) {
                darsenas[i] = null;
                encontro = true;
                b.setEstaEnPuerto(false);
            }
            i++;
        }

        return encontro;
    }

    public void actualizarDarsenas() {
        for (int i = 0; i < darsenas.length && !this.colaPrioridades.esVacia(); i++) {
            if (darsenas[i] == null) { // significa que hay un espacio para alojar un barco
                darsenas[i] = (Barco) this.colaPrioridades.recuperarFrente();
                this.colaPrioridades.eliminarFrente();
            }
        }
    }

    @Override
    public String toString() {
        return (this.nombre);
    }

    @Override
    public boolean equals(Object otro) {
        return (otro.equals(this.nombre));
    }

    public boolean colaVacia() {
        return (this.colaPrioridades.esVacia());
    }

    public String colaToString() {
        return (this.colaPrioridades.toString());
    }

}
