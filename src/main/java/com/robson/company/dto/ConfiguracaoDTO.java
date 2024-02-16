package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConfiguracaoDTO {

    private Long id;
    private Long moedaInicial;
    private Long pontuacaoPorAcerto;
    private String level;

}
