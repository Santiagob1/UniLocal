package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.EmailDTO;

public interface EmailServicio {
    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
