package net.ddns.cloudtecnologia.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import net.ddns.cloudtecnologia.client.ViaCepClient;
import net.ddns.cloudtecnologia.model.entity.Endereco;
import net.ddns.cloudtecnologia.model.repository.EnderecoRepository;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTO;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTOResponse;
import net.ddns.cloudtecnologia.service.EnderecoService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    private EnderecoRepository enderecoRepository;

    @Inject
    @RestClient
    private ViaCepClient viaCepClient;

    @Override
    @Transactional
    public Response save(EnderecoDTO dto) {
        EnderecoDTOResponse enderecoDTOResponse = viaCepClient.getEnderecoByCep(dto.getCep());
        if (enderecoDTOResponse.getCep() != null) {
            Endereco endereco = new Endereco(enderecoDTOResponse);
            enderecoRepository.persist(endereco);
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(enderecoDTOResponse)
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND.getStatusCode())
                .entity(enderecoDTOResponse)
                .build();
    }

    @Override
    public Response findAll() {
        List<EnderecoDTOResponse> lista = new ArrayList<>();
        enderecoRepository.findAll().stream().forEach(item -> lista.add(EnderecoDTOResponse.converterParaDto(item)));
        return Response.ok(lista).build();
    }

    @Override
    @Transactional
    public Response deleteById(Long id) {
        Endereco endereco = enderecoRepository.findById(id);
        if (endereco != null) {
            enderecoRepository.delete(endereco);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @Transactional
    public Response updateById(Long id, EnderecoDTO dto) {
        Endereco endereco = enderecoRepository.findById(id);
        if (endereco != null) {
            EnderecoDTOResponse dtoResponse = viaCepClient.getEnderecoByCep(dto.getCep());
            endereco.setCep(dtoResponse.getCep());
            endereco.setLogradouro(dtoResponse.getLogradouro());
            endereco.setComplemento(dtoResponse.getComplemento());
            endereco.setBairro(dtoResponse.getBairro());
            endereco.setLocalidade(dtoResponse.getLocalidade());
            endereco.setUf(dtoResponse.getUf());
            endereco.setIbge(dtoResponse.getIbge());
            endereco.setGia(dtoResponse.getGia());
            endereco.setDdd(dtoResponse.getDdd());
            endereco.setSiafi(dtoResponse.getSiafi());
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(dtoResponse)
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public PanacheQuery<Endereco> findByCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }


}
