package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionNegocioDTO;
import co.edu.uniquindio.unilocal.dto.CambiarEstadoDTO;
import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.RegistroNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

import java.util.List;

public interface NegocioServicio {

    String crearNegocio(RegistroNegocioDTO negocioDTO);
    boolean actualizarNegocio(ActualizacionNegocioDTO actualizacionNegocioDTO);
    boolean eliminarNegocio(String idNegocio);
    DetalleNegocioDTO obtenerNegocio(String idNegocio);
    DetalleNegocioDTO buscarNegocioNombre(String nombreNegocio);
    List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);
    List<DetalleNegocioDTO> listarNegocioPropietario(String idPropietario);
    List<DetalleNegocioDTO> listarNegocioModerador(String idModerador);
    boolean cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO);
    double calcularPromedioCalificacion();


}
