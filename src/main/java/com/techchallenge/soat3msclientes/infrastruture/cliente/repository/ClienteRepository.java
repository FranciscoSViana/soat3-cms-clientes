package com.techchallenge.soat3msclientes.infrastruture.cliente.repository;

import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    @Query("SELECT c FROM ClienteModel c WHERE c.situacao = true AND c.cpf = :cpf")
    ClienteModel findByCpf(String cpf);



}
