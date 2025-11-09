package controllers;

/**
 *
 * @author AL23036
 */

import dao.MedicoDAO; 
import models.Medico; 
import javax.inject.Named;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;


@Named("medicoController")
@SessionScoped
public class MedicoController implements Serializable {
    private Medico medico = new Medico();
    private List<Medico> listaMedicos;
    
    public Medico getMedico() {
        return medico; 
    }
    public void setMedico(Medico medico) {
        this.medico = medico; 
    }
    
    public List<Medico> getListaMedicos() {
        if (listaMedicos == null) {
            MedicoDAO dao = new MedicoDAO();
            listaMedicos = dao.listar();
        }
        return listaMedicos;
    }
    
    public void guardar() {
        MedicoDAO dao = new MedicoDAO();
        dao.insertar(medico);
        medico = new Medico();
        listaMedicos = null;
        
       try {
            // Redirige a la página del listado
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("medico-home.xhtml"); // Cambiar por el nombre de la pagina aca 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(int id) {
        MedicoDAO dao = new MedicoDAO();
        dao.eliminar(id);
        listaMedicos = null;
    }
}
