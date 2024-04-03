package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.AutorizarRechazarNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;

public interface ModeradorServicio extends CuentaServicio{

    /**
     * Permite autorizar o rechazar un negocio
     * @param autorizarRechazarNegocioDTO
     * @return
     * @throws Exception
     */
    boolean autorizarRechazarNegocio(AutorizarRechazarNegocioDTO autorizarRechazarNegocioDTO) throws Exception;
}
