package co.edu.uniquindio.unilocal.dto;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

public record CambiarEstadoDTO(
        String idNegocio,
        EstadoNegocio NuevoEstadoNegocio) {
}
