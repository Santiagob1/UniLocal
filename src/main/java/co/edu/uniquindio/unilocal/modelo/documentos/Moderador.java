package co.edu.uniquindio.unilocal.modelo.documentos;

import co.edu.uniquindio.unilocal.modelo.entidades.Cuenta;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("moderadores")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Moderador extends Cuenta {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String nombre, String password, String email, EstadoRegistro estadoRegistro) {
        super(nombre, password, email, estadoRegistro);
    }
}
