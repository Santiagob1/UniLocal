package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.*;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicioImpl implements CLienteServicio {

    private final ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        //Crear validaciones que se reuqieran

        if (existeNickname(registroUsuarioDTO.nickName())){
            throw new Exception("El Nickname " + registroUsuarioDTO.nickName() + "Ya está registrado.");
        }
        if (existeEmail(registroUsuarioDTO.email())){
            throw new Exception("El email  " + registroUsuarioDTO.email() + " Ya está registrado.");
        }
        Cliente cliente = Cliente.builder()
                .email(registroUsuarioDTO.email())
                .nombre(registroUsuarioDTO.nombre())
                .password(registroUsuarioDTO.password())
                .estadoRegistro(EstadoRegistro.ACTIVO)
                .ciudad(registroUsuarioDTO.Ciudad())
                .fotoPerfil(registroUsuarioDTO.fotoPerfil())
                .nickName(registroUsuarioDTO.nickName())
                .build();

        Cliente clienteRegistrado = clienteRepo.save(cliente);

        return clienteRegistrado.getCodigo();
    }

    private boolean existeNickname(String nickName) {
        return clienteRepo.findByNickname(nickName).isPresent();
    }
    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }

    @Override
    public boolean eliminarCuenta(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            clienteRepo.delete(clienteOptional.get());
            return true;
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + idCliente);
        }
    }

    @Override
    public boolean enviarLinkRecuperacion(String email) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmail(email);
        if (clienteOptional.isPresent()) {
            // Lógica para enviar el link de recuperación por email
            return true; // Si se envía correctamente
        } else {
            throw new Exception("Cliente no encontrado con el email: " + email);
        }
    }

    @Override
    public boolean recuperarPassword(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmail(recuperarPasswordDTO.email());
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            // Actualizar la contraseña del cliente
            cliente.setPassword(recuperarPasswordDTO.contrasenaNueva());
            clienteRepo.save(cliente);
            return true;
        } else {
            throw new Exception("Cliente no encontrado con el email: " + recuperarPasswordDTO.email());
        }
    }

    @Override
    public boolean editarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(actualizacionUsuarioDTO.id());
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            // Actualizar los campos del perfil del cliente
            cliente.setNombre(actualizacionUsuarioDTO.nombre());
            cliente.setCiudad(actualizacionUsuarioDTO.ciudadResidencia());
            cliente.setFotoPerfil(actualizacionUsuarioDTO.fotoPerfil());
            clienteRepo.save(cliente);
            return true;
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + actualizacionUsuarioDTO.id());
        }
    }

    @Override
    public Cliente obtenerCliente(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + idCliente);
        }
    }
    @Override
    public DetalleClienteDTO obtenerDetalleCliente(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            return new DetalleClienteDTO(clienteOptional.get().getNombre(), clienteOptional.get().getFotoPerfil());
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + idCliente);
        }
    }


    @Override
    public void iniciarSesion(InicioSesionDTO inicioSesionDTO) throws Exception {

    }
}
