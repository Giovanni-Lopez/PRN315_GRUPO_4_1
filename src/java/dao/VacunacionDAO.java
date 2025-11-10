package dao;

/**
 *
 * @author AL23036
 */
import models.Vacuna;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacunacionDAO {
     // 🔸 INSERTAR PACIENTE
    public void insertar(Vacuna v) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO tbl_vacuna (tipo, fechaCaducidad) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, v.getTipo());
            ps.setDate(2, java.sql.Date.valueOf(v.getFechaCaducidad()));          
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 🔸 OBTENER TODOS LOS PACIENTES
    public List<Vacuna> listar() {
        List<Vacuna> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_vacuna;";

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Listado de tipo de vacunas");
         
            while (rs.next()) {
                Vacuna v = new Vacuna();
                v.setIdVacuna(rs.getInt("idVacuna"));
                v.setTipo(rs.getString("tipo"));
                v.setFechaCaducidad(rs.getDate("fechaCaducidad").toLocalDate());
                lista.add(v);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los pacientes");
            e.printStackTrace();
        }

        return lista;
    }
}
