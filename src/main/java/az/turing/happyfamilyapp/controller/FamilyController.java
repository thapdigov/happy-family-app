package az.turing.happyfamilyapp.controller;

import az.turing.happyfamilyapp.entity.human.Family;
import az.turing.happyfamilyapp.entity.human.Human;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.service.FamilyService;

import java.util.List;
import java.util.Optional;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAll() {
        return familyService.getAllFamilies();
    }

    public void displayAll() {
        familyService.displayAllFamilies();
    }

    public Optional<List<Family>> getBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public Optional<List<Family>> getLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public Long countWithMembers(int count) {
        return familyService.countFamiliesWithFamilyMembers(count);
    }

    public Family createFamily(Human father, Human mother) {
        return familyService.createFamily(father, mother);
    }

    public boolean deleteByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public void burnChild(Family family, String masculine, String feminine) {
        familyService.burnChild(family, masculine, feminine);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int getCount() {
        return familyService.getFamiliesCount();
    }

    public Optional<Family> getByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}
