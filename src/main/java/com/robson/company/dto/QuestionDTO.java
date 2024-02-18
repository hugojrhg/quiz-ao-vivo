package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDTO {

    private Long id;
    private String theme;
    private String question;
    private List<AlternativeDTO> alternativeList;

}
