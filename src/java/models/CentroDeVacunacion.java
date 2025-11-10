package models;

/**
 *
 * @author AL23036
 */
public class CentroDeVacunacion {
    private int idCentroVacunacion;
    private String nombreCentro;
    private String ubicacionCentro;
    private String contactoCentro;

    // Getters y Setters
    public int getIdCentroVacunacion() {
        return idCentroVacunacion;
    }

    public void setIdCentroVacunacion(int idCentroVacunacion) {
        this.idCentroVacunacion = idCentroVacunacion;
    }
   

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getUbicacionCentro() {
        return ubicacionCentro;
    }

    public void setUbicacionCentro(String ubicacionCentro) {
        this.ubicacionCentro = ubicacionCentro;
    }

    public String getContactoCentro() {
        return contactoCentro;
    }

    public void setContactoCentro(String contactoCentro) {
        this.contactoCentro = contactoCentro;
    }
    
    
    
   
}
