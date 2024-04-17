package co.edu.uniquindio.unilocal.modelo.entidades;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class HistorialRevision {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String codigoModerador;
    private String descripcion;
    private EstadoNegocio estadoNegocio;
    private String fecha;
}
