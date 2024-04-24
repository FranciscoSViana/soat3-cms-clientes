package com.techchallenge.soat3msclientes.infrastruture.cliente;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import com.techchallenge.soat3msclientes.infrastruture.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ClienteRepositoryIT {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFindByCpf() {

        UUID uuid = UUID.fromString("0a2f5e67-8b3d-4c6a-a1b2-987654321000");

        ClienteModel cliente = ClienteModel.builder()
                .id(uuid)
                .nome("Maria Santos")
                .cpf("3335554401")
                .email("maria@example.com")
                .telefone("(88) 8888-8888")
                .dataHoraCriacao(LocalDateTime.of(2024, 4, 15, 10, 0, 0))
                .situacao(true)
                .build();

        clienteRepository.save(cliente);

        ClienteModel foundCliente = clienteRepository.findByCpf("3335554401");

        assertNotNull(foundCliente);
        assertEquals("Maria Santos", foundCliente.getNome());
    }
    @Test
    public void testFindByCpfFile() {
        ClienteModel cliente = clienteRepository.findByCpf("12312312387");

        assertEquals("João Silva", cliente.getNome());
    }

    @Test
    public void testFindById() {
        String uuidJoaoSilva = "5a39b3b5-4675-4c67-8dcb-3e59e38e36c1";

        Optional<ClienteModel> clienteOptional = clienteRepository.findById(UUID.fromString(uuidJoaoSilva));
        assertTrue(clienteOptional.isPresent());

        ClienteModel cliente = clienteOptional.get();
        assertEquals("12312312387", cliente.getCpf());
        assertEquals("joao@example.com", cliente.getEmail());
    }
}