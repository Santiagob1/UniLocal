package co.edu.uniquindio.unilocal.modelo.entidades;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Comentario {

    @Id
    private String codigo;
    private LocalDateTime fecha;
    private int calificacion;
    private String codigoCLiente;
    private String codigoNegocio;
    private String mensaje;
    private String respuesta;
}
