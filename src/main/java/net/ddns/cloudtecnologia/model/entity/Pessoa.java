package net.ddns.cloudtecnologia.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.cloudtecnologia.rest.dto.PessoaDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "pessoa")
    List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(PessoaDTO dto, Endereco endereco) {
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
        this.enderecos.add(endereco);
    }
}
