 package com.todocode.doggrooming.logic;

import com.todocode.doggrooming.persistence.PersistenceController;
import java.util.List;

public class Controller {
    PersistenceController persisControl = new PersistenceController();

    public void save(String name, String breed, String color, 
            String observations, String allergic, String specialAttention, 
            String ownerName, String ownerCellphone) {
        
        Owner owner = new Owner();
        owner.setName(ownerName);
        owner.setCellphone(ownerCellphone);
        
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setAllergic(allergic);
        pet.setSpecialAttention(specialAttention);
        pet.setObservations(observations);
        pet.setOwner(owner);
        
        persisControl.save(owner, pet);
    }

    public List<Pet> getPets() {     
        return persisControl.getPets();
    }

    public void deletePet(int numClient) {
        persisControl.deletePet(numClient);
    }

    public Pet getPet(int numClient) {
        return persisControl.getPet(numClient);
    }

    public void saveChanges(Pet pet, String name, String breed, String color, 
            String observations, String allergic, String specialAttention, 
            String ownerName, String ownerCellphone) {
        pet.setName(name);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setObservations(observations);
        pet.setAllergic(allergic);
        pet.setSpecialAttention(specialAttention);
        
        this.editPet(pet);
        
        Owner owner = this.findOwner(pet.getOwner().getId());
        owner.setName(ownerName);
        owner.setCellphone(ownerCellphone);
        
        this.editOwner(owner);
    }
    
    public Owner findOwner(int id){
        return persisControl.findOwner(id);
    }
    
    public void editPet(Pet pet){
        persisControl.editPet(pet);
    }
    
    public void editOwner(Owner owner){
        persisControl.editOwner(owner);
    }
}
