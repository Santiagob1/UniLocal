package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.EmailDTO;
import co.edu.uniquindio.unilocal.dto.ListarComentariosNegocioDTO;
import co.edu.uniquindio.unilocal.dto.ResponderComentarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Comentario;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.repositorios.ComentarioRepo;
import co.edu.uniquindio.unilocal.repositorios.NegocioRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final ClienteRepo clienteRepo;
    private final NegocioRepo negocioRepo;
    private final EmailServicio emailServicio;

    /**
     * Permite crear un comentario al un negocio
     * especifico
     * @param crearComentarioDTO
     * @return
     */
    @Override
    public String crearComentario(CrearComentarioDTO crearComentarioDTO) throws Exception {
        Cliente cliente = null;
        Negocio negocio = null;
        Cliente propietario = null;
        String mensajeCorreo = "";
        String codigoGuardado = "";

        cliente = clienteRepo.findByCodigo(crearComentarioDTO.codigoCLiente()).orElse(null);

        if (cliente != null) {
            negocio = negocioRepo.findById(crearComentarioDTO.codigoNegocio()).orElse(null);
            if (negocio != null) {
                Comentario comentario = Comentario.builder()
                        .calificacion(crearComentarioDTO.calificacion())
                        .codigoNegocio(crearComentarioDTO.codigoNegocio())
                        .codigoCLiente(crearComentarioDTO.codigoCLiente())
                        .mensaje(crearComentarioDTO.mensaje())
                        .idComentarioPadre(crearComentarioDTO.idComentarioPadre())
                        .fecha(crearComentarioDTO.fecha())
                        .build();
                codigoGuardado = comentarioRepo.save(comentario).getCodigo();
                if (!codigoGuardado.equals("")) {
                    propietario = clienteRepo.findByCodigo(negocio.getCodigoCliente()).orElse(null);
                    mensajeCorreo = "El usuario " + cliente.getNombre() + " comentó tú negocio ";
                    mensajeCorreo += "el comentario que realizón fue el siguiente: \n";
                    mensajeCorreo += crearComentarioDTO.mensaje();

                    emailServicio.enviarEmail(new EmailDTO(
                            "Comentario de negocip",
                            mensajeCorreo,
                            "camiramos234@gmail.com"
                    ));
                }
            } else {
                throw new Exception("El negocio no existe");
            }
        } else {
            throw new Exception("El cliente no existe");
        }

        return codigoGuardado;
    }

    /**
     * Permite obtener la lista de comentarios
     * de un negocio especifico
     * @param idNegocio
     * @return
     */
    @Override
    public List<ListarComentariosNegocioDTO> listarComentariosNegocio(String idNegocio) {
        Optional<List<Comentario>> comentariosOptional = comentarioRepo.findAllByCodigoNegocio(idNegocio);

        // Se valida si el Optional contiene un valor
        if (comentariosOptional.isPresent()) {

            // Si el Optional contiene un valor, se devuelve la lista de comentarios mapeada a DTOs
            return comentariosOptional.get().stream()
                    .map(comentario -> new ListarComentariosNegocioDTO(
                            comentario.getCodigo(),
                            comentario.getFecha(),
                            clienteRepo.findByCodigo(comentario.getCodigoCLiente()).get().getNombre(),
                            comentario.getIdComentarioPadre(),
                            comentario.getMensaje(),
                            comentario.getCalificacion()))
                    .collect(Collectors.toList());
        } else {
            // Si el Optional no contiene un valor, se devuelve una lista vacía
            return Collections.emptyList();
        }
    }

    /**
     * Permite responder un comentario de un negocio especifico
     * @param crearComentarioDTO
     * @return
     * @throws Exception
     */
    @Override
    public boolean responderComentario(CrearComentarioDTO crearComentarioDTO) throws Exception {
        Cliente cliente = null;
        Negocio negocio = null;
        Cliente usuarioComentarioPadre = null;
        String mensajeCorreo = "";
        String codigoGuardado = "";

        cliente = clienteRepo.findByCodigo(crearComentarioDTO.codigoCLiente()).orElse(null);

        if (cliente != null) {
            negocio = negocioRepo.findById(crearComentarioDTO.codigoNegocio()).orElse(null);
            if (negocio != null) {
                Comentario comentario = Comentario.builder()
                        .calificacion(crearComentarioDTO.calificacion())
                        .codigoNegocio(crearComentarioDTO.codigoNegocio())
                        .codigoCLiente(crearComentarioDTO.codigoCLiente())
                        .mensaje(crearComentarioDTO.mensaje())
                        .idComentarioPadre(crearComentarioDTO.idComentarioPadre())
                        .build();
                codigoGuardado = comentarioRepo.save(comentario).getCodigo();
                if (!codigoGuardado.equals("")) {
                    Comentario comentarioPadre = comentarioRepo.findById(crearComentarioDTO.idComentarioPadre()).orElse(null);
                    usuarioComentarioPadre = clienteRepo.findByCodigo(comentarioPadre.getCodigoCLiente()).orElse(null);
                    mensajeCorreo = "El usuario " + cliente.getNombre() + " respondió tú comentario ";
                    mensajeCorreo += "la respuesta fue la siguiente: \n";
                    mensajeCorreo += crearComentarioDTO.mensaje();

                    emailServicio.enviarEmail(new EmailDTO(
                            "Respuesta comentario",
                            mensajeCorreo,
                            usuarioComentarioPadre.getEmail()
                    ));

                    return true;
                }
            } else {
                throw new Exception("El negocio no existe");
            }
        } else {
            throw new Exception("El cliente no existe");
        }

        return false;
    }
}
