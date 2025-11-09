package controllers;

/**
 *
 * @author AL23036
 */

import dao.PacienteDao; 
import models.Paciente; 
import javax.inject.Named;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

@Named("pacienteController")
@SessionScoped

public class PacienteController implements Serializable{
    private Paciente paciente = new Paciente();
    private List<Paciente> listaPacientes;
    
    public Paciente getPaciente() {
        return paciente; 
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente; 
    }
    
    public List<Paciente> getListaPacientes() {
        if (listaPacientes == null) {		
            PacienteDao dao = new PacienteDao();
            listaPacientes= dao.listar();           
        }
        return listaPacientes;
    }
    
    public void guardar() {
        PacienteDao dao = new PacienteDao();
        dao.insertar(paciente);
        paciente = new Paciente();
        listaPacientes = null;
        
       try {
            // Redirige a la página del listado
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("paciente-home.xhtml"); // Cambiar por el nombre de la pagina aca 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
