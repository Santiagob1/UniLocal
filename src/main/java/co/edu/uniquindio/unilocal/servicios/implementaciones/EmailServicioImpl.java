package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.EmailDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Getter
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {
    private final JavaMailSender javaMailSender;
    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception{
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.cuerpo(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);
    }
}
