package co.edu.uniquindio.unilocal.dto;

import java.time.LocalDateTime;

public record ListarComentariosNegocioDTO(
        String codigo,
        String fecha,
        String nombreCLiente,
        String idComentarioPadre,
        String mensaje,
        int calificacion) {
}
