package net.ddns.cloudtecnologia.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import net.ddns.cloudtecnologia.model.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRespository implements PanacheRepository<Pessoa> {

    public PanacheQuery<Pessoa> findByCpf(String cpf) {
        return find("cpf =:cpf", Parameters.with("cpf", cpf));
    }

    public PanacheQuery<Pessoa> findByEmail(String email) {
        return find("email =:email", Parameters.with("email", email));
    }

}
