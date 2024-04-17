package co.edu.uniquindio.unilocal.controladores;

import co.edu.uniquindio.unilocal.dto.FavoritoDTO;
import co.edu.uniquindio.unilocal.dto.FavoritoDetalleDTO;
import co.edu.uniquindio.unilocal.dto.MensajeDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioFavoritoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/negocio-favorito")
@RequiredArgsConstructor
public class NegocioFavoritoControlador {
    private final NegocioFavoritoServicio negocioFavoritoServicio;

    @PostMapping("/crear-favorito-cliente")
    public ResponseEntity<MensajeDTO<String>> crearFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        negocioFavoritoServicio.crearFavoritosUsuario(favoritoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Negocio favorito agregado correctamente"));
    }

    @PostMapping("/eliminar-favorito-cliente")
    public ResponseEntity<MensajeDTO<String>> eliminarFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        negocioFavoritoServicio.eliminarFavoritoUsuarios(favoritoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Negocio favorito eliminado correctamente"));
    }

    @GetMapping("/obtener-favorito-cliente/{idCliente}")
    public ResponseEntity<MensajeDTO<FavoritoDetalleDTO>> obtenerFavoritoCliente(@PathVariable String idCliente) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, negocioFavoritoServicio.otenerFavoritoCliente(idCliente)));
    }


}
