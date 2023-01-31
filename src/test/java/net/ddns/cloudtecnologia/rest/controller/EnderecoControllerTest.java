package net.ddns.cloudtecnologia.rest.controller;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(EnderecoController.class)
class EnderecoControllerTest {


    @Test
    @Order(1)
    void deveSalvarTrue() {
        given()
                .contentType(ContentType.JSON)
                .body(new EnderecoDTO("74913330"))
                .when()
                .post()
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    @Order(2)
    void deveSalvarFalse() {
        var dto = new EnderecoDTO("77777777");
        var response = given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post()
                .then()
                .extract().response();
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusCode());
        assertNull(response.jsonPath().getString("cep"));
    }

    @Test
    @Order(3)
    void deveListarTrue() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    @Order(4)
    void updateByIdTrue() {
        given()
                .contentType(ContentType.JSON)
                .body(new EnderecoDTO("74914220"))
                .when()
                .put("/1")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    @Order(5)
    void updateByIdFalse() {
        given()
                .contentType(ContentType.JSON)
                .body(new EnderecoDTO("74914220"))
                .when()
                .put("/15")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }


    @Test
    @Order(6)
    void deleteByIdTrue() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/1")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

    @Test
    @Order(7)
    void deleteByIdFalse() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/1")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }
}