package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionNegocioDTO;
import co.edu.uniquindio.unilocal.dto.CambiarEstadoDTO;
import co.edu.uniquindio.unilocal.dto.RegistroNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

public interface NegocioServicio {

    void crearNegocio(RegistroNegocioDTO negocioDTO);
    void actualizarNegocio(ActualizacionNegocioDTO actualizacionNegocioDTO);
    void eliminarNegocio(String idNegocio);
    void obtenerNegocio(String idNegocio);
    void buscarNegocioNombre(String nombreNegocio);
    void filtrarPorEstado(EstadoNegocio estadoNegocio);
    void listarNegocioPropietario(String idPropietario);
    void listarNegocioModerador(String idModerador);
    void cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO);
    void calcularPromedioCalificacion();


}
