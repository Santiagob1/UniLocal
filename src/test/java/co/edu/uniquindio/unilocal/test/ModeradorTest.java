package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.AutorizarRechazarNegocioDTO;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.ModeradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ModeradorTest {

    @Autowired
    private ModeradorServicio moderadorServicio;

    @Test
    public void autorizarRechazarNegocio() {
        try {
            AutorizarRechazarNegocioDTO autorizarRechazarNegocioDTO = new AutorizarRechazarNegocioDTO(
                    "1111",
                    "1010",
                    EstadoNegocio.APROVADO,
                    "Test de autorización"
            );

            boolean respuesta = moderadorServicio.autorizarRechazarNegocio(autorizarRechazarNegocioDTO);

            Assertions.assertTrue(respuesta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
