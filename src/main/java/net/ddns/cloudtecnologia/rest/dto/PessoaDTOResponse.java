package net.ddns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.cloudtecnologia.model.entity.Pessoa;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class PessoaDTOResponse {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;

    public static PessoaDTOResponse converterParaDto(Pessoa pessoa) {
        PessoaDTOResponse dto = new PessoaDTOResponse();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setDataNascimento(pessoa.getDataNascimento());
        dto.setCpf(pessoa.getCpf());
        dto.setEmail(pessoa.getEmail());
        return dto;
    }
}
