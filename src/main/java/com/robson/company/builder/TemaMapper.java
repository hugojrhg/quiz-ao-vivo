package com.robson.company.builder;

import com.robson.company.dto.TemaDTO;
import com.robson.company.model.Tema;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemaMapper {
    private final ModelMapper modelMapper;

    public TemaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TemaDTO toDTO(Tema tema) {
        return modelMapper.map(tema, TemaDTO.class);
    }

    public Tema toEntity(TemaDTO temaDTO) {
        return modelMapper.map(temaDTO, Tema.class);

    }
    public List<TemaDTO> toListDTO(List<Tema> temaList) {
        List<TemaDTO> listReturn = new ArrayList<>();
        for (Tema i: temaList){
            listReturn.add(toDTO(i));
        }
        return listReturn;
    }
    public List<Tema> toList(List<TemaDTO> temaList) {
        List<Tema> listReturn = new ArrayList<>();
        for (TemaDTO i: temaList){
            listReturn.add(toEntity(i));
        }
        return listReturn;
    }



}
