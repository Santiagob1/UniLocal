package co.edu.uniquindio.unilocal.dto;

import java.util.List;

public record FavoritoDetalleDTO(
        String idCliente,
        List<DetalleNegocioDTO> lstNegociosFavoritos
) {
}
