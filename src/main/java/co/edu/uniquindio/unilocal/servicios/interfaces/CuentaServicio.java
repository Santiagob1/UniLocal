package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.InicioSesionDTO;

public interface CuentaServicio {
    void iniciarSesion(InicioSesionDTO inicioSesionDTO) throws Exception;
}
