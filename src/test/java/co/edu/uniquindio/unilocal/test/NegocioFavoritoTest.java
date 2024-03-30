package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.FavoritoDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioFavoritoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class NegocioFavoritoTest {
    @Autowired
    private NegocioFavoritoServicio negocioFavoritoServicio;

    @Test
    public void crearFavoritoUsuario() {
        try {
            FavoritoDTO favoritoDTO = new FavoritoDTO(
                    "0",
                    "0"
            );

            boolean respuesta = negocioFavoritoServicio.crearFavoritosUsuario(favoritoDTO);

            Assertions.assertEquals(false, respuesta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void eliminarFavoritoUsuarios() {
        try {
            FavoritoDTO favoritoDTO = new FavoritoDTO(
                    "1111",
                    "1111"
            );

            boolean respuesta = negocioFavoritoServicio.eliminarFavoritoUsuarios(favoritoDTO);

            Assertions.assertTrue(respuesta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
