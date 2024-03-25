package co.edu.uniquindio.unilocal.modelo.documentos;

import co.edu.uniquindio.unilocal.modelo.entidades.Cuenta;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import lombok.*;

@Document("clientes")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Cliente extends Cuenta {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String nickName;
    private String ciudad;
    private String fotoPerfil;

    @Builder
    public Cliente(String nombre, String password, String email, EstadoRegistro estadoRegistro, String nickName, String ciudad, String fotoPerfil) {
        super(nombre, password, email, estadoRegistro);
        this.nickName = nickName;
        this.ciudad = ciudad;
        this.fotoPerfil = fotoPerfil;
    }
}
