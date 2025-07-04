/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bd.Conexion;
import model.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 *
 * @author cybergato
 */
public class UsuarioDAO {

    public void registrarUsuario(Usuario usuario) {
        try (Connection conn = Conexion.getConnection()) {
            // 1. Generar un ID aleatorio único (mejor usar UUID)
            String idUsuario = UUID.randomUUID().toString().substring(0, 16); // Trunca a 16 chars

            // 2. Validar que el correo y el ID no existan
            String sqlCheck = "SELECT COUNT(*) FROM USUARIOS WHERE ID_USUARIO = ? OR CORREO_ELECTRONICO = ?";
            try (PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck)) {
                stmtCheck.setString(1, idUsuario);
                stmtCheck.setString(2, usuario.getCorreo());

                try (ResultSet rs = stmtCheck.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese ID o correo.");
                        return;
                    }
                }
            }

            // 3. Insertar el usuario
            String sqlInsert = "INSERT INTO USUARIOS (ID_USUARIO, CORREO_ELECTRONICO, APELLIDOP, APELLIDOMA, NOMBRES, CLAVEACCESO, USERNAME) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                stmtInsert.setString(1, idUsuario);
                stmtInsert.setString(2, usuario.getCorreo());
                stmtInsert.setString(3, usuario.getApellidoPa());
                stmtInsert.setString(4, usuario.getApellidoMa());
                stmtInsert.setString(5, usuario.getNombres());
                stmtInsert.setString(6, usuario.getClaveAcceso()); // TEXTO PLANO: ¡No recomendado para sistemas reales!
                stmtInsert.setString(7, usuario.getUsername());

                int rowsInserted = stmtInsert.executeUpdate();
                if (rowsInserted > 0) {
                    //JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error al conectar la BD: " + e);
        }
    }

    public Usuario iniciarSesion(String username, String password) {
    try (Connection conn = Conexion.getConnection()) {
        String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ? AND CLAVEACCESO = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // Nota: No recomendado usar texto plano en producción

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setUsername(rs.getString("USERNAME"));
                    usuario.setNombres(rs.getString("NOMBRES"));
                    usuario.setApellidoPa(rs.getString("APELLIDOP"));
                    usuario.setApellidoMa(rs.getString("APELLIDOMA"));
                    usuario.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                    usuario.setClaveAcceso(rs.getString("CLAVEACCESO")); // ⚠️ No recomendado mostrarla o guardarla como texto plano
                    
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                    return null;
                }
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos:\n" + e.getMessage());
        return null;
    }
}


}
