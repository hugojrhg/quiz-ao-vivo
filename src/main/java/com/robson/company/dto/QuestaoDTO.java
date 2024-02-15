package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDTO {

    private Long id;
    private String tema;
    private String pergunta;
    private String resposta;
    private List<AlternativaDTO> alternativas;

}
