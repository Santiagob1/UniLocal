package co.edu.uniquindio.unilocal.repositorios;

import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.entidades.HistorialRevision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepo extends MongoRepository<HistorialRevision, String> {
}
