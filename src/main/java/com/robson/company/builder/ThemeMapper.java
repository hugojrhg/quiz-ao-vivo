package com.robson.company.builder;

import com.robson.company.dto.ThemeDTO;
import com.robson.company.model.Theme;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ThemeMapper {
    private final ModelMapper modelMapper;

    public ThemeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ThemeDTO toDTO(Theme theme) {
        return modelMapper.map(theme, ThemeDTO.class);
    }

    public Theme toEntity(ThemeDTO themeDTO) {
        return modelMapper.map(themeDTO, Theme.class);

    }
    public List<ThemeDTO> toListDTO(List<Theme> themeList) {
        List<ThemeDTO> listReturn = new ArrayList<>();
        for (Theme i: themeList){
            listReturn.add(toDTO(i));
        }
        return listReturn;
    }
    public List<Theme> toList(List<ThemeDTO> temaList) {
        List<Theme> listReturn = new ArrayList<>();
        for (ThemeDTO i: temaList){
            listReturn.add(toEntity(i));
        }
        return listReturn;
    }



}
