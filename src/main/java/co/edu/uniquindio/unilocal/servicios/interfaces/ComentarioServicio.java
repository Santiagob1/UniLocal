package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ListarComentariosNegocioDTO;
import co.edu.uniquindio.unilocal.dto.ResponderComentarioDTO;

import java.util.List;

public interface ComentarioServicio {
    String crearComentario(CrearComentarioDTO crearComentarioDTO) throws Exception;
    List<ListarComentariosNegocioDTO> listarComentariosNegocio(String idNegocio);
    boolean responderComentario(CrearComentarioDTO responderComentarioDTO) throws Exception;

}
