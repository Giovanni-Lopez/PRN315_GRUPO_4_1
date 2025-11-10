package models;

import java.time.LocalDate;

/**
 *
 * @author AL23036
 */
public class Vacuna {
    private int idVacuna;
    private String tipo;
    private LocalDate fechaCaducidad;

    // Getters y Setters
    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }
   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
