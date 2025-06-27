/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cybergato
 */
public class Usuario {

    public enum TipoUsuario {
        USUARIO("Usuario estándar"),
        VENDEDOR("Vendedor"),
        ADMINISTRADOR("Administrador del sistema");

        private String descripcion;

        // Constructor
        TipoUsuario(String descripcion) {
            this.descripcion = descripcion;
        }

        // Getter
        public String getDescripcion() {
            return descripcion;
        }

        // Setter (NO se recomienda modificar enums, pero lo incluyo si lo necesitas)
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

    private TipoUsuario tipoUsuario;
    private String nombres, apellidoPa, apellidoMa, correo, claveAcceso, username;
    
    public Usuario(){}

    public Usuario(TipoUsuario tipoUsuario, String nombres, String apellidoPa, String apellidoMa, String correo, String claveAcceso, String username) {
        this.tipoUsuario = tipoUsuario;
        this.nombres = nombres;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.correo = correo;
        this.claveAcceso = claveAcceso;
        this.username = username;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    

}
