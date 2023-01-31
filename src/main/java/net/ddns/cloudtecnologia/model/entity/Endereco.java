package net.ddns.cloudtecnologia.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.cloudtecnologia.rest.dto.EnderecoDTOResponse;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String localidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 100)
    private String ibge;

    @Column(length = 100)
    private String gia;

    @Column(length = 2)
    private String ddd;

    @Column(length = 100)
    private String siafi;
    
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;


    //
    public Endereco(EnderecoDTOResponse dto) {
        this.cep = dto.getCep().replace("-", "");
        this.logradouro = dto.getLogradouro();
        this.complemento = dto.getComplemento();
        this.bairro = dto.getBairro();
        this.localidade = dto.getLocalidade();
        this.uf = dto.getUf();
        this.gia = dto.getGia();
        this.ddd = dto.getDdd();
        this.siafi = dto.getSiafi();
    }

}
