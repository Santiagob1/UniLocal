package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.DetalleComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ResponderComentarioDTO;

import java.util.List;

public interface ComentarioServicio {
    String crearComentario(CrearComentarioDTO crearComentarioDTO);
    List<DetalleComentarioDTO> listarComentariosNegocio(String idNegocio);
    boolean responderComentario(ResponderComentarioDTO responderComentarioDTO);

}
