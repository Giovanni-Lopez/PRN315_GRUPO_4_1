package models;

/**
 *
 * @author AL23036
 */
public class Medico extends Persona{
    private int idMedico;
    private String especialidad;

    // Getters y Setters
    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
}
