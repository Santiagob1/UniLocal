package co.edu.uniquindio.unilocal.modelo.documentos;

import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.entidades.Horario;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Negocio {

    @Id
    private String codigo;
    private String codigoCliente;
    private Ubicacion ubicacion;
    private String nombre;
    private String descripcion;
    private List<Horario> horario;
    private EstadoRegistro estado;
    private List<String> imagenes;
    private List<HistorialRevision> historialRevisiones;
    private TipoNegocio tipoNegocio;
    private List<String> telefonos;

}
