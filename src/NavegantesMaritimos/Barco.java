package NavegantesMaritimos;

public class Barco {
    private final int codigo;
    private int tipo;
    private String bandera;
    private boolean estaEnPuerto;

    public Barco(int codigo, int tipo, String bandera) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.bandera = bandera;
        this.estaEnPuerto = false;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    @Override
    public String toString(){
        String cadena = "codigo: " + this.codigo + ", tipo: ";
        if(tipo == 0)
            cadena += "barco pesquero";
        else if(tipo == 1)
            cadena += "barco de pasajeros";
        else
            cadena += "barco de carga";
        cadena += ", pais: " + this.bandera;
        return (cadena);
    }

    public boolean estaEnPuerto() {
        return estaEnPuerto;
    }

    public void setEstaEnPuerto(boolean estaEnPuerto) {
        this.estaEnPuerto = estaEnPuerto;
    }
    
    
}
