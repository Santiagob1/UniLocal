package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionNegocioDTO;
import co.edu.uniquindio.unilocal.dto.CambiarEstadoDTO;
import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.RegistroNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;

import java.util.List;

public interface NegocioServicio {
    /**
     * Permite crear le negocio en la base de datos
     * @param negocioDTO
     * @return codigoNuevo
     */
    String crearNegocio(RegistroNegocioDTO negocioDTO);

    /**
     * Permite actualizar el negocio especifico
     * @param actualizacionNegocioDTO
     * @return true o false
     */
    boolean actualizarNegocio(ActualizacionNegocioDTO actualizacionNegocioDTO);

    /**
     * Permite eliminar logicamente un negocio
     * @param idNegocio
     * @return
     */
    boolean eliminarNegocio(String idNegocio);

    /**
     * Permite obtener un negocio mediante su ID
     * @param idNegocio
     * @return detalleNegocioDTO
     */
    DetalleNegocioDTO obtenerNegocio(String idNegocio);

    /**
     * Permite obtener una lista de negocios por su tipo
     * @param nombreNegocio
     * @return detalleNegocioDTO
     */
    List<DetalleNegocioDTO> buscarNegocioNombre(String nombreNegocio);

    /**
     * Permite obtener una lista de negocios por su tipo
     * @param tipoNegocio
     * @return
     */
    List<DetalleNegocioDTO> buscarNegocioTipo(TipoNegocio tipoNegocio);

    /**
     * Permite obtener un negocio mediante un estado especifico
     * @param estadoNegocio
     * @return detalleNegocioDTO
     */
    List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);

    /**
     * Permite obtener la lista de
     * @param idPropietario
     * @return
     */
    List<DetalleNegocioDTO> listarNegocioPropietario(String idPropietario);

    /**
     * Permite listar todos los negocios
     * @return lstNegocios
     */
    List<DetalleNegocioDTO> listarNegocioModerador();

    /**
     * Permite actualizar el estado del negocio
     * @param cambiarEstadoDTO
     * @return true o false
     */
    boolean cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO);
    double calcularPromedioCalificacion();

    /**
     * Permite obtener un negocio directamente de la base de datos
     * este método solo se utiliza internamente en el back de la aplicación
     * @param codigoNegocio
     * @return negocio
     * @throws Exception
     */
    Negocio obtenerNegocioDirecto(String codigoNegocio) throws Exception;

    /**
     * Permite actualizar la fecha de rechazo de un negocio especifico
     * @param negocio
     * @throws Exception
     */
    void actualizarNegocioRechazo(Negocio negocio) throws Exception;


}
