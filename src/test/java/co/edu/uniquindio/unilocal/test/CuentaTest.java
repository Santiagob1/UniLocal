package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.InicioSesionDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.CuentaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CuentaTest {
    @Autowired
    private CuentaServicio cuentaServicio;

    @Test
    public void inicarSesion() {
        try {
            InicioSesionDTO inicioSesionDTO = new InicioSesionDTO(
                    "natisnjgs",
                    "1234"
            );

            boolean respuesta = cuentaServicio.iniciarSesion(inicioSesionDTO);

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
