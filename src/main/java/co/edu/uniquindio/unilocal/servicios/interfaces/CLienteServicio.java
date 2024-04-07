package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.unilocal.dto.DetalleClienteDTO;
import co.edu.uniquindio.unilocal.dto.RecuperarPasswordDTO;
import co.edu.uniquindio.unilocal.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;

public interface CLienteServicio{
    String registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception;
    boolean editarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception;
    boolean eliminarCuenta(String idCliente) throws Exception;
    boolean enviarLinkRecuperacion(String email) throws Exception;
    boolean cambiarContrasena(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception;
    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception;
    Cliente obtenerClienteDirecto(String idCliente) throws Exception;
    boolean crearNegocioFavoritoCliente(Cliente cliente) throws Exception;

}
