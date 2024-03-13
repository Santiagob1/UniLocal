package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.InicioSesionDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServicioImpl implements CuentaServicio {

    private final ClienteRepo clienteRepo;

    @Autowired
    public CuentaServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public boolean iniciarSesion(InicioSesionDTO inicioSesionDTO) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmailAndPassword(inicioSesionDTO.getEmail(), inicioSesionDTO.getPassword());
        if (clienteOptional.isPresent()) {
            // Iniciar sesión exitosa
            return true;
        } else {
            // Si el cliente no está registrado o la contraseña es incorrecta
            throw new Exception("Credenciales inválidas. Por favor, verifique su email y contraseña.");
        }
    }
}
