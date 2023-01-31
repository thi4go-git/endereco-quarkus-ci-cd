package net.ddns.cloudtecnologia.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.cloudtecnologia.anottation.CPFUnico;
import net.ddns.cloudtecnologia.anottation.EMAILUnico;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull(message = "{campo.id_endereco.obrigatorio}")
    private LocalDate dataNascimento;

    @NotBlank(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    @CPFUnico
    private String cpf;

    @NotBlank(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    @EMAILUnico
    private String email;

    @NotNull(message = "{campo.id_endereco.obrigatorio}")
    private Long idEndereco;

}
