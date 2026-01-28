package com.mpb.petadoptionagency.dto;

import jakarta.validation.constraints.*;

public class PetDTO {

    private Long id;

    //Validation to prevent SQL injections
    @NotBlank(message="Name is required")
    private String name;
    @Min(0)
    private Long age;
    private String petType;
    private String furColour;

    @Size(max = 150)
// Allowed: letters, numbers, spaces, hyphens, and commas.
// Blocks - scripts and HTMLs
    @Pattern(regexp = "^[a-zA-Z0-9 ,-]*$", message = "Location contains invalid characters")
    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getFurColour() {
        return furColour;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
