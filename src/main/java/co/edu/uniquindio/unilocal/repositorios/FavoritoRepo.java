package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.documentos.Favorito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRepo extends MongoRepository<Favorito, String>  {

    Optional<Favorito> findByCodigoClienteAndCodigoNegocio(String codigoCliente, String codigoNegocio);
    List<Favorito> findByCodigoCliente(String codigoCliente);
}
