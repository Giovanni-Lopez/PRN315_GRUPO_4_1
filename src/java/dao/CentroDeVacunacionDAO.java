package dao;

/**
 *
 * @author AL23036
 */

import models.CentroDeVacunacion;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroDeVacunacionDAO {
    // 🔸 INSERTAR CENTRO DE VACUNACION  
    public void insertar(CentroDeVacunacion c) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO tbl_centroVacunacion (nombreCentro, ubicacionCentro, contactoCentro) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombreCentro());
            ps.setString(2, c.getUbicacionCentro());
            ps.setString(3, c.getContactoCentro());            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔸 OBTENER TODOS LOS MÉDICOS
    public List<CentroDeVacunacion> listar() {
        List<CentroDeVacunacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_centroVacunacion;";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Listado de centro de vacunacion");
         
            while (rs.next()) {
                CentroDeVacunacion c = new CentroDeVacunacion();
                c.setIdCentroVacunacion(rs.getInt("idCentroVacunacion"));
                c.setNombreCentro(rs.getString("nombreCentro"));
                c.setUbicacionCentro(rs.getString("ubicacionCentro"));
                c.setContactoCentro(rs.getString("contactoCentro"));              
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los Centro de vacunacion");
            e.printStackTrace();
        }

        return lista;
    }
}
