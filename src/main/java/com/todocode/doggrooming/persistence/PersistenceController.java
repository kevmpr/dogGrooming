package com.todocode.doggrooming.persistence;

import com.todocode.doggrooming.logic.Owner;
import com.todocode.doggrooming.logic.Pet;
import com.todocode.doggrooming.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();

    public void save(Owner owner, Pet pet) {
        ownerJpa.create(owner);
        petJpa.create(pet);
    }
    
    public Pet getPet(int numClient) {
        return petJpa.findPet(numClient);
    }

    public List<Pet> getPets() {
        return petJpa.findPetEntities();
    }
    
    public void editPet(Pet pet) {
        try {
            petJpa.edit(pet);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePet(int numClient) {
        try {
            petJpa.destroy(numClient);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Owner findOwner(int id) {
        return ownerJpa.findOwner(id);
    }

    public void editOwner(Owner owner) {
        try {
            ownerJpa.edit(owner);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
