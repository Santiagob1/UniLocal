package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.InicioSesionDTO;
import co.edu.uniquindio.unilocal.dto.TokenDTO;

public interface CuentaServicio {
    TokenDTO iniciarSesionCliente(InicioSesionDTO inicioSesionDTO) throws Exception;
    TokenDTO iniciarSesionModerador(InicioSesionDTO inicioSesionDTO) throws Exception;
}
