package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {

    Optional<Cliente> findByNickName(String nickName);
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByCodigo(String codigo);

}
