package co.edu.uniquindio.unilocal.servicios.interfaces;

import co.edu.uniquindio.unilocal.dto.FavoritoDTO;

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
}
