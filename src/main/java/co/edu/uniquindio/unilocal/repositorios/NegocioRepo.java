package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.modelo.documentos.Negocio;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.unilocal.modelo.enums.TipoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    List<Negocio> findByNombre(String nombre);
    List<Negocio> findByTipoNegocio(TipoNegocio tipoNegocio);
    List<Negocio> findByEstado(EstadoNegocio estadoNegocio);
    List<Negocio> findByCodigoCliente(String idPropiertario);
}
