package co.edu.uniquindio.unilocal.modelo.entidades;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class HistorialRevision {

    private String codigoModerador;
    private String descripcion;
    private EstadoNegocio estadoNegocio;
    private LocalDateTime fecha;
}
