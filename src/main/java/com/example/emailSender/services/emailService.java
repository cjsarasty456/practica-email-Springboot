package com.example.emailSender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void basicMail() {
        try {
            // destinatario
            String addressMail = "youremail@domain.com";
            // Asunto
            String subject = "Este es un correo de prueba";
            // Cuerpo Correo
            String bodyMail = "Correo prueba";
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    public void advancedEmail(String addressMail) {
        try {
            // destinatario
            // String addressMail = "cjcs.cadenasarasty8@gmail.com";
            // Asunto
            String subject = "Este es un correo de prueba";
            // Cuerpo Correo
            String bodyMail = ""
    + "<!DOCTYPE html>\n"
    + "<html lang=\"es\">\n"
    + "<head>\n"
    + "    <meta charset=\"UTF-8\">\n"
    + "    <title>Correo de Prueba</title>\n"
    + "    <style>\n"
    + "        body {\n"
    + "            font-family: Arial, sans-serif;\n"
    + "            background-color: #f4f4f4;\n"
    + "            margin: 0;\n"
    + "            padding: 0;\n"
    + "        }\n"
    + "        .correo-container {\n"
    + "            background-color: #ffffff;\n"
    + "            max-width: 600px;\n"
    + "            margin: 40px auto;\n"
    + "            padding: 30px;\n"
    + "            border-radius: 8px;\n"
    + "            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);\n"
    + "        }\n"
    + "        h2 {\n"
    + "            color: #333333;\n"
    + "        }\n"
    + "        p {\n"
    + "            font-size: 16px;\n"
    + "            color: #555555;\n"
    + "        }\n"
    + "        .btn {\n"
    + "            display: inline-block;\n"
    + "            margin-top: 20px;\n"
    + "            padding: 12px 20px;\n"
    + "            background-color: #007BFF;\n"
    + "            color: white;\n"
    + "            text-decoration: none;\n"
    + "            border-radius: 5px;\n"
    + "        }\n"
    + "        .footer {\n"
    + "            margin-top: 30px;\n"
    + "            font-size: 12px;\n"
    + "            color: #aaaaaa;\n"
    + "            text-align: center;\n"
    + "        }\n"
    + "    </style>\n"
    + "</head>\n"
    + "<body>\n"
    + "    <div class=\"correo-container\">\n"
    + "        <h2>¡Hola, Juan!</h2>\n"
    + "        <p>Este es un correo de prueba enviado desde nuestra aplicación de Spring Boot.</p>\n"
    + "        <p>Haz clic en el botón a continuación para visitar nuestro sitio:</p>\n"
    + "        <a href=\"https://www.ejemplo.com\" class=\"btn\">Ir al sitio</a>\n"
    + "        <div class=\"footer\">\n"
    + "            © 2025 Tu Empresa. Todos los derechos reservados.\n"
    + "        </div>\n"
    + "    </div>\n"
    + "</body>\n"
    + "</html>";

            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    public boolean emailSender(String addressMail, String subject, String bodyMail) throws MessagingException {
        try {
            // creación del correo
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(addressMail);
            helper.setSubject(subject);
            helper.setText(bodyMail,true);
            javaMailSender.send(message);
            ;
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
