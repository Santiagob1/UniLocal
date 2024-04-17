package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.FavoritoDTO;
import co.edu.uniquindio.unilocal.dto.FavoritoDetalleDTO;
import co.edu.uniquindio.unilocal.modelo.documentos.Favorito;

import java.util.List;

public interface NegocioFavoritoServicio {

    /**
     * Permite asociar negocios favoritos a un cliente especificos
     * @param favoritoDTO
     * @return
     * @throws Exception
     */
    boolean crearFavoritosUsuario(FavoritoDTO favoritoDTO) throws Exception;

    /**
     * Permite eliminar un negocio favorito de un cliente en especifico
     * @param favoritoDTO
     * @return
     * @throws Exception
     */
    boolean eliminarFavoritoUsuarios(FavoritoDTO favoritoDTO) throws Exception;

    /**
     * Permite obtener los negocios favoritos de un cliente
     * especifico
     * @param idCliente
     * @return
     */
    FavoritoDetalleDTO otenerFavoritoCliente(String idCliente) throws Exception;

}
