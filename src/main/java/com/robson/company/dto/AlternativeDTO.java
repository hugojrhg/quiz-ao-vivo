package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlternativeDTO {

    private Long id;
    private String alternative;
    private boolean itsCorrect;

}
