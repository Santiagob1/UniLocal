package co.edu.uniquindio.unilocal.modelo.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import lombok.*;

@Document("transacciones")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cliente {
    @Id
    private String codigo;
    private String nickName;
    private String Ciudad;
    private String fotoPerfil;

}
