package net.ddns.cloudtecnologia.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import net.ddns.cloudtecnologia.model.entity.Endereco;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTO;


import javax.ws.rs.core.Response;

public interface EnderecoService {
    Response save(EnderecoDTO dto);

    Response findAll();

    Response deleteById(Long id);

    Response updateById(Long id, EnderecoDTO dto);

    PanacheQuery<Endereco> findByCep(String cep);

}
