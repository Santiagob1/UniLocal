package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.unilocal.dto.RecuperarPasswordDTO;
import co.edu.uniquindio.unilocal.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClienteTest {
    @Autowired
    private CLienteServicio cLienteServicio;
    private EstadoRegistro  estadoRegistro = EstadoRegistro.ACTIVO;

    @Test
    public void registrarse(){
        try {
            RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO(
                    "ntgjs",
                    "Armenia",
                    "www.google.com",
                    "Natalia Gallo",
                    "1234",
                    "jennyn.gallos@uqvirtual.edu.co"
            );

            String codigo = cLienteServicio.registrarse(registroUsuarioDTO);

            Assertions.assertTrue(!codigo.equals(""));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void editarPerfil(){
        try {
            ActualizacionUsuarioDTO actualizacionUsuarioDTO = new ActualizacionUsuarioDTO(
                    "1111",
                    "Natalia",
                    "www.google.com",
                    "ntjsg",
                    "jennyn.gallos@uqvirtual.edu.co",
                    "Armenia"
            );

            boolean respuesta = cLienteServicio.editarPerfil(actualizacionUsuarioDTO);

            Assertions.assertTrue(respuesta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void eliminarCuenta(){
        try {
            boolean respuesta = cLienteServicio.eliminarCuenta("0");

            Assertions.assertNotEquals(true, respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void obtenerCliente() {
        try  {
            Cliente cliente = cLienteServicio.obtenerCliente("1111");

            Assertions.assertNotNull(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void cambiarContrasena() {
        try  {
            RecuperarPasswordDTO recuperarPasswordDTO = new RecuperarPasswordDTO(
                    "",
                    "1234",
                    "jennyn.gallos@uqvirtual.edu.co"
            );

            boolean respuesta = cLienteServicio.cambiarContrasena(recuperarPasswordDTO);

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
