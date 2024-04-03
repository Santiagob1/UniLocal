package co.edu.uniquindio.unilocal.controladores;

import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
@AllArgsConstructor
public class ClienteController {

    private final CLienteServicio cLienteServicio;
}
