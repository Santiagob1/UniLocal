package co.edu.uniquindio.unilocal.modelo.entidades;

import java.time.LocalTime;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Horario {

    private String horaInicio;
    private String horaFin;
    private String dia;

}
