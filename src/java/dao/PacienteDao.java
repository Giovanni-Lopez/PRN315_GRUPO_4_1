package dao;

/**
 *
 * @author AL23036
 */

import models.Paciente;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {
     // 🔸 INSERTAR PACIENTE
    public void insertar(Paciente p) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO tbl_paciente (nombre, apellido, contacto, enfermedad, tiposangre) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getContacto());
            ps.setString(4, p.getEnfermedad());
            ps.setString(5, p.getTipoSangre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 🔸 OBTENER TODOS LOS PACIENTES
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_paciente;";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Listado de pacientes");
         
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setContacto(rs.getString("contacto"));
                p.setEnfermedad(rs.getString("enfermedad"));
                p.setTipoSangre(rs.getString("tipoSangre"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los pacientes");
            e.printStackTrace();
        }

        return lista;
    }
    
    
}
