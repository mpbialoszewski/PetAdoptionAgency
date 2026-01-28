package com.mpb.petadoptionagency.dto;

import com.mpb.petadoptionagency.entities.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // This is the "flag"
public interface PetMapper {

    PetDTO toDTO(Pet pet);
    Pet toEntity(PetDTO petDto);
    List<PetDTO> toDTOs(List<Pet> pets); // Converts DTO -> Entity (saving to Database)
}
