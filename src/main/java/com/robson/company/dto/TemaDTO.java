package com.robson.company.dto;

import com.robson.company.model.Questao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemaDTO {
    private String tema;

    private Long id;

    private List<Questao> questaoList = new ArrayList<>();
}
