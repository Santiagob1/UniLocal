package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.ActualizacionNegocioDTO;
import co.edu.uniquindio.unilocal.dto.CambiarEstadoDTO;
import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.RegistroNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import co.edu.uniquindio.unilocal.repositorios.NegocioRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;

    /**
     * Permite crear el negocio en la base de datos
     * @param negocioDTO
     * @return
     */
    @Override
    public String crearNegocio(RegistroNegocioDTO negocioDTO) {
        Map<String, String> imagenes = negocioDTO.imagenes().stream().collect(
                Collectors.toMap(x -> x.id(), x -> x.url()));

        Negocio negocio = Negocio.builder()
                .nombre(negocioDTO.nombre())
                .descripcion(negocioDTO.descripcion())
                .tipoNegocio(negocioDTO.tipoNegocio())
                .codigoCliente(negocioDTO.codigoCliente())
                .ubicacion(negocioDTO.ubicacion())
                .estado(EstadoNegocio.PENDIENTE)
                .horario(negocioDTO.horario())
                .imagenes(imagenes)
                .build();
        Negocio negocioGuardado = negocioRepo.save(negocio);
        return negocioGuardado.getCodigo();
    }

    /**
     * Permite actualizar un negocio especifico
     * @param actualizacionNegocioDTO
     * @return true o false
     */
    @Override
    public boolean actualizarNegocio(ActualizacionNegocioDTO actualizacionNegocioDTO) {
        Map<String, String> imagenes = actualizacionNegocioDTO.imagenes().stream().collect(
                Collectors.toMap(x -> x.id(), x -> x.url()));
        Negocio negocio = negocioRepo.findById(actualizacionNegocioDTO.codigo()).orElse(null);
        if (negocio != null) {
            negocio.setNombre(actualizacionNegocioDTO.nombre());
            negocio.setDescripcion(actualizacionNegocioDTO.descripcion());
            negocio.setUbicacion(actualizacionNegocioDTO.ubicacion());
            negocio.setImagenes(imagenes);
            negocio.setTipoNegocio(actualizacionNegocioDTO.tipoNegocio());
            negocio.setLstMenuNegocio(actualizacionNegocioDTO.lstMenu());
            negocio.setHorario(actualizacionNegocioDTO.horario());
            negocio.setTelefonos(actualizacionNegocioDTO.telefonos());

            negocioRepo.save(negocio);
            return true;
        }
        return false;
    }

    /**
     * Permite eliminar logicamente un negocio
     * @param idNegocio
     * @return
     */
    @Override
    public boolean eliminarNegocio(String idNegocio) {

        Negocio negocio = negocioRepo.findById(idNegocio).orElse(null);

        if (negocio != null) {
            negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);
            negocioRepo.save(negocio);
            return true;
        }

        return false;
    }

    /**
     * Permite obtener un negocio mediante si ID
     * @param idNegocio
     * @return
     */
    @Override
    public DetalleNegocioDTO obtenerNegocio(String idNegocio) {
        Negocio negocio = negocioRepo.findById(idNegocio).orElse(null);
        if (negocio != null) {
            return new DetalleNegocioDTO(
                    negocio.getCodigo(),
                    negocio.getNombre(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente(),
                    negocio.getEstado(),
                    negocio.getUbicacion(),
                    negocio.getLstMenuNegocio()
            );
        }
        return null;
    }


    /**
     * Permite obtener un negocio especifico mediante su nombre
     * @param nombreNegocio
     * @return
     */
    @Override
    public List<DetalleNegocioDTO> buscarNegocioNombre(String nombreNegocio) {
        List<Negocio> negocios = negocioRepo.findByNombre(nombreNegocio);
        if (negocios != null) {
            return negocios.stream().filter(x -> x.getEstado().equals(EstadoNegocio.APROVADO) && x.getEstadoRegistro().equals(EstadoRegistro.ACTIVO))
                    .map(negocio -> new DetalleNegocioDTO(
                            negocio.getCodigo(),
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCodigoCliente(),
                            negocio.getEstado(),
                            negocio.getUbicacion(),
                            negocio.getLstMenuNegocio()
                    ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Permite obtener una lista de negocios mediante su tipo
     * @param tipoNegocio
     * @return
     */
    @Override
    public List<DetalleNegocioDTO> buscarNegocioTipo(TipoNegocio tipoNegocio) {
        List<Negocio> negocios = negocioRepo.findByTipoNegocio(tipoNegocio);
        if (negocios != null) {
            return negocios.stream().filter(x -> x.getEstado().equals(EstadoNegocio.APROVADO) && x.getEstadoRegistro().equals(EstadoRegistro.ACTIVO))
                    .map(negocio -> new DetalleNegocioDTO(
                            negocio.getCodigo(),
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCodigoCliente(),
                            negocio.getEstado(),
                            negocio.getUbicacion(),
                            negocio.getLstMenuNegocio()
                    ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Permite filtrar los negocios por un estado especifico
     * @param estadoNegocio
     * @return negocios
     */
    @Override
    public List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        List<Negocio> negocios = negocioRepo.findByEstado(estadoNegocio);
        if (negocios != null && negocios.size() > 0) {
            return negocios.stream()
                    .map(negocio -> new DetalleNegocioDTO(
                            negocio.getCodigo(),
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCodigoCliente(),
                            negocio.getEstado(),
                            negocio.getUbicacion(),
                            negocio.getLstMenuNegocio()
                    ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Permite listas los negocios de los clientes
     * o propiertarios
     * @param idPropietario
     * @return negocios
     */
    @Override
    public List<DetalleNegocioDTO> listarNegocioPropietario(String idPropietario) {
        List<Negocio> negocios = negocioRepo.findByCodigoCliente(idPropietario);
        if (negocios != null && negocios.size() > 0) {
            return negocios.stream()
                    .map(negocio -> new DetalleNegocioDTO(
                            negocio.getCodigo(),
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCodigoCliente(),
                            negocio.getEstado(),
                            negocio.getUbicacion(),
                            negocio.getLstMenuNegocio()
                    ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Permite obtener todos los negocios creados
     * para que el moderador los apruebe
     * @return
     */
    @Override
    public List<DetalleNegocioDTO> listarNegocioModerador() {
        List<Negocio> lstNegocios = negocioRepo.findAll();

        if (lstNegocios != null && lstNegocios.size() > 0) {
            return lstNegocios.stream()
                    .map(negocio -> new DetalleNegocioDTO(
                            negocio.getCodigo(),
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCodigoCliente(),
                            negocio.getEstado(),
                            negocio.getUbicacion(),
                            negocio.getLstMenuNegocio()
                    ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Permite actualizar el estado del negocio
     * @param cambiarEstadoDTO
     * @return
     */
    @Override
    public boolean cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO) {
        Negocio negocio = negocioRepo.findById(cambiarEstadoDTO.idNegocio()).orElse(null);
        if (negocio != null) {
            negocio.setEstado(cambiarEstadoDTO.NuevoEstadoNegocio());
            negocioRepo.save(negocio);
            return true;
        }
        return false;
    }

    @Override
    public double calcularPromedioCalificacion() {
        // Lógica para calcular el promedio de calificaciones de los negocios
        return 0; // Por ahora, solo devuelve 0
    }

    /**
     * Permite obtener un negocio directamente de la base de datos
     * mediante su ID
     * @param codigoNegocio
     * @return negocio
     * @throws Exception
     */
    @Override
    public Negocio obtenerNegocioDirecto(String codigoNegocio) throws Exception {
        Optional<Negocio> negocio = negocioRepo.findById(codigoNegocio);

        if (negocio.isEmpty()) {
            throw new Exception("El negocio con código " + codigoNegocio + " no existe en la base de datos");
        }

        return negocio.get();
    }
}
