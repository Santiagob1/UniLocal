package co.edu.uniquindio.unilocal.modelo.entidades;

import java.time.LocalTime;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Horario {

    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String dia;

}
