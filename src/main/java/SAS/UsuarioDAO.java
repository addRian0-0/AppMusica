package SAS;

import bd.Conexion;

import java.sql.*;

public class UsuarioDAO {

    public static String obtenerUsuarioPorCorreo(String correo) {
        String nombreUsuario = "Usuario";
        String query = "SELECT USERNAME FROM USUARIOS WHERE CORREO_ELECTRONICO = ?";

        try (Connection conn = Conexion.getConnection();  // o tu clase real de conexión
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombreUsuario = rs.getString("USERNAME");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nombreUsuario;
    }
}