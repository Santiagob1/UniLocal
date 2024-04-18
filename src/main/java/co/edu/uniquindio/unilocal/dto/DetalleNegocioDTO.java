package co.edu.uniquindio.unilocal.dto;

import co.edu.uniquindio.unilocal.modelo.documentos.Menu;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

import java.util.List;

public record DetalleNegocioDTO(
        String codigoNegocio,
        String nombre,
        String descripcion,
        String codigoCliente,
        EstadoNegocio estadoNegocio,
        Ubicacion ubicacion,
        List<Menu> lstMenu,
        double calificacionPromedio
) {
}
