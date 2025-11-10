package controllers;

/**
 *
 * @author AL23036
 */

import dao.CentroDeVacunacionDAO; 
import models.CentroDeVacunacion; 
import javax.inject.Named;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

@Named("centroDeVacunacionController")
@SessionScoped

public class CentroDeVacunacionController implements Serializable{
    private CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion();
    private List<CentroDeVacunacion> listaCentroDeVacunacion;
    
    public CentroDeVacunacion getCentroDeVacunacion() {
        return centroDeVacunacion; 
    }
    public void setCentroDeVacunacion(CentroDeVacunacion centroVacunacion) {
        this.centroDeVacunacion = centroVacunacion; 
    }
    
    public List<CentroDeVacunacion> getListaCentroDeVacunacion() {
        if (listaCentroDeVacunacion == null) {		
            CentroDeVacunacionDAO dao = new CentroDeVacunacionDAO();
            listaCentroDeVacunacion= dao.listar();           
        }
        return listaCentroDeVacunacion;
    }
    
    public void guardar() {
        CentroDeVacunacionDAO dao = new CentroDeVacunacionDAO();
        dao.insertar(centroDeVacunacion);
        centroDeVacunacion = new CentroDeVacunacion();
        listaCentroDeVacunacion = null;
        
       try {
            // Redirige a la página del listado
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("centrovacunacion-home.xhtml"); // Cambiar por el nombre de la pagina aca 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
