package com.mpb.petadoptionagency.controllers;


import com.mpb.petadoptionagency.entities.Pet;
import com.mpb.petadoptionagency.repositories.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
  private final PetRepository petRepository;

  public PetController(PetRepository petRepository){
      this.petRepository = petRepository;
  }
    @GetMapping
    public List<Pet> getPet() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createPet(@RequestBody Pet pet) throws URISyntaxException {
        Pet savedPet = petRepository.save(pet);
        return ResponseEntity.created(new URI("/clients/" + savedPet.getId())).body(savedPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Pet currentPet = petRepository.findById(id).orElseThrow(RuntimeException::new);
        currentPet.setName(pet.getName());
        currentPet.setAge(pet.getAge());
        currentPet.setPetType(pet.getPetType());
        currentPet.setFurColour(pet.getFurColour());
        currentPet.setLocation(pet.getLocation());
        currentPet = petRepository.save(pet);

        return ResponseEntity.ok(currentPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
