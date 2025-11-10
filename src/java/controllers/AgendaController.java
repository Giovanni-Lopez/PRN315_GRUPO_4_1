package controllers;

/**
 *
 * @author AL23036
 */

import dao.AgendaDAO; 
import models.Agenda; 
import javax.inject.Named;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

@Named("agendaController")
@SessionScoped
public class AgendaController implements Serializable {
    private Agenda agenda = new Agenda();
    private List<Agenda> listaAgenda;
    
    public Agenda getAgenda() {
        return agenda; 
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda; 
    }
    
    public List<Agenda> getListaAgenda() {
        if (listaAgenda == null) {		
            AgendaDAO dao = new AgendaDAO();
            listaAgenda= dao.listar();           
        }
        return listaAgenda;
    }
    
    public void guardar() {
        AgendaDAO dao = new AgendaDAO();
        dao.insertar(agenda);
        agenda = new Agenda();
        listaAgenda = null; 
        
       try {
            // Redirige a la página del listado
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("agenda-home.xhtml"); // Cambiar por el nombre de la pagina aca 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
