package co.edu.uniquindio.unilocal.modelo.entidades;

import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Cuenta {

    private String nombre;
    private String password;
    private String email;
    private EstadoRegistro estadoRegistro;

    public Cuenta(String nombre, String password, String email, EstadoRegistro estadoRegistro) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.estadoRegistro = estadoRegistro;
    }
}
