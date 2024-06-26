package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.*;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final NegocioServicio negocioServicio;
    private final EmailServicio emailServicio;
    private final CLienteServicio cLienteServicio;
    private final HistorialServicio historialServicio;

    /**
     * Permite autorizar o rechazar un negocio creado
     * con estado pendiente
     *
     * @param autorizarRechazarNegocioDTO
     * @return
     * @throws Exception
     */
    @Override
    public boolean autorizarRechazarNegocio(AutorizarRechazarNegocioDTO autorizarRechazarNegocioDTO) throws Exception {
        boolean respuesta = false;
        DetalleNegocioDTO negocio = null;
        Cliente cliente = new Cliente();
        Negocio negocioBD = new Negocio();
        if (negocioServicio.cambiarEstado(new CambiarEstadoDTO(autorizarRechazarNegocioDTO.idNegocio(), autorizarRechazarNegocioDTO.estado()))) {
            negocio = negocioServicio.obtenerNegocio(autorizarRechazarNegocioDTO.idNegocio());
            negocioBD = negocioServicio.obtenerNegocioDirecto(autorizarRechazarNegocioDTO.idNegocio());

            if (autorizarRechazarNegocioDTO.estado().equals(EstadoNegocio.RECHAZADO)) {
                negocioBD.setFechaRechazo(LocalDate.now().toString());
                negocioServicio.actualizarNegocioRechazo(negocioBD);
            }

            cliente = cLienteServicio.obtenerClienteDirecto(negocio.codigoCliente());
            String cuerpo = "";

            if (autorizarRechazarNegocioDTO.estado().equals(EstadoNegocio.RECHAZADO)) {
                cuerpo = "Su negocio fue RECHAZADO\n";
                cuerpo += "Motivo: " + autorizarRechazarNegocioDTO.motivo();
                cuerpo += "Desde este momento tiene 5 días para realizar la modificación y enviarlo\n";
                cuerpo += "nuevamente a revisión";
            } else {
                cuerpo = "El negocio " + negocio.nombre() + " fue " + autorizarRechazarNegocioDTO.estado();
            }

            // Verificar si la dirección de correo electrónico del cliente no es nula ni está vacía
            if (cliente != null && cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
                emailServicio.enviarEmail(new EmailDTO(
                        "Estado de negocio",
                        cuerpo,
                        cliente.getEmail()
                ));
            } else {
                throw new Exception("La dirección de correo electrónico del cliente es nula o vacía.");
            }

            HistorialRevision historialRevision = new HistorialRevision(
                    "",
                    autorizarRechazarNegocioDTO.idModerador(),
                    autorizarRechazarNegocioDTO.motivo(),
                    autorizarRechazarNegocioDTO.estado(),
                    LocalDateTime.now().toString()
            );

            negocioBD.getHistorialRevisiones().add(historialRevision);

            negocioServicio.actualizarNegocioDirecto(negocioBD);

            respuesta = true;
        }

        return respuesta;
    }

}