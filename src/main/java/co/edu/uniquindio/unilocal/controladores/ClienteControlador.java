package co.edu.uniquindio.unilocal.controladores;

import co.edu.uniquindio.unilocal.dto.*;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClienteControlador {

    private final CLienteServicio cLienteServicio;
    private final NegocioServicio negocioServicio;

    @PostMapping("/registrar-cliente")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        cLienteServicio.registrarse(registroUsuarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cliente registrado exitosamente"));
    }
    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception {
        cLienteServicio.editarPerfil(actualizacionUsuarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cliente actualizado exitosamente"));
    }

    @DeleteMapping("/eliminar-cuenta/{idCliente}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable String idCliente) throws Exception {
        cLienteServicio.eliminarCuenta(idCliente);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cliente eliminado exitosamente"));
    }

    @GetMapping("/obtener/{idCliente}")
    public ResponseEntity<MensajeDTO<DetalleClienteDTO>> obtenerCliente(@PathVariable String idCliente) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, cLienteServicio.obtenerCliente(idCliente)));
    }

    @GetMapping("/listar-negocios-propietario")
    public ResponseEntity<MensajeDTO<List<DetalleNegocioDTO>>> listarNegociosPropietario(@PathVariable String idPropietario) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, negocioServicio.listarNegocioPropietario(idPropietario)));
    }

    @GetMapping("/recuperar-password")
    public ResponseEntity<MensajeDTO<String>> recuperarContrasena(@PathVariable String email)  throws Exception {
        cLienteServicio.enviarLinkRecuperacion(email);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Link enviado correctamente"));
    }

    @PostMapping("/cambiar-password")
    public ResponseEntity<MensajeDTO<String>> cambiarContrasena(@Valid @RequestBody RecuperarPasswordDTO recuperarPasswordDTO)  throws Exception {
        cLienteServicio.cambiarContrasena(recuperarPasswordDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Contraseña actualizada correctamente"));
    }
}
