package net.ddns.cloudtecnologia.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import net.ddns.cloudtecnologia.model.entity.Endereco;
import net.ddns.cloudtecnologia.model.entity.Pessoa;
import net.ddns.cloudtecnologia.model.repository.EnderecoRepository;
import net.ddns.cloudtecnologia.model.repository.PessoaRespository;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTOResponse;
import net.ddns.cloudtecnologia.rest.dto.PessoaDTO;
import net.ddns.cloudtecnologia.rest.dto.PessoaDTOResponse;
import net.ddns.cloudtecnologia.service.PessoaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    private PessoaRespository pessoaRespository;


    @Inject
    private EnderecoRepository enderecoRepository;


    @Override
    @Transactional
    public Response save(PessoaDTO dto) {
        Endereco endereco = enderecoRepository.findById(dto.getIdEndereco());
        if (endereco.getId() == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        pessoaRespository.persist(new Pessoa(dto, endereco));
        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(dto)
                .build();
    }

    @Override
    public Response findAll() {
        List<PessoaDTOResponse> lista = new ArrayList<>();
        pessoaRespository.findAll().stream().forEach(item -> lista.add(PessoaDTOResponse.converterParaDto(item)));
        return Response.ok(lista).build();
    }

    @Override
    public Response findById(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa);
        if (pessoa != null) {
            return Response.ok(PessoaDTOResponse.converterParaDto(pessoa)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @Transactional
    public Response deleteById(Long id) {
        Pessoa pessoa = pessoaRespository.findById(id);
        if (pessoa != null) {
            pessoaRespository.delete(pessoa);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @Transactional
    public Response updateById(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRespository.findById(id);
        if (pessoa != null) {
            pessoa.setNome(dto.getNome());
            pessoa.setCpf(dto.getCpf());
            pessoa.setDataNascimento(dto.getDataNascimento());
            pessoa.setEmail(dto.getEmail());
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(dto)
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public PanacheQuery<Pessoa> findByCpf(String cpf) {
        return pessoaRespository.findByCpf(cpf);
    }

    @Override
    public PanacheQuery<Pessoa> findByEmail(String email) {
        return pessoaRespository.findByEmail(email);
    }

    @Override
    public Response findEnderecoByIdPessoa(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa);
        List<Endereco> lista = enderecoRepository.findByPessoa(pessoa);
        if (pessoa != null) {
            return Response.ok(lista).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
