package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.dto.DetalleNegocioDTO;
import co.edu.uniquindio.unilocal.dto.FavoritoDTO;
import co.edu.uniquindio.unilocal.dto.FavoritoDetalleDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Favorito;
import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.repositorios.FavoritoRepo;
import co.edu.uniquindio.unilocal.servicios.interfaces.CLienteServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioFavoritoServicio;
import co.edu.uniquindio.unilocal.servicios.interfaces.NegocioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NegocioFavoritoServicioImpl implements NegocioFavoritoServicio {
    private final CLienteServicio cLienteServicio;
    private final NegocioServicio negocioServicio;
    private final FavoritoRepo negocioFavoritoRepo;


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
            Favorito favorito = new Favorito();
            favorito.setCodigoCliente(favoritoDTO.codigoCliente());
            favorito.setCodigoNegocio(favoritoDTO.codigoNegocio());

            negocioFavoritoRepo.save(favorito);

            return true;
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
            Favorito favorito = negocioFavoritoRepo.findByCodigoClienteAndCodigoNegocio(favoritoDTO.codigoCliente(), favoritoDTO.codigoNegocio()).get();
            negocioFavoritoRepo.delete(favorito);
        }

        return false;
    }

    /**
     * Permite obtener los favoritos de un cliente en especifico
     * @param idCliente
     * @return
     * @throws Exception
     */
    @Override
    public FavoritoDetalleDTO otenerFavoritoCliente(String idCliente) throws Exception {
        FavoritoDetalleDTO favoritoDetalleDTO = null;
        List<DetalleNegocioDTO> lstDetallesDTO = new ArrayList<>();
        Cliente cliente  = cLienteServicio.obtenerClienteDirecto(idCliente);
        if (cliente != null) {
            List<Favorito> lstFavoritos = negocioFavoritoRepo.findByCodigoCliente(idCliente);

            for (Favorito favorito : lstFavoritos) {
                Negocio negocio = negocioServicio.obtenerNegocioDirecto(favorito.getCodigoNegocio());
                DetalleNegocioDTO detalleNegocioDTO = new DetalleNegocioDTO(
                        negocio.getCodigo(),
                        negocio.getNombre(),
                        negocio.getDescripcion(),
                        idCliente,
                        negocio.getEstado(),
                        negocio.getUbicacion(),
                        negocio.getLstMenuNegocio(),
                        0
                );

                lstDetallesDTO.add(detalleNegocioDTO);
            }

            favoritoDetalleDTO = new FavoritoDetalleDTO(
                    idCliente,
                    lstDetallesDTO
            );
        } else {
            throw new Exception("No existe cliente con ID " + idCliente);
        }

        return favoritoDetalleDTO;
    }
}
