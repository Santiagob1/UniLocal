package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.dto.CrearComentarioDTO;
import co.edu.uniquindio.unilocal.dto.ListarComentariosNegocioDTO;
import co.edu.uniquindio.unilocal.servicios.interfaces.ComentarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ComentarioTest {
    @Autowired
    private ComentarioServicio comentarioServicio;

    @Test
    public void crearComentario() {
        try {
            CrearComentarioDTO crearComentarioDTO = new CrearComentarioDTO(
                    "2024-04-18",
                    1,
                    "1",
                    "1",
                    "Test de comentario",
                    "0"
            );

            String idComentario = comentarioServicio.crearComentario(crearComentarioDTO);

            Assertions.assertNotEquals("", idComentario);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarcomentariosNegocio() {
        try {
            List<ListarComentariosNegocioDTO> lstComentarios = comentarioServicio.listarComentariosNegocio("0");
            Assertions.assertEquals(0, lstComentarios.size());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void responderComentario() {
        try {
            CrearComentarioDTO crearComentarioDTO = new CrearComentarioDTO(
                    "2024-04-18",
                    1,
                    "1",
                    "1",
                    "Test de responder comentario",
                    "1"
            );

            String idComentario = comentarioServicio.crearComentario(crearComentarioDTO);

            Assertions.assertNotEquals("", idComentario);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
