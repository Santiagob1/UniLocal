package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.*;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.EmailServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServicioImpl implements CLienteServicio {

    private final ClienteRepo clienteRepo;
    private final EmailServicio emailServicio;


    /**
     * Permite registrar un cliente
     * @param registroUsuarioDTO
     * @return
     * @throws Exception
     */
    @Override
    public String registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        //Crear validaciones que se reuqieran
        if (existeNickname(registroUsuarioDTO.nickName())) {
            throw new Exception("El Nickname " + registroUsuarioDTO.nickName() + "Ya está registrado.");
        }
        if (existeEmail(registroUsuarioDTO.email())) {
            throw new Exception("El email  " + registroUsuarioDTO.email() + " Ya está registrado.");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(registroUsuarioDTO.password());

        Cliente cliente = Cliente.builder()
                .email(registroUsuarioDTO.email())
                .nombre(registroUsuarioDTO.nombre())
                .password(passwordEncriptada)
                .estadoRegistro(EstadoRegistro.ACTIVO)
                .ciudad(registroUsuarioDTO.Ciudad())
                .fotoPerfil(registroUsuarioDTO.fotoPerfil())
                .nickName(registroUsuarioDTO.nickName())
                .build();

        Cliente clienteRegistrado = clienteRepo.save(cliente);

        return clienteRegistrado.getCodigo();
    }

    /**
     * Permite validar la existencia del nickname o nombre de usuario
     * @param nickName
     * @return
     */
    private boolean existeNickname(String nickName) {
        return clienteRepo.findByNickName(nickName).isPresent();
    }

    /**
     * Permite validar si ya existe un email
     * @param email
     * @return
     */
    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }

    /**
     * Permite eliminar un cliente logicamente
     * cambiando su estado
     * @param idCliente
     * @return
     * @throws Exception
     */
    @Override
    public boolean eliminarCuenta(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setEstadoRegistro(EstadoRegistro.INACTIVO);
            clienteRepo.save(cliente);
            return true;
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + idCliente);
        }
    }

    /**
     * Permite enviar el link para cambiar la contraseña de un
     * cliente
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public boolean enviarLinkRecuperacion(String email) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmail(email);
        if (clienteOptional.isPresent()) {

            // Se debe actualizar con el link de recuperación de la contaseña
            emailServicio.enviarEmail(new EmailDTO(
                    "Reestablecer contraseña",
                    "Da click en el siguiente link para actualizar tú contraseña: \n" +
                            "link: ",
                    email
            ));

            return true; // Si se envía correctamente
        } else {
            throw new Exception("Cliente no encontrado con el email: " + email);
        }
    }

    /**
     * Permite actualizar la contraseña de un cliente
     * @param recuperarPasswordDTO
     * @return
     * @throws Exception
     */
    @Override
    public boolean cambiarContrasena(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmail(recuperarPasswordDTO.email());
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            // Actualizar la contraseña del cliente
            // Agregar método para encriptar la contraseña
            cliente.setPassword(recuperarPasswordDTO.contrasenaNueva());
            clienteRepo.save(cliente);
            return true;
        } else {
            throw new Exception("Cliente no encontrado con el email: " + recuperarPasswordDTO.email());
        }
    }

    /**
     * Permite modificar el perfil del usuario
     * @param actualizacionUsuarioDTO
     * @return
     * @throws Exception
     */
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

    /**
     * Permite obetner un cliente especifico
     * @param idCliente
     * @return
     * @throws Exception
     */
    @Override
    public DetalleClienteDTO obtenerCliente(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            DetalleClienteDTO detalleClienteDTO = new DetalleClienteDTO(
                    idCliente,
                    cliente.getNombre(),
                    cliente.getFotoPerfil(),
                    cliente.getCiudad()
            );
            return detalleClienteDTO;
        } else {
            throw new Exception("Cliente no encontrado con el ID: " + idCliente);
        }
    }

    /**
     * Permite obtener un cliente directo de la base de datos
     * @param idCliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente obtenerClienteDirecto(String idCliente) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByCodigo(idCliente);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        }
        return null;
    }

    /**
     * Permite guardar el cambio realizado para los favoritos
     * @param cliente
     * @return
     * @throws Exception
     */
    @Override
    public boolean crearNegocioFavoritoCliente(Cliente cliente) throws Exception {
        return !clienteRepo.save(cliente).getCodigo().equals("");
    }
}
