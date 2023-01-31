package net.ddns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.cloudtecnologia.anottation.CEPUnico;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @CEPUnico
    private String cep;

}
