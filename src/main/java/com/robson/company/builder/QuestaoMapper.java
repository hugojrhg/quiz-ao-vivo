package com.robson.company.builder;

import com.robson.company.dto.QuestaoDTO;
import com.robson.company.model.Questao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestaoMapper {

    private final ModelMapper modelMapper;


    public QuestaoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestaoDTO toDTO(Questao model) {

        return modelMapper.map(model, QuestaoDTO.class);
    }
    public Questao toEntity(QuestaoDTO dto) {

        return modelMapper.map(dto, Questao.class);
    }

    public List<QuestaoDTO> toListDTO(List<Questao> modelList) {
        return modelList.stream()
                .map(this::toDTO).toList();
    }

    public List<Questao> toList(List<QuestaoDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).toList();
    }
}
