package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.ModeradorServicio;
import org.springframework.stereotype.Service;

@Service
public class ModeradorServicioImpl implements ModeradorServicio {

    @Override
    public boolean iniciarSesion(InicioSesionDTO inicioSesionDTO) throws Exception {
        // Lógica para iniciar sesión de un moderador
        // Esto podría ser similar a la implementación en CuentaServicioImpl
        return false; // Por ahora, solo devuelve false
    }

    @Override
    public boolean autorizarNegocio(String idNegocio) {
        // Lógica para autorizar un negocio
        // Esto podría implicar cambiar el estado del negocio en la base de datos, etc.
        return false; // Por ahora, solo devuelve false
    }
}
