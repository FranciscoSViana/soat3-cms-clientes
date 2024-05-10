package com.techchallenge.soat3msclientes.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClienteModel {

    @Id
    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    @CreationTimestamp
    @JoinColumn(columnDefinition = "datetime")
    private LocalDateTime dataHoraCriacao;

    @UpdateTimestamp
    @JoinColumn(columnDefinition = "datetime")
    private LocalDateTime dataHoraAlteracao;

    private boolean situacao;
}
