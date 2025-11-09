package dao;

/**
 *
 * @author AL23036
 */

import models.Medico;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    // 🔸 INSERTAR MÉDICO
    public void insertar(Medico m) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO tbl_medico (nombre, apellido, contacto, especialidad) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getApellido());
            ps.setString(3, m.getContacto());
            ps.setString(4, m.getEspecialidad());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔸 OBTENER TODOS LOS MÉDICOS
    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_medico;";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Listado de medicos obtenidos");
         
            while (rs.next()) {
                Medico m = new Medico();
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setContacto(rs.getString("contacto"));
                m.setEspecialidad(rs.getString("especialidad"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los medicos");
            e.printStackTrace();
        }

        return lista;
    }

    // 🔸 ACTUALIZAR MÉDICO
    public void actualizar(Medico m) {
        String sql = "UPDATE tbl_medico SET nombre=?, apellido=?, contacto=?, especialidad=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getApellido());
            ps.setString(3, m.getContacto());
            ps.setString(4, m.getEspecialidad());
            ps.setInt(5, m.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM tbl_medico WHERE id=?";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}