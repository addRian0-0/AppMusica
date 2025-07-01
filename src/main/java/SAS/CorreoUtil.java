package SAS;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class CorreoUtil {

    private static final String REMITENTE = "flores.zamora.ithan@gmail.com";
    private static final String PASSWORD = "tikcuceujrhfufrb";

    /**
     * Carga una plantilla HTML desde la carpeta /resources del proyecto.
     * Asegúrate de tener "plantilla.html" en src/main/resources
     */
    public static String cargarHtml(String nombreArchivo) {
        try (InputStream input = CorreoUtil.class.getClassLoader().getResourceAsStream(nombreArchivo)) {
            if (input == null) {
                System.err.println("❌ Archivo no encontrado en resources: " + nombreArchivo);
                return "<p>Error: archivo no encontrado</p>";
            }
            return new String(input.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return "<p>Error al cargar la plantilla</p>";
        }
    }

    /**
     * Reemplaza variables {{variable}} en el HTML por los valores del mapa.
     */
    public static String rellenarPlantilla(String html, Map<String, String> valores) {
        for (Map.Entry<String, String> entry : valores.entrySet()) {
            html = html.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return html;
    }

    /**
     * Envía un correo con formato HTML.
     */
    public static void enviarCorreo(String destinatario, String asunto, String mensajeHtml) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(REMITENTE));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setContent(mensajeHtml, "text/html; charset=utf-8");

            Transport.send(mensaje);

            System.out.println("✅ Correo enviado a " + destinatario);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("❌ Error al enviar correo: " + e.getMessage());
        }
    }
}
