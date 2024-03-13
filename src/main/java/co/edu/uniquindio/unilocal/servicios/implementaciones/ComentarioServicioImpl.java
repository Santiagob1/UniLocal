package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.DetalleComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ResponderComentarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Comentario;
import co.edu.uniquindio.unilocal.repositorios.ComentarioRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.ComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;

    @Autowired
    public ComentarioServicioImpl(ComentarioRepo comentarioRepo) {
        this.comentarioRepo = comentarioRepo;
    }

    @Override
    public String crearComentario(CrearComentarioDTO crearComentarioDTO) {
        Comentario comentario = Comentario.builder()
                .codigoNegocio(crearComentarioDTO.codigoNegocio())
                .codigoCLiente(crearComentarioDTO.codigoCLiente())
                .mensaje(crearComentarioDTO.mensaje())
                .build();
        Comentario comentarioGuardado = comentarioRepo.save(comentario);
        return comentarioGuardado.getCodigo();
    }

    @Override
    public List<DetalleComentarioDTO> listarComentariosNegocio(String idNegocio) {
        List<Comentario> comentarios = comentarioRepo.findAllByNegocio_Id(idNegocio);
        return comentarios.stream()
                .map(comentario -> new DetalleComentarioDTO(
                        comentario.getId(),
                        comentario.getContenido(),
                        comentario.getEstadoComentario().name()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean responderComentario(ResponderComentarioDTO responderComentarioDTO) {
        Comentario comentarioPadre = comentarioRepo.findById(responderComentarioDTO.getIdComentarioPadre())
                .orElse(null);
        if (comentarioPadre != null) {
            Comentario respuesta = Comentario.builder()
                    .idNegocio(comentarioPadre.getNegocio().getId())
                    .idCliente(responderComentarioDTO.getIdCliente())
                    .contenido(responderComentarioDTO.getContenido())
                    .estadoComentario(EstadoComentario.PENDIENTE)
                    .comentarioPadre(comentarioPadre)
                    .build();
            comentarioRepo.save(respuesta);
            return true;
        }
        return false;
    }
}
