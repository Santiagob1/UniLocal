package co.edu.uniquindio.unilocal.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CrearComentarioDTO(

        @NotBlank LocalDateTime fecha,
        @NotBlank int calificacion,
        @NotBlank String codigoCLiente,
        @NotBlank String codigoNegocio,
        @NotBlank String mensaje,
        String respuesta
) {
}
