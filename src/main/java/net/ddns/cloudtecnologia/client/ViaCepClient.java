package net.ddns.cloudtecnologia.client;


import net.ddns.cloudtecnologia.rest.dto.EnderecoDTOResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient
@ApplicationScoped
public interface ViaCepClient {
    @GET
    @Path("/{cep}/json")
    EnderecoDTOResponse getEnderecoByCep(@PathParam("cep") String cep);
}
