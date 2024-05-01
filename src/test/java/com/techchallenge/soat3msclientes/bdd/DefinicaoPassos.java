package com.techchallenge.soat3msclientes.bdd;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;




public class DefinicaoPassos {

    private Response response;

    private ClienteResponse clienteResponse;

    private String ENDPOINT_CLIENTES = "http://localhost:8080/v1/clientes";

    @Dado("que um cliente esteja cadastrado com o CPF {string}")
    public void clienteCadastradoComCPF(String cpf) {
        // Aqui você pode implementar a lógica para cadastrar um cliente com o CPF informado
    }

    @Quando("requisitar a busca do cliente pelo CPF {string}")
    public void requisitarBuscaClientePorCPF(String cpf) {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get(ENDPOINT_CLIENTES + "/{cpf}", cpf);
    }


    @Então("o cliente é encontrado com sucesso")
    public void clienteEncontradoComSucesso() {
        response.then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("./schemas/ClienteResponseSchema.json"));
    }

    @Então("o cliente não é encontrado")
    public void clienteNaoEncontrado() {
        response.then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

}
