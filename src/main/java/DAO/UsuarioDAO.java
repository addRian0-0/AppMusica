/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Usuario;

/**
 *
 * @author cybergato
 */
public class UsuarioDAO {
    
    public void registrarUsuario(Usuario usuario){
        System.out.println(usuario.getUsername());
        System.out.println(usuario);
    }
    
    public boolean iniciarSesion(String username, String password){
        return true;
    }
    
}
