package co.edu.uniquindio.unilocal.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("comentarios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String fecha;
    private int calificacion;
    private String codigoCLiente;
    private String codigoNegocio;
    private String mensaje;

    private String idComentarioPadre;

    @Builder
    public Comentario(String fecha, int calificacion, String codigoCLiente, String codigoNegocio, String mensaje, String idComentarioPadre) {
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.codigoCLiente = codigoCLiente;
        this.codigoNegocio = codigoNegocio;
        this.mensaje = mensaje;
        this.idComentarioPadre = idComentarioPadre;
    }
}
