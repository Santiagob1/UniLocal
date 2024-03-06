package co.edu.uniquindio.unilocal.modelo.entidades;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import java.time.LocalDateTime;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class HistorialRevision {

    private String codigoModerador;
    private String descripcion;
    private EstadoNegocio estadoNegocio;
    private LocalDateTime fecha;
}
