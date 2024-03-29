package co.edu.uniquindio.unilocal.dto;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

public record AutorizarRechazarNegocioDTO(
        String idNegocio,
        String idModerador,
        EstadoNegocio estado,
        String motivo
) {
}
