package net.ddns.cloudtecnologia.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import net.ddns.cloudtecnologia.model.entity.Endereco;
import net.ddns.cloudtecnologia.model.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {


    public PanacheQuery<Endereco> findByCep(String cep) {
        return find("cep =:cep", Parameters.with("cep", cep));
    }

    public List<Endereco> findByPessoa(Pessoa pessoa) {
        return (List<Endereco>) find("pessoa =:pessoa", Parameters.with("pessoa", pessoa));
    }

}
