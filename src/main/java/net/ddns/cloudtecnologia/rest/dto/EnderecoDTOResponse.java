package net.ddns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import net.ddns.cloudtecnologia.model.entity.Endereco;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Jacksonized
public class EnderecoDTOResponse {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    //
    public static EnderecoDTOResponse converterParaDto(Endereco endereco) {
        EnderecoDTOResponse dto = new EnderecoDTOResponse();
        dto.setId(endereco.getId());
        dto.setCep(endereco.getCep());
        dto.setLogradouro(endereco.getLogradouro());
        dto.setComplemento(endereco.getComplemento());
        dto.setBairro(endereco.getBairro());
        dto.setLocalidade(endereco.getLocalidade());
        dto.setUf(endereco.getUf());
        dto.setIbge(endereco.getIbge());
        dto.setGia(endereco.getGia());
        dto.setDdd(endereco.getDdd());
        dto.setSiafi(endereco.getSiafi());
        return dto;
    }

}
