package com.robson.company.builder;

import com.robson.company.dto.ConfiguracaoDTO;
import com.robson.company.model.Configuracao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConfiguracaoMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ConfiguracaoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ConfiguracaoDTO toDTO(Configuracao model){
        return modelMapper.map(model, ConfiguracaoDTO.class);
    }
    public Configuracao toEntity(ConfiguracaoDTO dto){
        return modelMapper.map(dto, Configuracao.class);
    }

    public List<ConfiguracaoDTO> toListDTO(List<Configuracao> modelList){
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public List<Configuracao> toList(List<ConfiguracaoDTO> modelList){
        return modelList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
