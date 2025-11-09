package conexion;

/**
 *
 * @author  AL23036
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Cambia el URL de conexión según tu servidor
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=vacunacion;encrypt=false";
    private static final String USER = "sa";  
    private static final String PASS = "123";

   
    public static Connection getConexion() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a SQL Server");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver JDBC de SQL Server");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con SQL Server");
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        getConexion();
    }
}
    

