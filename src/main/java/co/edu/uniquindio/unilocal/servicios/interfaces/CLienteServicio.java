package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.unilocal.dto.RecuperarPasswordDTO;
import co.edu.uniquindio.unilocal.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;

public interface CLienteServicio extends CuentaServicio{
    String registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception;
    boolean eliminarCuenta(String idCliente) throws Exception;
    boolean enviarLinkRecuperacion(String email) throws Exception;
    boolean recuperarPassword(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception;
    boolean editarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception;
    Cliente obtenerCliente(String idCliente) throws Exception;

}
