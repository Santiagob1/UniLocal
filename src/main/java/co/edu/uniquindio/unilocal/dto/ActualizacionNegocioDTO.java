package co.edu.uniquindio.unilocal.dto;

import co.edu.uniquindio.unilocal.modelo.documentos.Menu;
import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.entidades.Horario;
import co.edu.uniquindio.unilocal.modelo.entidades.Ubicacion;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;

public record ActualizacionNegocioDTO(
        @NotBlank String codigo,
        @NotBlank Ubicacion ubicacion,
        @NotBlank @Length(max = 100) String nombre,
        @NotBlank String descripcion,
        @NotBlank List<Horario> horario,
        @NotBlank List<ImagenDTO> imagenes,
        @NotBlank TipoNegocio tipoNegocio,
        @NotBlank List<String> telefonos,
        List<Menu> lstMenu) {

}
