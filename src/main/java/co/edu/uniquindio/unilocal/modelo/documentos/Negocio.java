package co.edu.uniquindio.unilocal.modelo.documentos;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.entidades.Horario;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("negocios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Negocio {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String codigoCliente;
    private Ubicacion ubicacion;
    private String nombre;
    private String descripcion;
    private List<Horario> horario;
    private EstadoRegistro estado;
    private List<String> imagenes;
    private String menu;
    private List<HistorialRevision> historialRevisiones;
    private TipoNegocio tipoNegocio;
    private List<String> telefonos;

    @Builder
    public Negocio(String codigoCliente, Ubicacion ubicacion, String nombre, String descripcion, List<Horario> horario, EstadoRegistro estado, List<String> imagenes, List<HistorialRevision> historialRevisiones, TipoNegocio tipoNegocio, List<String> telefonos) {
        this.codigoCliente = codigoCliente;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.estado = estado;
        this.imagenes = imagenes;
        this.historialRevisiones = historialRevisiones;
        this.tipoNegocio = tipoNegocio;
        this.telefonos = telefonos;
    }
}
