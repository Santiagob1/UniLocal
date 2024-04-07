package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.InicioSesionDTO;
import co.edu.uniquindio.unilocal.dto.TokenDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Moderador;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.repositorios.ModeradorRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.unilocal.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaServicioImpl implements CuentaServicio {

    private final ClienteRepo clienteRepo;
    private final ModeradorRepo moderadorRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO iniciarSesionCliente(InicioSesionDTO loginDTO) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepo.findByEmail(loginDTO.nickname());
        if (clienteOptional.isEmpty()) {
            throw new Exception("El correo no se encuentra registrado");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Cliente cliente = clienteOptional.get();
        if( !passwordEncoder.matches(loginDTO.password(), cliente.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", "CLIENTE");
        map.put("nombre", cliente.getNombre());
        map.put("id", cliente.getCodigo());
        return new TokenDTO( jwtUtils.generarToken(cliente.getEmail(), map) );
    }

    @Override
    public TokenDTO iniciarSesionModerador(InicioSesionDTO loginDTO) throws Exception {
        Optional<Moderador> moderadorOptional = Optional.ofNullable(moderadorRepo.findByEmail(loginDTO.nickname()));
        if (moderadorOptional.isEmpty()) {
            throw new Exception("El correo no se encuentra registrado");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Moderador moderador = moderadorOptional.get();
        if( !passwordEncoder.matches(loginDTO.password(), moderador.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", "MODERADOR");
        map.put("nombre", moderador.getNombre());
        map.put("id", moderador.getCodigo());
        return new TokenDTO( jwtUtils.generarToken(moderador.getEmail(), map) );
    }
}
