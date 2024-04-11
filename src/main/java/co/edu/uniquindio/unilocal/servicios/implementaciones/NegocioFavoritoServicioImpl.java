package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.FavoritoDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioFavoritoServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NegocioFavoritoServicioImpl implements NegocioFavoritoServicio {
    private final CLienteServicio cLienteServicio;
    private final NegocioServicio negocioServicio;


    /**
     * Permite agregar un negocio a la lista de favoritos del cliente
     * @param favoritoDTO
     * @return true o false
     * @throws Exception
     */
    @Override
    public boolean crearFavoritosUsuario(FavoritoDTO favoritoDTO) throws Exception {
        Cliente cliente = cLienteServicio.obtenerClienteDirecto(favoritoDTO.codigoCliente());
        Negocio negocio = negocioServicio.obtenerNegocioDirecto(favoritoDTO.codigoNegocio());
        if (cliente != null && negocio != null) {
            if (!cliente.getLstNegociosFavoritos().contains(negocio)) {
                cliente.getLstNegociosFavoritos().add(negocio);
                return cLienteServicio.crearNegocioFavoritoCliente(cliente);
            }
        }

        return false;
    }

    /**
     * Permite eliminar un negocio de la lista de favoritos
     * de un cliente especifico
     * @param favoritoDTO
     * @return true o false
     * @throws Exception
     */
    @Override
    public boolean eliminarFavoritoUsuarios(FavoritoDTO favoritoDTO) throws Exception {
        Cliente cliente = cLienteServicio.obtenerClienteDirecto(favoritoDTO.codigoCliente());
        Negocio negocio = negocioServicio.obtenerNegocioDirecto(favoritoDTO.codigoNegocio());

        if (cliente != null && negocio != null) {
            if (cliente.getLstNegociosFavoritos().contains(negocio)) {
                cliente.getLstNegociosFavoritos().remove(negocio);
                return cLienteServicio.crearNegocioFavoritoCliente(cliente);
            }
        }

        return false;
    }
}
