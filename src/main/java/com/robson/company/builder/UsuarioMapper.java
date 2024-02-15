package com.robson.company.builder;


import com.robson.company.dto.UsuarioDTO;
import com.robson.company.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UsuarioDTO toDTO(Usuario model) {
        return modelMapper.map(model, UsuarioDTO.class);
    }

    public Usuario toEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    public List<UsuarioDTO> toListDTO(List<Usuario> modelList) {
        return modelList.stream()
                .map(this::toDTO).toList();
    }

    public List<Usuario> toList(List<UsuarioDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).toList();
    }

}
