/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author cybergato
 */
public class ValidarDatosJOptionPane {

    public static String soloLetras(String texto, String messageError) {
        if (texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ]{2,50}$")) {
            return texto;
        } else {
            JOptionPane.showMessageDialog(null, messageError + "Solo entre 2 y 50 letras.");
            return null;
        }
    }

    public static String validarCorreo(String email) {
        if (email != null && email.matches("^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return email;
        } else {
            JOptionPane.showMessageDialog(null, "Correo inválido. Introduce un correo válido.");
            return null;
        }
    }

    public static String validarAlfanumericos(String texto, String messageError) {
        if (texto != null && texto.matches("^[a-zA-Z0-9._-]+$")) {
            return texto;
        } else {
            JOptionPane.showMessageDialog(null, messageError + "Solo caracteres alfanumericos.");
            return null;
        }
    }

    public static String validarPassword(String password) {
        if (password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            return password;
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña insegura. Usa al menos 8 caracteres, con mayúscula, minúscula, número y símbolo.");
            return null;
        }
    }
}
