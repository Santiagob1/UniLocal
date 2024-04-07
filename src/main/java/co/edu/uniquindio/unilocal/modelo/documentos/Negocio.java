package co.edu.uniquindio.unilocal.modelo.documentos;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.entidades.Horario;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


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
    private EstadoNegocio estado;
    private EstadoRegistro estadoRegistro;
    // Pendiente de preguntar al profesor
    private Map<String, String> imagenes;
    private List<HistorialRevision> historialRevisiones;
    private List<Menu> lstMenuNegocio;
    private TipoNegocio tipoNegocio;
    private List<String> telefonos;
    private LocalDate fechaRechazo;

    @Builder
    public Negocio(String codigoCliente, Ubicacion ubicacion, String nombre, String descripcion, List<Horario> horario, EstadoNegocio estado, Map<String, String> imagenes, List<HistorialRevision> historialRevisiones, TipoNegocio tipoNegocio, List<String> telefonos, List<Menu> lstMenu, EstadoRegistro estadoRegistro, LocalDate fechaRechazo) {
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
        this.lstMenuNegocio = lstMenu;
        this.estadoRegistro = estadoRegistro;
        this.fechaRechazo = fechaRechazo;
    }
}
