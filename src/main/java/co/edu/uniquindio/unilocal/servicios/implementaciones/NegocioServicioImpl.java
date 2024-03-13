package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.ActualizacionNegocioDTO;
import co.edu.uniquindio.unilocal.dto.CambiarEstadoDTO;
import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.RegistroNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.repositorios.NegocioRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;

    @Autowired
    public NegocioServicioImpl(NegocioRepo negocioRepo) {
        this.negocioRepo = negocioRepo;
    }

    @Override
    public String crearNegocio(RegistroNegocioDTO negocioDTO) {
        Negocio negocio = Negocio.builder()
                .nombre(negocioDTO.getNombre())
                .descripcion(negocioDTO.getDescripcion())
                .propietario(negocioDTO.getPropietario())
                .estado(negocioDTO.getEstado())
                // Otras propiedades del negocio
                .build();
        Negocio negocioGuardado = negocioRepo.save(negocio);
        return negocioGuardado.getId();
    }

    @Override
    public boolean actualizarNegocio(ActualizacionNegocioDTO actualizacionNegocioDTO) {
        Negocio negocio = negocioRepo.findById(actualizacionNegocioDTO.getIdNegocio()).orElse(null);
        if (negocio != null) {
            negocio.setNombre(actualizacionNegocioDTO.getNuevoNombre());
            negocio.setDescripcion(actualizacionNegocioDTO.getNuevaDescripcion());
            // Actualizar otras propiedades según sea necesario
            negocioRepo.save(negocio);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarNegocio(String idNegocio) {
        negocioRepo.deleteById(idNegocio);
        return true;
    }

    @Override
    public DetalleNegocioDTO obtenerNegocio(String idNegocio) {
        Negocio negocio = negocioRepo.findById(idNegocio).orElse(null);
        if (negocio != null) {
            return new DetalleNegocioDTO(
                    negocio.getId(),
                    negocio.getNombre(),
                    negocio.getDescripcion(),
                    negocio.getPropietario(),
                    negocio.getEstado()
                    // Otras propiedades que desees devolver en el DTO
            );
        }
        return null;
    }

    @Override
    public DetalleNegocioDTO buscarNegocioNombre(String nombreNegocio) {
        Negocio negocio = negocioRepo.findByNombre(nombreNegocio).orElse(null);
        if (negocio != null) {
            return new DetalleNegocioDTO(
                    negocio.getId(),
                    negocio.getNombre(),
                    negocio.getDescripcion(),
                    negocio.getPropietario(),
                    negocio.getEstado()
                    // Otras propiedades que desees devolver en el DTO
            );
        }
        return null;
    }

    @Override
    public List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        List<Negocio> negocios = negocioRepo.findByEstado(estadoNegocio);
        return negocios.stream()
                .map(negocio -> new DetalleNegocioDTO(
                        negocio.getId(),
                        negocio.getNombre(),
                        negocio.getDescripcion(),
                        negocio.getPropietario(),
                        negocio.getEstado()
                        // Otras propiedades que desees devolver en el DTO
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<DetalleNegocioDTO> listarNegocioPropietario(String idPropietario) {
        List<Negocio> negocios = negocioRepo.findByPropietario(idPropietario);
        return negocios.stream()
                .map(negocio -> new DetalleNegocioDTO(
                        negocio.getId(),
                        negocio.getNombre(),
                        negocio.getDescripcion(),
                        negocio.getPropietario(),
                        negocio.getEstado()
                        // Otras propiedades que desees devolver en el DTO
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<DetalleNegocioDTO> listarNegocioModerador(String idModerador) {
        // Lógica para listar negocios asignados a un moderador
        return null; // Por ahora, solo devuelve null
    }

    @Override
    public boolean cambiarEstado(CambiarEstadoDTO cambiarEstadoDTO) {
        Negocio negocio = negocioRepo.findById(cambiarEstadoDTO.getIdNegocio()).orElse(null);
        if (negocio != null) {
            negocio.setEstado(cambiarEstadoDTO.getNuevoEstado());
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
}
