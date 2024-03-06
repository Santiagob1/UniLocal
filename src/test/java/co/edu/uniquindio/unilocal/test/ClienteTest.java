package co.edu.uniquindio.unilocal.test;

import co.edu.uniquindio.unilocal.modelo.documentos.Cliente;
import co.edu.uniquindio.unilocal.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.unilocal.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;
    private EstadoRegistro  estadoRegistro = EstadoRegistro.ACTIVO;

    @Test
    public void registrarClienteTest(){
        //Creamos el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .email("MariaPP@gmail.com")
                .nombre("Maria Perez Pena")
                .password("mariapp")
                .estadoRegistro(estadoRegistro)
                .ciudad("Armenia")
                .fotoPerfil("https://fotoDePerfil")
                .nickName("MariaPerezP").build();
        //Guardamos el cliente
        Cliente registro = clienteRepo.save( cliente );
        //Verificamos que se haya guardado validando que no sea null
        Assertions.assertNotNull(registro);
    }
    @Test
    public void actualizarClienteTest(){
        //Obtenemos el cliente con el id 65e8cbf70363f17d65668d0b
        Cliente cliente = clienteRepo.findById("65e8cbf70363f17d65668d0b").orElseThrow();
        //Modificar el email del cliente
        cliente.setEmail("nuevoemail@email.com");
        //Guardamos el cliente
        clienteRepo.save( cliente );
        //Obtenemos el cliente con el id XXXXXXX nuevamente
        Cliente clienteActualizado = clienteRepo.findById("65e8cbf70363f17d65668d0b").orElseThrow();;
        //Verificamos que el email se haya actualizado
        Assertions.assertEquals("nuevoemail@email.com", clienteActualizado.getEmail());
    }

    @Test
    public void listarClienteTest(){
        //Obtenemos la lista de todos los clientes (por ahora solo tenemos 1)
        List<Cliente> clientes = clienteRepo.findAll();
        //Imprimimos los clientes, se hace uso de una función lambda
        clientes.forEach(System.out::println);
        //Verificamos que solo exista un cliente
        Assertions.assertEquals(clienteRepo.findAll().size(), clientes.size());
    }

    @Test
    public void eliminarClienteTest(){
        //Borramos el cliente con el id XXXXXXX
        clienteRepo.deleteById("XXXXXXX");
        //Obtenemos el cliente con el id XXXXXXX
        Cliente cliente = clienteRepo.findById("XXXXXXX").orElse(null);
        //Verificamos que el cliente no exista
        Assertions.assertNull(cliente);
    }
}
