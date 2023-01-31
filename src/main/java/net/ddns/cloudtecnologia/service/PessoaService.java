package net.ddns.cloudtecnologia.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import net.ddns.cloudtecnologia.model.entity.Pessoa;
import net.ddns.cloudtecnologia.rest.dto.PessoaDTO;

import javax.ws.rs.core.Response;

public interface PessoaService {
    Response save(PessoaDTO dto);

    Response findAll();

    Response findById(Long id);

    Response deleteById(Long id);

    Response updateById(Long id, PessoaDTO dto);

    PanacheQuery<Pessoa> findByCpf(String cpf);

    PanacheQuery<Pessoa> findByEmail(String email);

    Response findEnderecoByIdPessoa(Long idPessoa);
}
