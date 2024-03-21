package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ListarComentariosNegocioDTO;
import co.edu.uniquindio.unilocal.dto.ResponderComentarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Comentario;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.repositorios.ComentarioRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.ComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
                .calificacion(crearComentarioDTO.calificacion())
                .respuesta(crearComentarioDTO.respuesta())
                .codigoNegocio(crearComentarioDTO.codigoNegocio())
                .codigoCLiente(crearComentarioDTO.codigoCLiente())
                .mensaje(crearComentarioDTO.mensaje())
                .build();
        Comentario comentarioGuardado = comentarioRepo.save(comentario);
        return comentarioGuardado.getCodigo();
    }

    @Override
    public List<ListarComentariosNegocioDTO> listarComentariosNegocio(String idNegocio) {
        Optional<List<Comentario>> comentariosOptional = comentarioRepo.findAllByCodigoNegocio(idNegocio);

        ClienteServicioImpl cliente = new ClienteServicioImpl()
        // Se valida si el Optional contiene un valor
        if (comentariosOptional.isPresent()) {

            // Si el Optional contiene un valor, se devuelve la lista de comentarios mapeada a DTOs
            return comentariosOptional.get().stream()
                    .map(comentario -> new ListarComentariosNegocioDTO(
                            comentario.getCodigo(),
                            comentario.getFecha(),
                            ,
                            "",
                            comentario.getMensaje()))
                    .collect(Collectors.toList());
        } else {
            // Si el Optional no contiene un valor, se devuelve una lista vacía
            return Collections.emptyList();
        }
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
