package co.edu.uniquindio.unilocal.dto;

import java.time.LocalDateTime;

public record ListarComentariosNegocioDTO(
        String codigo,
        LocalDateTime fecha,
        String nombreCLiente,
        String idComentarioPadre,
        String mensaje,
        int calificacion) {
}
