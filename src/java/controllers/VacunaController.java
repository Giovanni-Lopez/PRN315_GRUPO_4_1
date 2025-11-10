package controllers;

/**
 *
 * @author AL23036
 */

import dao.VacunacionDAO; 
import models.Vacuna; 
import javax.inject.Named;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

@Named("vacunaController")
@SessionScoped
public class VacunaController implements Serializable{
    private Vacuna vacuna = new Vacuna();
    private List<Vacuna> listaVacuna;
    
    public Vacuna getVacuna() {
        return vacuna; 
    }
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna; 
    }
    
    public List<Vacuna> getListaVacuna() {
        if (listaVacuna == null) {		
            VacunacionDAO dao = new VacunacionDAO();
            listaVacuna= dao.listar();           
        }
        return listaVacuna;
    }
    
    public void guardar() {
        VacunacionDAO dao = new VacunacionDAO();
        dao.insertar(vacuna);
        vacuna = new Vacuna();
        listaVacuna = null;
        
       try {
            // Redirige a la página del listado
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("vacuna-home.xhtml"); // Cambiar por el nombre de la pagina aca 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
