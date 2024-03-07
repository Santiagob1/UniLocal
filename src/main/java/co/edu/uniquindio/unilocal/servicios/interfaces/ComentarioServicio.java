package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;

public interface ComentarioServicio {
    void crearComentario(CrearComentarioDTO crearComentarioDTO);
    void listarComentariosNegocio(String idNegocio);
    void responderComentario(String idComentario);

}
