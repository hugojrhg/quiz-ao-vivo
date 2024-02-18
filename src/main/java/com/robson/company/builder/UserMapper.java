package com.robson.company.builder;


import com.robson.company.dto.UserDTO;
import com.robson.company.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User model) {
        return modelMapper.map(model, UserDTO.class);
    }

    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public List<UserDTO> toListDTO(List<User> modelList) {
        return modelList.stream()
                .map(this::toDTO).toList();
    }

    public List<User> toList(List<UserDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).toList();
    }

}
