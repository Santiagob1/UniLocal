package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;

public interface HistorialServicio {
    /**
     * Permite guardar el registro del cambio de estado
     * de un negocio por un moderador
     * @param historialRevision
     * @return
     */
    String guardarHistorial(HistorialRevision historialRevision);
}
