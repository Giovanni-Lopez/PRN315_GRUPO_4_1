package dao;

/**
 *
 * @author AL23036
 */
import models.Agenda;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    // 🔸 INSERTAR PACIENTE
    public void insertar(Agenda a) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO tbl_agenda (id_vacuna, id_centro, fecha, hora) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getId_vacuna());
            ps.setInt(2, a.getId_centro());
            ps.setDate(3, java.sql.Date.valueOf(a.getFecha()));   
            ps.setTime(4, java.sql.Time.valueOf(a.getHora()));   
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 🔸 OBTENER TODOS LOS PACIENTES
    public List<Agenda> listar() {
        List<Agenda> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_agenda;";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Listado de agendas");
         
            while (rs.next()) {
                Agenda a = new Agenda();
                a.setId_agenda(rs.getInt("id_agenda"));
                a.setId_vacuna(rs.getInt("id_vacuna"));
                a.setId_centro(rs.getInt("id_centro"));
                a.setFecha(rs.getDate("fecha").toLocalDate());
                a.setHora(rs.getTime("fecha").toLocalTime());                
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los pacientes");
            e.printStackTrace();
        }

        return lista;
    }
}
