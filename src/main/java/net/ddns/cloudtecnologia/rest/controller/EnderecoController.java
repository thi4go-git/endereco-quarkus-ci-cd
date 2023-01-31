package net.ddns.cloudtecnologia.rest.controller;

import net.ddns.cloudtecnologia.rest.dto.EnderecoDTO;
import net.ddns.cloudtecnologia.service.impl.EnderecoServiceImpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/enderecos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoController {

    @Inject
    private EnderecoServiceImpl service;


    @POST
    public Response save(@Valid EnderecoDTO dto) {
        return service.save(dto);
    }

    @GET
    public Response findAll() {
        return service.findAll();
    }

    @PUT
    @Path("/{idEndereco}")
    public Response updateById(@PathParam("idEndereco") Long idEndereco, EnderecoDTO dto) {
        return service.updateById(idEndereco, dto);
    }

    @DELETE
    @Path("/{idEndereco}")
    public Response deleteById(@PathParam("idEndereco") Long idEndereco) {
        return service.deleteById(idEndereco);
    }
}
