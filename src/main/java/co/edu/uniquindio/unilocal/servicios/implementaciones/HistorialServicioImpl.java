package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.repositorios.HistorialRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.HistorialServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HistorialServicioImpl implements HistorialServicio {

    private final HistorialRepo historialRepo;

    /**
     * Permite guardar el historial de revisión
     * que hizo un moderador
     * @param historialRevision
     * @return
     */
    @Override
    public String guardarHistorial(HistorialRevision historialRevision) {
        return historialRepo.save(historialRevision).getCodigo();
    }
}
