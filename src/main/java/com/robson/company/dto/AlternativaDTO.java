package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlternativaDTO {

    private Long id;
    private String alternativa;
    private boolean ehCorreta;

}
