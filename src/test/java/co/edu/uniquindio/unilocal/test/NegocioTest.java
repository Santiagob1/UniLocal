package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.*;
import co.edu.uniquindio.unilocal.modelo.documentos.Menu;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.modelo.entidades.Horario;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NegocioTest {
    @Autowired
    private NegocioServicio negocioServicio;

    @Test
    public void crearNegocio() {
        try {

            List<Horario> lstHorario = new ArrayList<>();
            lstHorario.add(new Horario(
                "08:00",
                    "08:00",
                    "Lunes"
            ));

            List<String> lstImages = new ArrayList<>();
            lstImages.add("www.google.com");

            RegistroNegocioDTO registroNegocioDTO = new RegistroNegocioDTO(
                    "1",
                    new Ubicacion(
                            0,
                            0
                    ),
                    "Test de negocio",
                    "Test de prueba",
                    lstHorario,
                    lstImages,
                    TipoNegocio.BAR,
                    new ArrayList<>());
            String codigoNegocio = negocioServicio.crearNegocio(registroNegocioDTO);

            Assertions.assertNotEquals("", codigoNegocio);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void actualizarNegocio() {
        try {
            List<Horario> lstHorario = new ArrayList<>();
            lstHorario.add(new Horario(
                    "08:00",
                    "08:00",
                    "Lunes"
            ));

            List<String> lstImages = new ArrayList<>();
            lstImages.add("www.google.com");

            List<Menu> lstMenu = new ArrayList<>();

            ActualizacionNegocioDTO actualizacionNegocioDTO = new ActualizacionNegocioDTO(
                    "3",
                    new Ubicacion(
                            0,
                            0
                    ),
                    "Test",
                    "Tes de actualización",
                    lstHorario,
                    lstImages,
                    TipoNegocio.CAFETERIA,
                    new ArrayList<>(),
                    lstMenu
                    );

            boolean respuesta = negocioServicio.actualizarNegocio(actualizacionNegocioDTO);

            Assertions.assertTrue(respuesta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void eliminarNegocio() {
        try {
            boolean respuesta = negocioServicio.eliminarNegocio("3");

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void obtenerNegocio() {
        try {
            DetalleNegocioDTO detalleNegocioDTO = negocioServicio.obtenerNegocio("1");
            Assertions.assertTrue(detalleNegocioDTO != null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void buscarNegocioNombre() {
        try {
            List<DetalleNegocioDTO> lstNegocios = negocioServicio.buscarNegocioNombre("Invalidos");

            Assertions.assertTrue(lstNegocios.size() == 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void buscarNegocioTipo() {
        try {
            List<DetalleNegocioDTO> lstNegocios = negocioServicio.buscarNegocioTipo(TipoNegocio.BAR);

            Assertions.assertTrue(lstNegocios.size() == 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void filtrarPorEstado() {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void listarNegocioPropietario() {
        try {
            List<DetalleNegocioDTO> lstNegocios = negocioServicio.listarNegocioPropietario("1");

            Assertions.assertTrue(lstNegocios.size() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void listarNegocioModerador() {
        try {
            List<DetalleNegocioDTO> lstNegocios = negocioServicio.listarNegocioModerador();

            Assertions.assertTrue(lstNegocios.size() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void cambiarEstado() {
        try {
            CambiarEstadoDTO cambiarEstadoDTO = new CambiarEstadoDTO(
                    "1",
                    EstadoNegocio.APROBADO
            );

            boolean respuesta = negocioServicio.cambiarEstado(cambiarEstadoDTO);

            Assertions.assertEquals(true, respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void obtenerNegocioDirecto() {
        try {
            Negocio negocio = negocioServicio.obtenerNegocioDirecto("1");

            Assertions.assertTrue(negocio != null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
