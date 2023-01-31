package net.ddns.cloudtecnologia.rest.controller;

import net.ddns.cloudtecnologia.rest.dto.PessoaDTO;
import net.ddns.cloudtecnologia.service.impl.PessoaServiceImpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaController {

    @Inject
    private PessoaServiceImpl service;

    @POST
    public Response save(@Valid PessoaDTO dto) {
        return service.save(dto);
    }

    @GET
    public Response findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{idPessoa}")
    public Response findById(@PathParam("idPessoa") Long idPessoa) {
        return service.findById(idPessoa);
    }

    @GET
    @Path("/{idPessoa}/endereco")
    public Response findEnderecoByIdPessoa(@PathParam("idPessoa") Long idPessoa) {
        return service.findEnderecoByIdPessoa(idPessoa);
    }

    @PUT
    @Path("/{idPessoa}")
    public Response updateById(@PathParam("idPessoa") Long idPessoa, PessoaDTO dto) {
        return service.updateById(idPessoa, dto);
    }

    @DELETE
    @Path("/{idPessoa}")
    public Response deleteById(@PathParam("idPessoa") Long idPessoa) {
        return service.deleteById(idPessoa);
    }

}
