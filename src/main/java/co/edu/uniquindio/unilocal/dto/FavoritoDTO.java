package co.edu.uniquindio.unilocal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FavoritoDTO(
        @NotBlank @NotNull String codigoCliente,
        @NotBlank @NotNull String codigoNegocio
) {
}
