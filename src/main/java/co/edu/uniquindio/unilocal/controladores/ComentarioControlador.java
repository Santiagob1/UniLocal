package co.edu.uniquindio.unilocal.controladores;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ListarComentariosNegocioDTO;
import co.edu.uniquindio.unilocal.dto.MensajeDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comentario")
@RequiredArgsConstructor
public class ComentarioControlador {
    private final ComentarioServicio comentarioServicio;
    @PostMapping("/crear-comentario")
    public ResponseEntity<MensajeDTO<String>> crearComentario(@Valid @RequestBody CrearComentarioDTO crearComentarioDTO) throws Exception {
        comentarioServicio.crearComentario(crearComentarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Comentario registrado exitosamente"));
    }

    @GetMapping("/listar-comentarios-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<List<ListarComentariosNegocioDTO>>> listarComentariosNegocio(@PathVariable String idNegocio) throws  Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, comentarioServicio.listarComentariosNegocio(idNegocio)));
    }

    @PostMapping("/responder-comentario")
    public ResponseEntity<MensajeDTO<String>> responderComentario(CrearComentarioDTO crearComentarioDTO) throws Exception {
        comentarioServicio.responderComentario(crearComentarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Respuesta creada exitosamente"));
    }
}
