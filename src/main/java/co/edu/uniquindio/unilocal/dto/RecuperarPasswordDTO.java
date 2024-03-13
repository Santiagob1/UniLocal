package co.edu.uniquindio.unilocal.dto;

import jakarta.validation.constraints.NotBlank;

public record RecuperarPasswordDTO(
        @NotBlank String codigoSeguridad,
        @NotBlank String contrasenaNueva,
        @NotBlank String email

) {
}
