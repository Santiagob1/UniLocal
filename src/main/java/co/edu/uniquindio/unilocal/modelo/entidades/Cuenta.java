package co.edu.uniquindio.unilocal.modelo.entidades;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import org.springframework.data.annotation.Id;

public class Cuenta {

    private String nombre;
    private String password;
    private String email;
    private EstadoRegistro estadoRegistro;

}
