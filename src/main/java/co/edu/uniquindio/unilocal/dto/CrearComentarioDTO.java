package co.edu.uniquindio.unilocal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CrearComentarioDTO(

        @NotNull String fecha,
        @NotNull int calificacion,
        @NotBlank String codigoCliente,
        @NotBlank String codigoNegocio,
        @NotBlank String mensaje,
        @NotBlank String idComentarioPadre
) {
}
