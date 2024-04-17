package co.edu.uniquindio.unilocal.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("favoritos")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Favorito {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String codigoCliente;
    private String codigoNegocio;
}
