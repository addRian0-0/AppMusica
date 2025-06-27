/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author eliza
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.File;

public class Validaciones {

    public static boolean NombreValido(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ]{10,50}+$");
    }

    public static boolean FechaValida(String fechaTexto) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date fecha = sdf.parse(fechaTexto);
            return !fecha.after(new Date());
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean EmailValido(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean EmailUnico(String email, List<String> correosExistentes) {
        return email != null && correosExistentes != null && !correosExistentes.contains(email.toLowerCase());
    }

    public static boolean TelefonoValido(String telefono) {
        return telefono != null && telefono.matches("^\\d{10}$");
    }

    public static boolean UsernameValido(String username) {
        return username != null && username.matches("^[a-zA-Z0-9._-]{4,15}$");
    }

    public static boolean PasswordSegura(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public static boolean contrasenasCoinciden(String pass1, String pass2) {
        return pass1 != null && pass1.equals(pass2);
    }

    public static boolean existeUsuario(String username, List<String> usuariosExistentes) {
        return username != null && usuariosExistentes.contains(username.toLowerCase());
    }

    public static boolean existeCorreo(String correo, List<String> correosExistentes) {
        return correo != null && correosExistentes.contains(correo.toLowerCase());
    }

    public static boolean esPasswordCorrecta(String inputUsuarioOCorreo, String password,
            List<String> usuarios, List<String> correos, List<String> claves) {
        int index = -1;
        if (usuarios.contains(inputUsuarioOCorreo)) {
            index = usuarios.indexOf(inputUsuarioOCorreo);
        } else if (correos.contains(inputUsuarioOCorreo)) {
            index = correos.indexOf(inputUsuarioOCorreo);
        }

        return index != -1 && password.equals(claves.get(index));
    }

    public static boolean NombreAlbumValido(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-Z0-9ÁÉÍÓÚáéíóúÑñ ]{2,100}$");
    }

    public static boolean NombreArtistaValido(String artista) {
        return artista != null && artista.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ]{2,100}$");
    }

    public static boolean GeneroValido(String genero) {
        return genero != null && genero.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ,\\.]{2,100}$");
    }

    public static boolean TituloValido(String titulo) {
        return titulo != null && titulo.matches("^.{2,50}$");
    }

    public static boolean LinkValido(String link) {
        return link != null && link.matches("^(http|https)://.*$");
    }

    public static boolean DuracionValida(String duracion) {
        return duracion != null && duracion.matches("^\\d{2}:\\d{2}:\\d{2}$");
    }

    public static boolean DirectorOCreadorValido(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ0-9 .,:;()!@#&%\"'-]{2,150}$");
    }

    public static boolean SinopsisValida(String sinopsis) {
        return sinopsis != null && sinopsis.length() <= 300;
    }

    public static boolean ClasificacionValida(String clasificacion) {
        return clasificacion != null && clasificacion.matches("^[A-Z]{1,3}$");
    }

    public static boolean TemporadaValida(String temporadas) {
        try {
            int num = Integer.parseInt(temporadas);
            return num >= 1 && num <= 50;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean EpisodioValido(String episodio) {
        try {
            int num = Integer.parseInt(episodio);
            return num >= 1 && num <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean BancoValido(String banco) {
        return banco != null && banco.matches("^[A-ZÁÉÍÓÚÑ ,.]{2,100}$");
    }

    public static boolean FolioValido(String folio) {
        return folio != null && folio.matches("^\\d{10,15}$");
    }

    public static boolean MontoValido(String monto) {
        return monto != null && monto.matches("^\\d+(\\.\\d{1,2})?$");
    }

    public static boolean MetodoValido(String metodo) {
        return metodo != null && metodo.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ]{2,50}$");
    }

    public static boolean ComprobanteValido(File archivo) {
        if (archivo == null || !archivo.exists()) {
            return false;
        }

        String nombre = archivo.getName().toLowerCase();
        long tamanoBytes = archivo.length();
        long cincoMB = 5 * 1024 * 1024; // 5 megabytes

        boolean extensionValida = nombre.endsWith(".jpg") || nombre.endsWith(".png") || nombre.endsWith(".pdf");
        boolean tamanoValido = tamanoBytes <= cincoMB;

        return extensionValida && tamanoValido;
    }

    public static boolean Obligatorio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

}
