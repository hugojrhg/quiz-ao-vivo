package com.robson.company.builder;

import com.robson.company.dto.ConfigurationDTO;
import com.robson.company.model.Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConfigurationMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ConfigurationMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ConfigurationDTO toDTO(Configuration model){
        return modelMapper.map(model, ConfigurationDTO.class);
    }
    public Configuration toEntity(ConfigurationDTO dto){
        return modelMapper.map(dto, Configuration.class);
    }

    public List<ConfigurationDTO> toListDTO(List<Configuration> modelList){
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public List<Configuration> toList(List<ConfigurationDTO> modelList){
        return modelList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
