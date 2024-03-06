package co.edu.uniquindio.unilocal.dto;

import jakarta.validation.constraints.NotBlank;

public record InicioSesionDTO(
        @NotBlank String nickname,
        @NotBlank String password
) {
}
