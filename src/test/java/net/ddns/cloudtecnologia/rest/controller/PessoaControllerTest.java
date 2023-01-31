package net.ddns.cloudtecnologia.rest.controller;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTO;
import net.ddns.cloudtecnologia.rest.dto.PessoaDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.Response;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(PessoaController.class)
class PessoaControllerTest {

    @Test
    @Order(1)
    void deveSalvarPessoaTrue() {
        var enderecoDto1 = new EnderecoDTO("74914220");
        //
        var responseEndereco1 = given()
                .contentType(ContentType.JSON)
                .body(enderecoDto1)
                .when()
                .post("http://localhost:8589/api/enderecos")
                .then()
                .extract().response();
        assertEquals(Response.Status.CREATED.getStatusCode(), responseEndereco1.getStatusCode());
        assertNotNull(responseEndereco1.jsonPath().getString("cep"));
        //
        var enderecoDto2 = new EnderecoDTO("74914200");
        var responseEndereco2 = given()
                .contentType(ContentType.JSON)
                .body(enderecoDto2)
                .when()
                .post("http://localhost:8589/api/enderecos")
                .then()
                .extract().response();
        //
        assertEquals(Response.Status.CREATED.getStatusCode(), responseEndereco2.getStatusCode());
        assertNotNull(responseEndereco2.jsonPath().getString("cep"));
        //-----
        var pessoaDto = new PessoaDTO("Silas gomes", LocalDate.now(),
                "73238747002", "silas@mail.com", 2L);
        var responsePessoa = given()
                .contentType(ContentType.JSON)
                .body(pessoaDto)
                .when()
                .post()
                .then()
                .extract().response();
        //
        assertEquals(Response.Status.CREATED.getStatusCode(), responsePessoa.getStatusCode());
        assertNotNull(responsePessoa.jsonPath().getString("cpf"));
    }

    @Test
    @Order(2)
    void deveSalvarPessoaFalse() {
        var pessoaDto = new PessoaDTO("Silas gomes", LocalDate.now(),
                "56588805579", "silasss@mail.com", 10L);
        given()
                .contentType(ContentType.JSON)
                .body(pessoaDto)
                .when()
                .post()
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @Order(3)
    void listarTodosTrue() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    @Order(3)
    void findByIdTrue() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/1")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    @Order(4)
    void findByIdFalse() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/9")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

//    @Test
//    @Order(5)
//    void findEnderecoByIdPessoaTrue() {
//        var response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/1/endereco")
//                .then()
//                .statusCode(Response.Status.OK.getStatusCode());
//    }

//    @Test
//    @Order(5)
//    void findEnderecoByIdPessoaFalse() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/90/endereco")
//                .then()
//                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
//    }

    @Test
    @Order(6)
    void atualizarPessoaTrue() {
        var pessoaDto = new PessoaDTO("Silas gomes Atualizado", LocalDate.now(),
                "73238747002", "silas@mail.com", 2L);
        given()
                .contentType(ContentType.JSON)
                .body(pessoaDto)
                .put("/1")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    @Order(7)
    void atualizarPessoaFalse() {
        var pessoaDto = new PessoaDTO("Silas gomes Atualizado", LocalDate.now(),
                "73238747002", "silas@mail.com", 2L);
        given()
                .contentType(ContentType.JSON)
                .body(pessoaDto)
                .put("/19")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }


    @Test
    @Order(8)
    void deleteByIdTrue() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/1")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

    @Test
    @Order(9)
    void deleteByIdFalse() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/19")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

}