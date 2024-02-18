package com.robson.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConfigurationDTO {

    private Long id;
    private Long initialCoins;
    private Long scorePerHit;
    private String level;

}
