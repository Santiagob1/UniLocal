package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.HistorialServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class HistorialTest {
    @Autowired
    private HistorialServicio historialServicio;

    @Test
    public void guardarHistorial() {
        try {
            HistorialRevision historialRevision = new HistorialRevision(
                    "",
                    "1",
                    "Test de historial de revisión",
                    EstadoNegocio.RECHAZADO,
<<<<<<< HEAD
                    "2024-04-18"
=======
                    LocalDateTime.now().toString()
>>>>>>> e3c9dc2f6788af5650fe98b7133f87f529e16c81
            );

            String codigo = historialServicio.guardarHistorial(historialRevision);

            Assertions.assertTrue(codigo.equals(""));

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
