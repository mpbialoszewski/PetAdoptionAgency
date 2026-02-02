package com.mpb.petadoptionagency.dto;


import com.mpb.petadoptionagency.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}

