package bd;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println(" Conexión a la base de datos establecida correctamente.");
            } else {
                System.out.println(" Conexión nula o cerrada.");
            }
        } catch (SQLException e) {
            System.err.println(" Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}
