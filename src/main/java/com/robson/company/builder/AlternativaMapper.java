package com.robson.company.builder;

import com.robson.company.dto.AlternativaDTO;
import com.robson.company.model.Alternativa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlternativaMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AlternativaMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public AlternativaDTO toDTO(Alternativa model){
        return modelMapper.map(model, AlternativaDTO.class);
    }
    public Alternativa toEntity(AlternativaDTO dto){
        return modelMapper.map(dto, Alternativa.class);
    }

    public List<AlternativaDTO> toListDTO(List<Alternativa> modelList){
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public List<Alternativa> toList(List<AlternativaDTO> modelList){
        return modelList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
