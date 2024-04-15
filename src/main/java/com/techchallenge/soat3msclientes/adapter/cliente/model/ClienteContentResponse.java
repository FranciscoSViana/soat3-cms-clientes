package com.techchallenge.soat3msclientes.adapter.cliente.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class ClienteContentResponse {

    private List<ClienteResponse> content;

}
