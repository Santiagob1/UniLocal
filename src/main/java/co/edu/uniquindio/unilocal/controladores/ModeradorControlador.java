package co.edu.uniquindio.unilocal.controladores;

import co.edu.uniquindio.unilocal.dto.AutorizarRechazarNegocioDTO;
import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.MensajeDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/moderador")
@RequiredArgsConstructor
public class ModeradorControlador {
    private final ModeradorServicio moderadorServicio;
    private final NegocioServicio negocioServicio;

    @PostMapping("/autorizar-rechazar-negocio")
    public ResponseEntity<MensajeDTO<String>> autorizarRechazarNegocio(@Valid @RequestBody AutorizarRechazarNegocioDTO autorizarRechazarNegocioDTO) throws Exception {
        moderadorServicio.autorizarRechazarNegocio(autorizarRechazarNegocioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Función ejecutada correctamente"));
    }

    @GetMapping("/listar-negocios-moderador")
    public ResponseEntity<MensajeDTO<List<DetalleNegocioDTO>>> listarNegociosModerador() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, negocioServicio.listarNegocioModerador()));
    }

    @GetMapping("/filtrar-negocio-estado/{estadoNegocio}")
    public ResponseEntity<MensajeDTO<List<DetalleNegocioDTO>>> filtrarNegocioEstado(@PathVariable EstadoNegocio estadoNegocio) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, negocioServicio.filtrarPorEstado(estadoNegocio)));
    }

}
