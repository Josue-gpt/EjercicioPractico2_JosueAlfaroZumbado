package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import EjercicioPractico2_JosueAlfaroZumbado.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String para, String asunto, String contenido) {

        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

            helper.setTo(para);
            helper.setSubject(asunto);
            helper.setText(contenido, true); // HTML

            mailSender.send(mensaje);

        } catch (Exception e) {
            System.out.println("Error enviando correo: " + e.getMessage());
        }
    }
}