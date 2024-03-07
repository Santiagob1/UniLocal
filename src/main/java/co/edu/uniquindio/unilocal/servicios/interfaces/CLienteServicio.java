package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.unilocal.dto.RecuperarPasswordDTO;
import co.edu.uniquindio.unilocal.dto.RegistroUsuarioDTO;

public interface CLienteServicio extends CuentaServicio{
    void registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception;
    void eliminarCuenta(String idCliente) throws Exception;
    void enviarLinkRecuperacion(String email) throws Exception;
    void recuperarPassword(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception;
    void editarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception;
    void obtenerCliente(String idCliente) throws Exception;

}
